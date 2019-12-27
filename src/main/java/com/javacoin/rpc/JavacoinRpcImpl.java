package com.javacoin.rpc;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.javacoin.exception.ApiCallRpcException;
import com.javacoin.exception.InvalidCredentialsException;
import com.javacoin.exception.JavacoinRpcException;
import com.javacoin.model.Block;
import com.javacoin.model.GetInfo;
import com.javacoin.model.JsonRequest;
import com.javacoin.model.LockUnspent;
import com.javacoin.model.MiningInfo;
import com.javacoin.model.PeerInfo;
import com.javacoin.model.ReceivedAccount;
import com.javacoin.model.ReceivedAddress;
import com.javacoin.model.Transaction;
import com.javacoin.model.TransactionDecoded;
import com.javacoin.model.TxOutSetInfo;
import com.javacoin.model.Unspent;
import com.javacoin.util.JavacoinExceptionChecker;
import com.javacoin.util.RpcMethods;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JavacoinRpcImpl implements JavacoinRpc {

	private final static String UNCHECKED = "unchecked";
	private final static String IS_VALID = "isvalid";
	private final static String ERROR = "error";
	private final static String RESULT = "result";
	private final static String HTTP_PREFIX = "http://";
	private final static String COLON = ":";
	private final static String FORWARD_SLASH = "/";
	private final static String NEW_LINE = "\n";
	private final static ContentType CONTENT_TYPE = ContentType.create("application/json", StandardCharsets.UTF_8);

	private final Gson gson = new Gson();
	private CloseableHttpClient client;
	private PoolingHttpClientConnectionManager connectionManager;
	private String url;
	private final JavacoinExceptionChecker exceptionChecker = new JavacoinExceptionChecker();

	public JavacoinRpcImpl(String username, String password, String host, int port) throws InvalidCredentialsException {
		try {

			url = HTTP_PREFIX + host + COLON + port + FORWARD_SLASH;

			CredentialsProvider provider = ConnectionHelper.BasicCredentialsProvider(username, password);
			
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(100);
			connectionManager.setDefaultMaxPerRoute(10);
	

		   client = HttpClientBuilder.create()
					.setConnectionManager(connectionManager)					
					.setDefaultCredentialsProvider(provider)
					.build();

			HttpResponse response = client.execute(new HttpGet(url));

			if (HttpStatus.SC_UNAUTHORIZED == response.getStatusLine().getStatusCode()) {
				throw new InvalidCredentialsException();
			}

		} catch (Exception e) {
			log.error("Authenticating with javacoin server failed.", e);
		}
	}
	
	@Override
	public void addNode(String ip, String command) throws JavacoinRpcException {
		callRpcMethod(RpcMethods.ADD_NODE, ip, command);
	}

	@Override
	public boolean backupWallet(String destination) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.BACKUP_WALLET, destination);
		return Objects.isNull(jsonObj.get(ERROR)) ? true : false;
	}

	@Override
	public TransactionDecoded decodeRawTransaction(String hex) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.DECODE_RAW_TRANSACTION, hex);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonObject(), TransactionDecoded.class);
	}

	@Override
	public String dumpPrivateKey(String address) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.DUMP_PRIVATE_KEY, address);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public String getRawTransaction(String txid) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_RAW_TRANSACTION, txid);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public String getBlockHash(int height) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_BLOCK_HASH, height);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public Block getBlock(String hash) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_BLOCK, hash);
		return gson.fromJson(jsonObj.get(RESULT), Block.class);
	}

	@Override
	public GetInfo getInfo() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_INFO);
		return gson.fromJson(jsonObj.get(RESULT), GetInfo.class);
	}

	@Override
	public BigInteger getNetworkHashps() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_NETWORK_HASHPS);
		return jsonObj.get(RESULT).getAsBigInteger();
	}

	@Override
	public BigInteger getNetworkHashps(int NumberOfBlocks) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_NETWORK_HASHPS, NumberOfBlocks);
		return jsonObj.get(RESULT).getAsBigInteger();
	}

	@Override
	public BigInteger getNetworkHashps(int NumberOfBlocks, int blockHeight) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_NETWORK_HASHPS, NumberOfBlocks, blockHeight);
		return jsonObj.get(RESULT).getAsBigInteger();
	}

	@Override
	public List<String> help() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.HELP);
		return Arrays.asList(jsonObj.get(RESULT).getAsString().split(NEW_LINE));
	}

	@Override
	public List<String> help(String command) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.HELP, command);
		return Arrays.asList(jsonObj.get(RESULT).getAsString().split(NEW_LINE));
	}

	@Override
	public String getAccount(String address) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_ACCOUNT, address);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public String getAccountAddress(String account) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_ACCOUNT_ADDRESS, account);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public List<String> getAddressesByAccount(String account) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_ADDRESSES_BY_ACCOUNT, account);
		return Arrays.asList(gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), String[].class));
	}

	@Override
	public BigDecimal getBalance() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_BALANCE);
		return jsonObj.get(RESULT).getAsBigDecimal();
	}

	@Override
	public BigDecimal getBalance(String account) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_BALANCE, account);
		return jsonObj.get(RESULT).getAsBigDecimal();
	}

	@Override
	public BigDecimal getReceivedByAccount(String account) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_RECEIVED_BY_ACCOUNT, account);
		return jsonObj.get(RESULT).getAsBigDecimal();
	}

	@Override
	public String getNewAddress() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_NEW_ADDRESS);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public String getNewAddress(String account) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_NEW_ADDRESS, account);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public BigDecimal getReceivedByAddress(String address) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_RECEIVED_BY_ADDRESS, address);
		return jsonObj.get(RESULT).getAsBigDecimal();
	}

	@Override
	public Transaction getTransaction(String txid) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_TRANSACTION, txid);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonObject(), Transaction.class);
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public Map<String, BigDecimal> listAccounts() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_ACCOUNTS);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonObject(), Map.class);
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public List<ReceivedAccount> listReceivedByAccount() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_RECEIVED_BY_ACCOUNT);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), List.class);
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public List<ReceivedAddress> listReceivedByAddress() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_RECEIVED_BY_ADDRESS);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), List.class);
	}

	@Override
	public String sendFrom(String fromAccount, String toAddress, BigDecimal amount) throws JavacoinRpcException {
		JsonObject response = callRpcMethod(RpcMethods.SEND_FROM, fromAccount, toAddress, amount);
		return response.get(RESULT).getAsString();
	}

	@Override
	public String sendToAddress(String toAddress, BigDecimal amount) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.SEND_TO_ADDRESS, toAddress, amount);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public void setAccount(String address, String account) throws JavacoinRpcException {
		callRpcMethod(RpcMethods.SET_ACCOUNT, address, account);
	}

	@Override
	public List<Transaction> listTransactions(String account, int count, int from) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_TRANSACTIONS, account, count, from);
		return Arrays.asList(gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), Transaction[].class));
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public List<Unspent> listUnspent(int minconf, int maxconf) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_UNSPENT, minconf, maxconf);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), List.class);
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public List<Unspent> listUnspent(int minconf, String[] address) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_UNSPENT, minconf, address);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), List.class);
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public List<Unspent> listUnspent(int minconf) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_UNSPENT, minconf);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), List.class);
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public List<Unspent> listUnspent(int minconf, int maxconf, String[] address) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_UNSPENT, minconf, maxconf, address);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), List.class);
	}

	@Override
	public Transaction createRawTransaction(JsonObject[] prevOut, JsonObject out) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.CREATE_RAW_TRANSACTION, prevOut, out);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonObject(), Transaction.class);
	}

	@Override
	public Transaction signRawTransaction(String hexString) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.SIGN_RAW_TRANSACTION, hexString);
		return gson.fromJson(jsonObj.get(RESULT).getAsJsonObject(), Transaction.class);
	}

	@Override
	public String sendRawTransaction(String hexString) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.SEND_RAW_TRANSACTION, hexString);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public List<PeerInfo> getPeerInfo() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_PEER_INFO);
		return Arrays.asList(gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), PeerInfo[].class));
	}

	@Override
	public BigDecimal getDifficulty() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_DIFFICULTY);
		return jsonObj.get(RESULT).getAsBigDecimal();
	}

	@Override
	public MiningInfo getMiningInfo() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_MINING_INFO);
		return gson.fromJson(jsonObj.get(RESULT), MiningInfo.class);
	}

	@Override
	public int getBlockCount() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_BLOCK_COUNT);
		return jsonObj.get(RESULT).getAsInt();
	}

	@Override
	public TxOutSetInfo getTxOutSetInfo() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.GET_TX_OUT_SET_INFO);
		return gson.fromJson(jsonObj.get(RESULT), TxOutSetInfo.class);
	}

	@Override
	public boolean setTxFee(double amount) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.SET_TX_FEE, amount);
		return jsonObj.get(RESULT).getAsBoolean();
	}

	@Override
	public List<LockUnspent> listLockUnspent() throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.LIST_LOCK_UNSPENT);
		return Arrays.asList(gson.fromJson(jsonObj.get(RESULT).getAsJsonArray(), LockUnspent[].class));
	}

	@Override
	public String sendMany(String from, Map<String, BigDecimal> addressAmountMap, int minConfirmations)
			throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.SEND_MANY, from, addressAmountMap, minConfirmations);
		return jsonObj.get(RESULT).getAsString();
	}

	@Override
	public boolean move(String fromAccount, String toAccount, BigDecimal amount, int minConfirmations)
			throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.MOVE, fromAccount, toAccount, amount, minConfirmations);
		return jsonObj.get(RESULT).getAsBoolean();
	}

	@Override
	public boolean validateAddress(String address) throws JavacoinRpcException {
		JsonObject jsonObj = callRpcMethod(RpcMethods.VALIDATE_ADDRESS, address);
		return jsonObj.get(RESULT).getAsJsonObject().get(IS_VALID).getAsBoolean();
	}
	
	@Override
	public void closeClient() throws IOException {
		client.close();
	}

	private JsonObject callRpcMethod(RpcMethods callMethod, Object... params) throws ApiCallRpcException {
		try {

			JsonRequest body = new JsonRequest();
			//body.setId(UUID.randomUUID().toString());
			body.setMethod(callMethod.toString());
			if (Objects.nonNull(params) && params.length > 0) {
				body.setParams(params);
			}
			String requestJson = gson.toJson(body);

			HttpPost postRequest = new HttpPost(url);
			postRequest.setEntity(new StringEntity(requestJson, CONTENT_TYPE));

			CloseableHttpResponse response = client.execute(postRequest);

			String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
			response.close();
			
			JsonObject jsonObj = JsonParser.parseString(responseString).getAsJsonObject();

			JsonElement jElement = jsonObj.get(ERROR);
			if (Objects.nonNull(jElement) && jElement.isJsonObject()) {
				exceptionChecker.checkForError(jElement, callMethod);
			}

			return jsonObj;
		} catch (Exception e) {
			throw new ApiCallRpcException(e.getMessage());
		}
	}



}
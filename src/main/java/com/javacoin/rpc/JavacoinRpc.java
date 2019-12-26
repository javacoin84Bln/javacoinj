package com.javacoin.rpc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.javacoin.exception.JavacoinRpcException;
import com.javacoin.model.Block;
import com.javacoin.model.GetInfo;
import com.javacoin.model.LockUnspent;
import com.javacoin.model.MiningInfo;
import com.javacoin.model.PeerInfo;
import com.javacoin.model.ReceivedAccount;
import com.javacoin.model.ReceivedAddress;
import com.javacoin.model.Transaction;
import com.javacoin.model.TransactionDecoded;
import com.javacoin.model.TxOutSetInfo;
import com.javacoin.model.Unspent;

public interface JavacoinRpc {

	void addNode(String ip, String command) throws JavacoinRpcException;

	boolean backupWallet(String destination) throws JavacoinRpcException;

	TransactionDecoded decodeRawTransaction(String hex) throws JavacoinRpcException;

	String dumpPrivateKey(String address) throws JavacoinRpcException;

	String getRawTransaction(String txid) throws JavacoinRpcException;

	String getBlockHash(int height) throws JavacoinRpcException;

	Block getBlock(String hash) throws JavacoinRpcException;

	GetInfo getInfo() throws JavacoinRpcException;

	BigInteger getNetworkHashps() throws JavacoinRpcException;

	BigInteger getNetworkHashps(int NumberOfBlocks) throws JavacoinRpcException;

	BigInteger getNetworkHashps(int NumberOfBlocks, int blockHeight) throws JavacoinRpcException;

	List<String> help() throws JavacoinRpcException;
	
	List<String> help(String command) throws JavacoinRpcException;

	String getAccount(String address) throws JavacoinRpcException;

	String getAccountAddress(String account) throws JavacoinRpcException;

	List<String> getAddressesByAccount(String account) throws JavacoinRpcException;

	BigDecimal getBalance() throws JavacoinRpcException;

	BigDecimal getBalance(String account) throws JavacoinRpcException;

	BigDecimal getReceivedByAccount(String account) throws JavacoinRpcException;

	String getNewAddress() throws JavacoinRpcException;

	String getNewAddress(String account) throws JavacoinRpcException;

	BigDecimal getReceivedByAddress(String address) throws JavacoinRpcException;

	Transaction getTransaction(String txid) throws JavacoinRpcException;

	Map<String, BigDecimal> listAccounts() throws JavacoinRpcException;

	List<ReceivedAccount> listReceivedByAccount() throws JavacoinRpcException;

	List<ReceivedAddress> listReceivedByAddress() throws JavacoinRpcException;

	String sendFrom(String fromAccount, String toAddress, BigDecimal amount) throws JavacoinRpcException;

	String sendToAddress(String toAddress, BigDecimal amount) throws JavacoinRpcException;

	void setAccount(String address, String account) throws JavacoinRpcException;

	List<Transaction> listTransactions(String account, int count, int from) throws JavacoinRpcException;

	List<Unspent> listUnspent(int minconf, int maxconf) throws JavacoinRpcException;

	List<Unspent> listUnspent(int minconf, String[] address) throws JavacoinRpcException;

	List<Unspent> listUnspent(int minconf) throws JavacoinRpcException;

	List<Unspent> listUnspent(int minconf, int maxconf, String[] address) throws JavacoinRpcException;

	Transaction createRawTransaction(JsonObject[] prevOut, JsonObject out) throws JavacoinRpcException;

	Transaction signRawTransaction(String hexString) throws JavacoinRpcException;

	String sendRawTransaction(String hexString) throws JavacoinRpcException;

	List<PeerInfo> getPeerInfo() throws JavacoinRpcException;

	BigDecimal getDifficulty() throws JavacoinRpcException;

	MiningInfo getMiningInfo() throws JavacoinRpcException;

	int getBlockCount() throws JavacoinRpcException;

	TxOutSetInfo getTxOutSetInfo() throws JavacoinRpcException;

	boolean setTxFee(double amount) throws JavacoinRpcException;

	List<LockUnspent> listLockUnspent() throws JavacoinRpcException;

	String sendMany(String from, Map<String, BigDecimal> addressAmountMap, int minConfirmations)
			throws JavacoinRpcException;

	boolean move(String fromAccount, String toAccount, BigDecimal amount, int minConfirmations)
			throws JavacoinRpcException;

	boolean validateAddress(String address) throws JavacoinRpcException;



}
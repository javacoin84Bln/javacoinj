package com.javacoin.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RpcMethods {

	ADD_NODE("addnode"),
	BACKUP_WALLET("backupwallet"),
	CREATE_RAW_TRANSACTION("createrawtransaction"),
	DECODE_RAW_TRANSACTION("decoderawtransaction"),  
    DUMP_PRIVATE_KEY("dumpprivkey"),
    ENCRYPT_WALLET("encryptwallet"),	
    GET_NEW_ADDRESS("getnewaddress"),
    GET_ACCOUNT("getaccount"),
    GET_ACCOUNT_ADDRESS("getaccountaddress"),
    GET_ADDRESSES_BY_ACCOUNT("getaddressesbyaccount"),
    GET_RECEIVED_BY_ACCOUNT("getreceivedbyaccount"),
    GET_RECEIVED_BY_ADDRESS("getreceivedbyaddress"),
    GET_BALANCE("getbalance"),
    GET_TRANSACTION("gettransaction"),
    GET_CONNECTION_COUNT("getconnectioncount"),
    GET_RAW_TRANSACTION("getrawtransaction"),
    GET_INFO("getinfo"),
	GET_PEER_INFO("getpeerinfo"),
	GET_DIFFICULTY("getdifficulty"),
	GET_MINING_INFO("getmininginfo"),
	GET_BLOCK_COUNT("getblockcount"),
	GET_BLOCK("getblock"),
	GET_BLOCK_HASH("getblockhash"),
	GET_TX_OUT_SET_INFO("gettxoutsetinfo"),
	GET_NETWORK_HASHPS("getnetworkhashps"),
	HELP("help"),
    LIST_TRANSACTIONS("listtransactions"),
    LIST_UNSPENT("listunspent"),
    LIST_ACCOUNTS("listaccounts"),
    LIST_ADDRESS_GROUPINGS("listaddressgroupings"),
    LIST_RECEIVED_BY_ACCOUNT("listreceivedbyaccount"),
    LIST_RECEIVED_BY_ADDRESS("listreceivedbyaddress"),
    LIST_LOCK_UNSPENT("listlockunspent"),
    MOVE("move"),	
    SEND_FROM("sendfrom"),
    SEND_MANY("sendmany"),
    SEND_RAW_TRANSACTION("sendrawtransaction"),
    SET_ACCOUNT("setaccount"),
    SEND_TO_ADDRESS("sendtoaddress"),    
    SIGN_RAW_TRANSACTION("signrawtransaction"),
	SET_TX_FEE("settxfee"),		
	VALIDATE_ADDRESS("validateaddress");

	private String value;
	
	@Override
	public String toString() {
		return value;
	}
	
	
	
}

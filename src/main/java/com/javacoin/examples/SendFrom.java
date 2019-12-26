package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class SendFrom extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);	
		
		String account ="Account name";
		String toAddress = "Javacoin Address";
		BigDecimal amount = new BigDecimal(1.0);
		
		String txId = javacoinRpc.sendFrom(account, toAddress, amount); 
		System.out.println(txId);
		
	}

}

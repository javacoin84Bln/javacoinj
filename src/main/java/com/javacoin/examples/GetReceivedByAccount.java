package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetReceivedByAccount extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
	
		BigDecimal amount = javacoinRpc.getReceivedByAccount("");
		System.out.println(amount);
	}


}

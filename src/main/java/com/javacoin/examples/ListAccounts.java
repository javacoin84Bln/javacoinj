package com.javacoin.examples;

import java.math.BigDecimal;
import java.util.Map;

import com.javacoin.rpc.JavacoinRpc;

public class ListAccounts extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
	
		 Map<String,BigDecimal> accounts = javacoinRpc.listAccounts();
		 System.out.println(accounts);	
		
	}

}

package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetAccountAddress extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		String default_ = javacoinRpc.getAccountAddress(""); 
		String a = javacoinRpc.getAccountAddress("a"); 	
		
		System.out.println("default account :"+default_);
		System.out.println("Account a :"+a);
	
	}

}

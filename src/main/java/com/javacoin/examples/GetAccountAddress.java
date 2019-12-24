package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;

public class GetAccountAddress extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		String default_ = javacoinRpc.getAccountAddress(""); 
		String a = javacoinRpc.getAccountAddress("a"); 	
		
		System.out.println("default account :"+default_);
		System.out.println("Account a :"+a);
	
	}

}

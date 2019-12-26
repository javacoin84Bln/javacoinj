package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class RawTransaction extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
	
		String rawTransaction = javacoinRpc.getRawTransaction("1ce63d0599b0aa053207409cb2b780500d1e59339829f7d167faa89d6efc2779");
		System.out.println(rawTransaction);
	}


}

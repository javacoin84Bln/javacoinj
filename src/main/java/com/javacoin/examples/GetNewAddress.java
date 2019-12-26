package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetNewAddress extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
			
		String address = javacoinRpc.getNewAddress();
		System.out.println(address);
		
		
		String address2 = javacoinRpc.getNewAddress("jvc");
		System.out.println(address2);
	}


}

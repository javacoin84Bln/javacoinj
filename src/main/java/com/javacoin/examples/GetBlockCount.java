package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;

public class GetBlockCount extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		int pb = javacoinRpc.getBlockCount();
		System.out.println("blocks count :"+pb);
	
	}

}

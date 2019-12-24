package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;

public class GetBlockHash extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
	
		String eax = javacoinRpc.getBlockHash(200);
		System.out.println("Blockhash : " + eax);
	}

}

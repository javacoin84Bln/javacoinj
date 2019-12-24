package com.javacoin.examples;

import com.javacoin.model.MiningInfo;
import com.javacoin.rpc.JavacoinRpc;

public class GetMiningInfo extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		MiningInfo px = javacoinRpc.getMiningInfo();
		System.out.println(px);
	}

}

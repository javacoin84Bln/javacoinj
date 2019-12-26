package com.javacoin.examples;

import com.javacoin.model.Block;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;
import com.javacoin.util.RpcMethods;

public class MultiMethods extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		javacoinRpc.getAccountAddress("");
		javacoinRpc.getNetworkHashps();
		//System.out.println("1");
		javacoinRpc.getMiningInfo();
		javacoinRpc.getAccountAddress("a"); 	
		//System.out.println("2");
		String blockHash = "f53ce360cdcb4a1ad539c7431bf94f6d1cd24a3722df738b7e1fdad83b2ff105";
		javacoinRpc.getBlock(blockHash);
		javacoinRpc.help();
		//System.out.println("3");
		javacoinRpc.help(RpcMethods.GET_ACCOUNT.toString());
		//System.out.println("4");
		javacoinRpc.getBalance();
		//System.out.println("5");
		javacoinRpc.getBalance("");
		//System.out.println("6");
		javacoinRpc.getBlockCount();
		//System.out.println("7");
		javacoinRpc.getInfo();
		System.out.println("8");

		System.out.println("");
	
	}

}

package com.javacoin.examples;

import com.javacoin.model.Block;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetBlock extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
	
		Block block = javacoinRpc.getBlock("f53ce360cdcb4a1ad539c7431bf94f6d1cd24a3722df738b7e1fdad83b2ff105");
		System.out.println(block);
	}


}

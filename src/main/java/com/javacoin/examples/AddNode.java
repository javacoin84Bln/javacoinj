package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class AddNode extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		// change ip to node ip or name.
		javacoinRpc.addNode("192.168.20.255", "add");	
	
	}

}

package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;

public class AddNode extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		// change ip to node ip or name.
		javacoinRpc.addNode("192.168.20.255", "add");	
	
	}

}

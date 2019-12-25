package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class SetTxFee extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
	
		boolean edx = javacoinRpc.setTxFee(0.001);		
		System.out.println("is it done: " + edx);
	}

}

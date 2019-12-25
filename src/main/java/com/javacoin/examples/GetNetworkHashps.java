package com.javacoin.examples;

import java.math.BigInteger;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetNetworkHashps extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
	
		
		BigInteger a = 	javacoinRpc.getNetworkHashps();		
		BigInteger b = 	javacoinRpc.getNetworkHashps(160);		
		BigInteger c = 	javacoinRpc.getNetworkHashps(200,1500000);
		
		System.out.println(a+" "+b+" "+c+" ");
	
	}

}

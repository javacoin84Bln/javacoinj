package com.javacoin.examples;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class ValidateAddress  extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		boolean result = javacoinRpc.validateAddress("JSDDRfTXRCSvn2bHKkEBApEVmj5ukecrtd");
        System.out.println(result);
	}

}

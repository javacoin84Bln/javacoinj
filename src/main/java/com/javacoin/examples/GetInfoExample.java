package com.javacoin.examples;

import com.javacoin.model.GetInfo;
import com.javacoin.rpc.JavacoinRpc;

public class GetInfoExample extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		GetInfo bx = javacoinRpc.getInfo(); 
		System.out.println(bx);
		
	
	}

}

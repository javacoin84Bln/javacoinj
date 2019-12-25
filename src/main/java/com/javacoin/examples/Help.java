package com.javacoin.examples;

import java.util.List;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class Help extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);		
	
		List<String> cx = javacoinRpc.help(); 
		cx.forEach(System.out::println);
		
	}

}

package com.javacoin.examples;

import java.util.List;

import com.javacoin.rpc.JavacoinRpc;

public class Help extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);		
	
		List<String> cx = javacoinRpc.help(); 
		cx.forEach(System.out::println);
		
	}

}

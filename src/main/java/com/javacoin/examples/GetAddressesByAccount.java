package com.javacoin.examples;

import java.util.List;

import com.javacoin.rpc.JavacoinRpc;

public class GetAddressesByAccount extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		List<String> ax =	javacoinRpc.getAddressesByAccount("abc");
		List<String> ax2 =	javacoinRpc.getAddressesByAccount("abcx");
		List<String> ax3 =	javacoinRpc.getAddressesByAccount("sss");
		
		System.out.println(ax);
		System.out.println(ax2);
		System.out.println(ax3);
	
	}

}

package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;

public class GetDifficulty extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		BigDecimal ex = javacoinRpc.getDifficulty();
		System.out.println(ex);
		
	
	}

}

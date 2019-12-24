package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;

public class Move extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
	    // change account and amount.
		boolean moveR = javacoinRpc.move("sss", "b", new BigDecimal("24.09071"), 1);	
		System.out.println(moveR);
		
	}

}

package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class Move extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
	    // change account and amount.
		boolean moveR = javacoinRpc.move("sss", "b", new BigDecimal("24.09071"), 1);	
		System.out.println(moveR);
		
	}

}

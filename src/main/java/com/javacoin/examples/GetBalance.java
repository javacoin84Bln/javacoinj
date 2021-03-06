package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetBalance extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
        
		BigDecimal default_ = javacoinRpc.getBalance();
		BigDecimal ax = javacoinRpc.getBalance("a");
		
		System.out.println("balance in wallet: "+default_ );
		System.out.println("balance in account: "+ax);
	
	}

}

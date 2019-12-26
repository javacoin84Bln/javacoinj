package com.javacoin.examples;

import java.math.BigDecimal;

import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetReceivedByAddress extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
	
		BigDecimal amount = javacoinRpc.getReceivedByAddress("JStNEoPKQjye1bmLz1D6v47o3QGLYEcnde");
	   System.out.println(amount);
	}


}

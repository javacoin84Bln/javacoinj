package com.javacoin.examples;

import com.javacoin.model.Transaction;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class GetTransaction extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		// change transaction 
		Transaction t =	javacoinRpc.getTransaction("273c5049e7e5f9ad65f770b8cbb7819f695511d496052056ac040313a290cdea");
		System.out.println(t);
	
	}

}

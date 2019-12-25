package com.javacoin.examples;

import java.util.List;

import com.javacoin.model.ReceivedAccount;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class ListReceivedByAccount extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
			
		 List<ReceivedAccount> rAccounts = javacoinRpc.listReceivedByAccount();
		 System.out.println(rAccounts);	
	}

}

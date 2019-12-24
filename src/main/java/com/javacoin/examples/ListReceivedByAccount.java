package com.javacoin.examples;

import java.util.List;

import com.javacoin.model.ReceivedAccount;
import com.javacoin.rpc.JavacoinRpc;

public class ListReceivedByAccount extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
			
		 List<ReceivedAccount> rAccounts = javacoinRpc.listReceivedByAccount();
		 System.out.println(rAccounts);	
	}

}

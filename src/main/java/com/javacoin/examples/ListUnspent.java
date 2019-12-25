package com.javacoin.examples;

import java.util.List;

import com.javacoin.model.Unspent;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class ListUnspent extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		// change minConf
		 List<Unspent> unspentLst = javacoinRpc.listUnspent(10);
		 System.out.println(unspentLst);	
		
	}

}

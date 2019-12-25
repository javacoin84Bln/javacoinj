package com.javacoin.examples;

import java.util.List;

import com.javacoin.model.LockUnspent;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class ListLockUnspent extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		
		List<LockUnspent> lst = javacoinRpc.listLockUnspent();
		System.out.println(lst);
	
	}

}

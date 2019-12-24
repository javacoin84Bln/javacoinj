package com.javacoin.examples;

import java.util.List;

import com.javacoin.model.LockUnspent;
import com.javacoin.rpc.JavacoinRpc;

public class ListLockUnspent extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		
		List<LockUnspent> lst = javacoinRpc.listLockUnspent();
		System.out.println(lst);
	
	}

}

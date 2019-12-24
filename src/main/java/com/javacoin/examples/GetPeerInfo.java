package com.javacoin.examples;

import java.util.List;

import com.javacoin.model.PeerInfo;
import com.javacoin.rpc.JavacoinRpc;

public class GetPeerInfo extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		List<PeerInfo> dx = javacoinRpc.getPeerInfo();
		System.out.println(dx);
	
	}

}

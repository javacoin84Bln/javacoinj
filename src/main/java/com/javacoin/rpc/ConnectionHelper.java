package com.javacoin.rpc;

import java.util.UUID;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;

import com.javacoin.model.JsonRequest;


public class ConnectionHelper {
	
	public static CredentialsProvider BasicCredentialsProvider(String username, String password){
		
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		
		return provider;
		
	}
	
	public static String getId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	public static JsonRequest getNewRequest(String method, Object[] params, String id) {
		JsonRequest rpcRequest = new JsonRequest();
		rpcRequest.setMethod(method);
		rpcRequest.setParams(params);
		rpcRequest.setId(id);
		return rpcRequest;
	}

}

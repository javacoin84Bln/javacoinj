package com.javacoin.examples;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.javacoin.rpc.JavacoinRpc;

public class SendMany extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
		
		// change map entries, addresses and amounts. 
		Map<String,BigDecimal> hm = new HashMap<>();	
		hm.put("JcxQSHp854vYWXt5fGdmH2WXRG6P6wStSF", new BigDecimal("100.0"));
		hm.put("JRU2wFMC7ZXLTe6TM8rvtBae15Yr7G54fq", new BigDecimal("200.0"));
		hm.put("JMdtBpLakStnjygjy5DjzB3nwgxkrgZEMB", new BigDecimal("200.0"));
	 
	  // change sss to your account name	
	   String txID = javacoinRpc.sendMany("sss", hm, 1);
	   System.out.println(txID);
		
	
	}

}

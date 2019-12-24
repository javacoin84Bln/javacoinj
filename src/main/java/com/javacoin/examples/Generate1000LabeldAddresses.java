package com.javacoin.examples;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.javacoin.rpc.JavacoinRpc;


public class Generate1000LabeldAddresses extends ConnectionData{

	private static DecimalFormat df2 = new DecimalFormat(".#######");

	
	private static int amountToSend = 56276207;
	private static String fromAccount = "a"   ;
	private static int N = 998;

	public static void main(String[] args) throws Exception {
	   getNewAddress();
	}
	
	public static void getNewAddress() throws Exception {
		
	    JavacoinRpc javacoinRpc = new JavacoinRpc(username, password, host, port);
			
		List<String> labels = IntStream.range(0, N).mapToObj(i -> String.format("%03d", i)).collect(Collectors.toList());
			
		long t1 = System.nanoTime();
		List<String>  addresses = labels.stream().map(account -> javacoinRpc.getAccountAddress(account))
		.collect(Collectors.toList());
		long t2 = System.nanoTime();
		System.out.println("\n\n\n\n\n");
		System.out.println("====||==== "+ (t2-t1));
		System.out.println("\n\n\n\n\n");
		
		int i =0;
		Random rand = new Random();
		double fix = 2* (amountToSend/addresses.size());
		double last = rand.nextDouble() * fix;
        String AllToSend = "sendmany "+fromAccount+" '{";
		
		for(String address : addresses){
			
			if((i % 2) == 0){		
			 AllToSend += "\""+address+"\":"+df2.format(last)+",";	
			}else{
				AllToSend += "\""+address+"\":"+df2.format(fix-last)+",";	
				last = rand.nextDouble() * fix;
			}
			
			i++;
		}
		
		AllToSend = AllToSend.replaceAll("[,]$", "");
		AllToSend += "}'";

		System.out.println(AllToSend);
	}
	
	
}

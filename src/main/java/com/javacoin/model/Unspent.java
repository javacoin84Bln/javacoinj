package com.javacoin.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unspent {
	
	private String txid;
	private int vout;
	private String address;
	private String account;
	private String scriptPubKey;
	private BigDecimal amount;
	private int confirmations;

}

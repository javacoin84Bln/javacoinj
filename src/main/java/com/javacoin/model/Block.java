package com.javacoin.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
	private String hash;
	private int confirmations;
	private int size;
	private int height;
	private int version;
	private String merkleroot;
	private List<String> tx;
	private long time;
	private long nonce;
	private String bits;
	private BigDecimal difficulty;
	private String previousblockhash;
	private String nextblockhash;

}

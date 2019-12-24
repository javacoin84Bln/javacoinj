package com.javacoin.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiningInfo {
	
	private int blocks;
	private int currentblocksize;
	private int currentblocktx;
	private BigDecimal difficulty;
	private String errors;
	private BigInteger networkhashps;
	private int pooledtx;
	private boolean testnet;

}

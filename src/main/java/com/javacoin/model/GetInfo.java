package com.javacoin.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInfo {

	private int version;
	private int protocolversion;
	private int walletversion;
	private BigDecimal balance;
	private int blocks;
	private int timeoffset;
	private int connections;
	private String proxy;
	private double difficulty;
	private boolean testnet;
	private int keypoololdest;
	private int keypoolsize;
	private BigDecimal paytxfee;
	private BigDecimal mininput;
	private String errors;

}

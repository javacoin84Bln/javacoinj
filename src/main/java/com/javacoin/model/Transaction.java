package com.javacoin.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {	
	private BigDecimal amount;
	private BigDecimal fee;
	private long confirmations;
	private String blockhash;
	private long blockindex;
	private long blocktime;
	private String txid;
	private long time;
	private long timereceived;
	private List<Detail> details;
}

package com.javacoin.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivedAddress {
	
	private String address;
	private String account;
	private BigDecimal amount;
	private int confirmations;
	List<String> txids;

}

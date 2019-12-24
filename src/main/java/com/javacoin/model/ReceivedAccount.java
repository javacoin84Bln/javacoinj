package com.javacoin.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivedAccount {

	private String account;
	private BigDecimal amount;
	private int confirmations;
}

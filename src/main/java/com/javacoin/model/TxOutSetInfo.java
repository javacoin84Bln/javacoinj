package com.javacoin.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TxOutSetInfo {

	private int height;
	private String bestblock;
	private int transactions;
	private int txouts;
	private int bytes_serialized;
	private String hash_serialized;
	private BigDecimal total_amount;
}

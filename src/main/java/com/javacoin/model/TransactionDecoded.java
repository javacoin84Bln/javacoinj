package com.javacoin.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDecoded {

	private String txid;
	private int version;
	private long locktime;
	private List<Vin> vin;
	private List<Vout> vout;
}

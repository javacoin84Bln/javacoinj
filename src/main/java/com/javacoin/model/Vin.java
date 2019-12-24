package com.javacoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vin {
	
	private String txid;
	private int vout;
	private ScriptSig scriptSig;
	private long sequence;

}

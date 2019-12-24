package com.javacoin.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vout {
	
	private BigDecimal value;
	private int n;
	ScriptPubKey scriptPubKey;

}

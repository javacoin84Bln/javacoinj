package com.javacoin.model;

import java.math.BigDecimal;

import com.javacoin.util.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
	
	private String account;
	private String address;
	private Category category;
	private BigDecimal amount;
	private BigDecimal fee;

}

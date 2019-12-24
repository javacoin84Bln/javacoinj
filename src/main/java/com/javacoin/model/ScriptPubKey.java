package com.javacoin.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScriptPubKey {

	private String asm;
	private String hex;
	private int reqSigs;
	private String type;
	private List<String> addresses;
}

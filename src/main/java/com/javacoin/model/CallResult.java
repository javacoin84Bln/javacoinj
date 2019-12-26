package com.javacoin.model;

import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallResult {

	private JsonObject result;
	private CallError error;
	private String id;
}

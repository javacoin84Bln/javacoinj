package com.javacoin.util;

import com.google.gson.annotations.SerializedName;

public enum Category {
	@SerializedName("send")
	SEND,
	@SerializedName("receive")
    RECEIVE,
	@SerializedName("generate")
	GENERATE,
	@SerializedName("immature")
	IMMATURE,
	@SerializedName("orphan")
	ORPHAN;	
}
package com.javacoin.util;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.javacoin.exception.InsufficientFundsException;
import com.javacoin.exception.InvalidAccountNameException;
import com.javacoin.exception.InvalidJavacoinaddressException;
import com.javacoin.exception.JavacoinRpcException;

public class JavacoinExceptionChecker {

	private final static String MESSAGE = "message";
	private final static String ERROR_CODE = "code";

	public void checkForError(JsonElement jElement, RpcMethods callMethod) throws JavacoinRpcException {

			JsonObject errorJson = jElement.getAsJsonObject();
			
			String message = errorJson.get(MESSAGE).getAsString();
			int errorCode = errorJson.get(ERROR_CODE).getAsInt();
			
			switch (errorCode) {
			case -5:
				throw new InvalidJavacoinaddressException(message);
			case -11:
				throw new InvalidAccountNameException(message);
			case -6:
				throw new InsufficientFundsException(message);
			default:
				throw new JavacoinRpcException(message + StringUtils.SPACE + callMethod);
			}
		
	}
}

package com.javacoin.exception;

public class InvalidAccountNameException extends JavacoinRpcException {
	private static final long serialVersionUID = 4840156551558104250L;

	public InvalidAccountNameException(String message) {
		super(message);		
	}

}

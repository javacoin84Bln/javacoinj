package com.javacoin.exception;

public class TransactionTooLargeException extends JavacoinRpcException {

	private static final long serialVersionUID = -2760663402414100764L;

	public TransactionTooLargeException(String message) {
		super(message);
	}


}

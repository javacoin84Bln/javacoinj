package com.javacoin.exception;

public class InsufficientFundsException extends JavacoinRpcException {

	private static final long serialVersionUID = 4446983820827175666L;

	public InsufficientFundsException(String message) {
        super(message);
    }
}

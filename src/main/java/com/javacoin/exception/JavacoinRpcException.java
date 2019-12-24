package com.javacoin.exception;

public class JavacoinRpcException extends RuntimeException {

	private static final long serialVersionUID = 4323606079052529598L;

	public JavacoinRpcException(String message) {
        super(message);
    }
}

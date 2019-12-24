package com.javacoin.exception;

public class JavacoinRpcInvalidResponseException extends JavacoinRpcException {
    
	private static final long serialVersionUID = 1856037124464744779L;

	public JavacoinRpcInvalidResponseException(String message) {
        super(message);
    }
}

package com.javacoin.exception;

public class InvalidCredentialsException extends JavacoinRpcException {

	private static final long serialVersionUID = 8642342717538328999L;
	private static final String INVALID_CREDENTIALS = "Invalid Credentials";

    public InvalidCredentialsException() {
        super(INVALID_CREDENTIALS);
    }

}

package br.com.challenges.fifth.exception;

public class CreateCryptorException extends Exception {

	private static final long serialVersionUID = 1L;

	public CreateCryptorException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateCryptorException(String message) {
		super(message);
	}
}

package ponta.test.Exeption;

public class PontaSystemException extends RuntimeException {

	public PontaSystemException(String message) {
		super(message);
	}

	public PontaSystemException(String message, RuntimeException e) {
		super(message, e);
	}

	public PontaSystemException(String message, Exception e) {
		super(message, e);
	}
}

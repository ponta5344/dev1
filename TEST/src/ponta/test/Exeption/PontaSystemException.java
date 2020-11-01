package ponta.test.Exeption;

public class PontaSystemException extends RuntimeException {

	public PontaSystemException(String message) {
		super(message);
	}

	public PontaSystemException(String message, Throwable cause) {
		super(message, cause);
	}
	public PontaSystemException(Throwable cause) {
		super(cause);
	}
}

package ponta.test.Exeption;

public class PontaExeption extends Exception {

	public PontaExeption(String message) {
		super(message);
	}

	public PontaExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public PontaExeption(Throwable cause) {
		super(cause);
	}
}

package ponta.test.Exeption;

public class PontaExeption extends Exception {

	public PontaExeption(String message) {
		super(message);
	}

	public PontaExeption(String message, Exception e) {
		super(message, e);
	}

}

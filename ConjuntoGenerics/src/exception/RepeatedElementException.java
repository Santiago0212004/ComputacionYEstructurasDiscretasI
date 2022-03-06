package exception;

public class RepeatedElementException extends Exception {
	
	public RepeatedElementException() {
		super("No puede ingresar un elemento repetido.");
	}
	
}

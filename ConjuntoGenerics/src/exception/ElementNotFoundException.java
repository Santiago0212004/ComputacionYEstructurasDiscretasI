package exception;

public class ElementNotFoundException extends Exception {
	
	public ElementNotFoundException() {
		super("El elemento especificado no se encuentra en el conjuntos.");
	}

}

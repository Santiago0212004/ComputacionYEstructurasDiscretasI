package exception;

public class IndexNotFoundException extends Exception{
	
	public IndexNotFoundException() {
		super("El indice no se encuentra en el conjunto.");
	}
	
}

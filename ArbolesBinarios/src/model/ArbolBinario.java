package model;

public class ArbolBinario {
	private Nodo raiz;
	
	public ArbolBinario(){
		raiz = null;
	}
	
	public boolean exists(int busqueda) {
		if(raiz == null) {
			return false;
		} else {
			return raiz.exists(busqueda);
		}

	}
	
	
	
}

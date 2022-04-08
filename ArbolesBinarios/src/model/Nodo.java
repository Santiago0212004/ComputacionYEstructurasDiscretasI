package model;

public class Nodo {
	private int dato;
    private Nodo izquierda, derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }


    public int getDato() {
        return dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    
    public boolean exists(int busqueda) {
		
		if(this.dato==busqueda) {
			return true;
		}
			
		if (busqueda < this.dato && this.izquierda!=null) {
	 		return this.izquierda.exists(busqueda);
	 	} else if(busqueda >= this.dato && this.derecha!=null) {
	 		return this.derecha.exists(busqueda);
	 	} else {
	 		return false;
	 	}
		
	}

    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}

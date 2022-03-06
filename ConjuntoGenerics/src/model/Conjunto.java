package model;

import java.util.ArrayList;

import exception.ElementNotFoundException;
import exception.IndexNotFoundException;
import exception.RepeatedElementException;

public class Conjunto <T>{
	
	private ArrayList<T> elementos;
	private int n;
	
	
	public Conjunto() {
		elementos = new ArrayList<T>();
		this.n = 0;
	}
	
	public void añadirElemento(T e) throws RepeatedElementException {
		if(contiene(e)) {
			throw new RepeatedElementException();
		} else {
			elementos.add(e);
			n++;
		}
	}
	
	public boolean contiene(T e) {
		boolean contenido = false;
		for(T eC : elementos) {
			if(eC.equals(e)) {
				contenido = true;
				break;
			}
		}
		return contenido;
	}
	
	public String obtenerTodo() {
		String todo = "[";
		
		if(elementos.size()==1) {
			todo += elementos.get(0);
		}
		
		else {
			for(int i=0; i<elementos.size(); i++) {
				if(i!=0) {
					todo += ", "+elementos.get(i);
				}
				else {
					todo += elementos.get(i);
				}
				
			}
		}
		
		
		todo += "]";
		
		return todo;
	}
	
	//Borrar con el objeto
	public void borrarElemento(T e) throws ElementNotFoundException {
		if(!contiene(e)) {
			throw new ElementNotFoundException();
		}
		else {
			elementos.remove(e);
			n--;
		}
	}
	
	
	//Borrar con el indice
	public void borrarElementoIndice(int i) throws IndexNotFoundException {
		if(i<0 || i>=elementos.size()) {
			throw new IndexNotFoundException();
		}
		else {
			elementos.remove(i);
			n--;
		}
	}
	
	public boolean estaVacio() {
		boolean vacio = false;
		if(elementos.size()==0) {
			vacio = true;
		}
		return vacio;
	}
	
	public Conjunto<T> union(Conjunto<T> addingC) throws RepeatedElementException {
		
		Conjunto<T> conjuntoUnion = new Conjunto<T>();
		
		for(T c : elementos) {
			conjuntoUnion.elementos.add(c);
		}
		
		for(T c : addingC.elementos) {
			if(!conjuntoUnion.elementos.contains(c)) {
				conjuntoUnion.elementos.add(c);
			}
		}
		
		conjuntoUnion.cambiarTamanio(conjuntoUnion.obtenerElementos().size());
	
		return conjuntoUnion;
	}
	
	public Conjunto<T> interseccion(Conjunto<T> addingC) throws RepeatedElementException{
		
		Conjunto<T> conjuntoInterseccion = new Conjunto<T>();
		
		for(T c : elementos) {
			if(addingC.elementos.contains(c)) {
				conjuntoInterseccion.añadirElemento(c);
			}
		}
		
		
		conjuntoInterseccion.cambiarTamanio(conjuntoInterseccion.obtenerElementos().size());
	
		return conjuntoInterseccion;
	}
	
	public Conjunto<T> diferencia(Conjunto<T> addingC) throws RepeatedElementException{
		
		Conjunto<T> conjuntoDiferencia = new Conjunto<T>();
		
		for(T c : elementos) {
			if(!addingC.elementos.contains(c)) {
				conjuntoDiferencia.añadirElemento(c);
			}
		}
		
		
		conjuntoDiferencia.cambiarTamanio(conjuntoDiferencia.obtenerElementos().size());
	
		return conjuntoDiferencia;
	}
	
	public Conjunto<T> diferenciaSimetrica(Conjunto<T> addingC) throws RepeatedElementException{
		
		Conjunto<T> conjuntoDiferenciaSimetrica = new Conjunto<T>();
		
		for(T c : elementos) {
			if(!((addingC.elementos.contains(c)) && (elementos.contains(c)))) {
				conjuntoDiferenciaSimetrica.añadirElemento(c);
			}
		}
		
		for(T c : addingC.elementos) {
			if(!(addingC.elementos.contains(c) && elementos.contains(c))) {
				conjuntoDiferenciaSimetrica.añadirElemento(c);
			}
		}
		
		conjuntoDiferenciaSimetrica.cambiarTamanio(conjuntoDiferenciaSimetrica.obtenerElementos().size());
	
		return conjuntoDiferenciaSimetrica;
	}

	public int obtenerTamanio() {
		return n;
	}
	
	private void cambiarTamanio(int n) {
		this.n = n;
	}

	private ArrayList<T> obtenerElementos() {
		return elementos;
	}

}

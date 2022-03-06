package main;

import model.Conjunto;

public class Main {

	public static void main(String[] args) {
		
		try {
			probarConjunto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void probarConjunto() throws Exception {
		
		System.out.println("----------Conjunto creado----------");
		Conjunto<String> miConjunto = new Conjunto<String>();
		
		System.out.println("Esta vacio: "+miConjunto.estaVacio());
		
		System.out.println("\nAñadiendo Elementos...");
		miConjunto.añadirElemento("a");
		miConjunto.añadirElemento("e");
		miConjunto.añadirElemento("i");
		miConjunto.añadirElemento("o");
		miConjunto.añadirElemento("u");
		miConjunto.añadirElemento("x");
		miConjunto.añadirElemento("y");
		miConjunto.añadirElemento("z");
		
		System.out.println("\nConjunto con elementos añadidos: "+miConjunto.obtenerTodo());
		System.out.println("Tamaño: "+miConjunto.obtenerTamanio());
		
		System.out.println("\nEsta vacio: "+miConjunto.estaVacio());
		System.out.println("\nContiene f: "+miConjunto.contiene("f"));
		System.out.println("Contiene i: "+miConjunto.contiene("i"));
		
		System.out.println("\nBorrando Elemento i...");
		miConjunto.borrarElemento("i");
		
		System.out.println("\nConjunto sin elemento i: "+miConjunto.obtenerTodo());
		System.out.println("Contiene i: "+miConjunto.contiene("i"));
		System.out.println("Tamaño: "+miConjunto.obtenerTamanio());
		
		
		
		//Para realizar operaciones se necesita que sean del mismo tipo
		

		Conjunto<String> otroConjunto = new Conjunto<String>();
		System.out.println("\n\n--------Conjunto nuevo para operar creado--------");
		
		System.out.println("\nAñadiendo Elementos...");
		otroConjunto.añadirElemento("a");
		otroConjunto.añadirElemento("b");
		otroConjunto.añadirElemento("c");
		otroConjunto.añadirElemento("d");
		otroConjunto.añadirElemento("e");
		System.out.println("\nConjunto nuevo con elementos añadidos: "+otroConjunto.obtenerTodo());
		System.out.println("Tamaño: "+otroConjunto.obtenerTamanio());
		
		System.out.println("\n------------------------------OPERACIONES--------------------------\n");
		
		System.out.println("\nConjunto al que le vamos a realizar las operaciones: "+ miConjunto.obtenerTodo());
		System.out.println("Tamaño: "+miConjunto.obtenerTamanio());
		
		System.out.println("\nConjunto que vamos a usar para operar: "+otroConjunto.obtenerTodo());
		System.out.println("Tamaño: "+otroConjunto.obtenerTamanio());
		
		
		Conjunto<String> conjuntoUnion = miConjunto.union(otroConjunto);
		
		System.out.println("\nConjunto union: "+conjuntoUnion.obtenerTodo());
		System.out.println("Tamaño: "+conjuntoUnion.obtenerTamanio());
		
		Conjunto<String> conjuntoInterseccion = miConjunto.interseccion(otroConjunto);
		
		System.out.println("\nConjunto interseccion: "+conjuntoInterseccion.obtenerTodo());
		System.out.println("Tamaño: "+conjuntoInterseccion.obtenerTamanio());
		
		Conjunto<String> conjuntoDiferencia = miConjunto.diferencia(otroConjunto);
		
		System.out.println("\nConjunto diferencia: "+conjuntoDiferencia.obtenerTodo());
		System.out.println("Tamaño: "+conjuntoDiferencia.obtenerTamanio());
		
		Conjunto<String> conjuntoDiferenciaSimetrica = miConjunto.diferenciaSimetrica(otroConjunto);
		
		System.out.println("\nConjunto diferencia simetrica: "+conjuntoDiferenciaSimetrica.obtenerTodo());
		System.out.println("Tamaño: "+conjuntoDiferenciaSimetrica.obtenerTamanio());
		
	}

}

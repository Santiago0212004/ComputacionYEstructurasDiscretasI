package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> pairs = new HashMap<>();
		
		
		ArrayList<String> domain = new ArrayList<>();
		ArrayList<String> codomain = new ArrayList<>();
		
		System.out.println("\nEnter the amount of elements in the domain: ");
		int n1 = sc.nextInt();
		
		String domainElement;
		
		for(int i=0; i<n1; i++) {
			System.out.println("\nWrite the element "+(i+1)+" of the domain: ");
			domainElement = sc.next();
			if(repeatedElement(domain, domainElement)) {
				System.out.println("You cannot add equal elements in the domain.");
				i--;
			}
			else {
				domain.add(domainElement);
			}
		}
		
		System.out.println("\n\nEnter the amount of elements in the codomain: ");
		int n2 = sc.nextInt();
		
		String codomainElement;
		
		for(int i=0; i<n2; i++) {
			System.out.println("\nWrite the element "+(i+1)+" of the codomain: ");
			codomainElement = sc.next();
			if(repeatedElement(codomain, codomainElement)) {
				System.out.println("You cannot add equal elements in the codomain.");
				i--;
			}
			else {
				codomain.add(codomainElement);
			}
		}
		
		System.out.print("\nDomain: "+domain);
		System.out.print("\nCodomain: "+codomain);
		
		System.out.println("\n\nEnter the amount of pairs: ");
		int n3 = sc.nextInt();
		
		String key, value;
		
		for(int i = 0; i<n3; i++) {
			System.out.println("\nDigit the key of the pair "+(i+1)+": ");
			key = sc.next();
			
			while(!domain.contains(key)) {
				System.out.println("The key must be in the domain: ");
				key = sc.next();
			}
			
			if(pairs.containsKey(key)) {
				System.out.print("You can't add a key that already is in the map.\n");
				i--;
			}
			else {
				System.out.println("Digit the value of the pair "+(i+1)+": ");
				value = sc.next();
				
				while(!codomain.contains(value)) {
					System.out.println("The value must be in the codomain: ");
					value = sc.next();
				}
				
				pairs.put(key, value);
			}
				
		}
		
		boolean function = false, surjective = false, injective = false, bijective = false;
		
		
		
		for(String i : domain) {
			if(!pairs.keySet().contains(i)) {
				function = false;
			}
			else {
				function = true;
			}
		}
		
		
		ArrayList<Integer> amountOfRepeatedElements = new ArrayList<>();
		int count;
		String a;
		
		if(function) {

			for(String i : codomain) {
				count = 0;
				for(Map.Entry m : pairs.entrySet()) {
					a = (String) m.getValue();
					if(a.equalsIgnoreCase(i)) {
						count++;
					}
				}
				amountOfRepeatedElements.add(count);
			}
			
			boolean higherThanOne = false;
			
			for(int i = 0; i<amountOfRepeatedElements.size() && !higherThanOne; i++) {
				if(amountOfRepeatedElements.get(i)>1) {
					higherThanOne = true;
					injective = false;
				}
				else {
					injective = true;
				}
			}
			
			boolean equalsIgnoreCaseZero = false;
			
			for(int i = 0; i<amountOfRepeatedElements.size() && !equalsIgnoreCaseZero; i++) {
				if(amountOfRepeatedElements.get(i)==0) {
					equalsIgnoreCaseZero = true;
					surjective = false;
				}
				else {
					surjective = true;
				}
			}
			
			if(surjective && injective) {
				bijective = true;
			}
			
			if(bijective == true) {
				System.out.println("\nThe function is bijective.");
			}else if(surjective == true) {
				System.out.println("\nThe function is surjective.");
			}else if(injective == true) {
				System.out.println("\nThe function is injective.");
			}else {
				System.out.println("\nIt's only a function, not surjective, neither injective.");
			}
			
		}
		
		else {
			System.out.println("It's not a function.");
		}
		
	
	}
	
	
	public static boolean repeatedElement(ArrayList<String> list, String element) {
		boolean repeated = false;
		
		for(int i=0; i<list.size(); i++) {
			if(element.equalsIgnoreCase(list.get(i))) {
				repeated = true;
			}
		}
		
		return repeated;
		
	}

}

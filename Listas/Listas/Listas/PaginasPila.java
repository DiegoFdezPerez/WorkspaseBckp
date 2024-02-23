package Listas;

import java.util.*;


public class PaginasPila {

	
	public void web () {
		Stack <String> pila = new Stack <String>();
		ArrayList <String> cache = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		String respuesta;
		
		while (true) {
			
			System.out.println("Añade URL o interactua con palabras adelante/atras/salir: ");
			respuesta=sc.nextLine();
		
		if (respuesta.equals("salir")) {
			System.out.println("Saliendo del navegador web");
			break;
		}
		else if (respuesta.equals("adelante")) {
			
			if (!cache.isEmpty()) {
			pila.add(cache.get(cache.size()-1));
			cache.remove(cache.size()-1);}
			
			else {
				System.out.println("No hay registros aun");
			}
		}
			
			
		else if (respuesta.equals("atras")) {
			if (pila.size()>0) {
		    String temp;
			temp=pila.pop();
			cache.add(temp);
			}
			else if (pila.size()==0) {
				System.out.println("No hay mas registros");}
			
		}
		
		else {
			pila.add(respuesta);
			
			if (!cache.isEmpty()) {
				if(pila.peek()!=cache.get(cache.size()-1)) {
				cache.removeAll(cache);
				}
			}
			}
		
		if (pila.size()>0) 
		System.out.println("Has navegado a la web: " + pila.peek());
		else 
			System.out.println("Estás en la pagina de inicio");
		
		}
	    sc.close();	
	}
	
	}


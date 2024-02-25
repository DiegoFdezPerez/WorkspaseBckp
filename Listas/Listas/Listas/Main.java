package Listas;

import java.util.*;

public class Main {

		public static void main (String [] args) {
			
			Scanner sc= new Scanner(System.in);
			
			while(true) {
			System.out.println("Selecciona paginas/impresora/sets/salir: ");
			String respuesta = sc.nextLine();
			
			if (respuesta.equalsIgnoreCase("salir")) {
				System.out.println("Saliendo del programa");
				break;
			}
			
			
			else if (respuesta.equalsIgnoreCase("paginas")) {
			PaginasPila pp = new PaginasPila();
			pp.web();
			break;
			}
			
			else if (respuesta.equalsIgnoreCase("impresora")) {
			ImpresoraCola ic = new ImpresoraCola();
			ic.impresoraCompartida();
			break;
			}
			else if (respuesta.equalsIgnoreCase("sets")) {
				Colecciones col = new Colecciones();
				col.Sets();
				break;
				}
			else 
				
				System.out.println("Resuesta no valida");
			}
			
			sc.close();
	}}


package Listas;

import java.util.*;

public class Main {

		public static void main (String [] args) {
			
			Scanner sc= new Scanner(System.in);
			
			while(true) {
			System.out.println("Selecciona paginas/impresora/sets/arboles/salir: ");
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
			
			else if(respuesta.equalsIgnoreCase("a")) {
			
				NodoBinario n1 = new NodoBinario(1,null,null);
				NodoBinario n3 = new NodoBinario(3,null,null);
				NodoBinario n2 = new NodoBinario(2,n1,n3);
				NodoBinario n7 = new NodoBinario(8,null,null);
				NodoBinario n6 = new NodoBinario(5,null,n7);
				NodoBinario root = new NodoBinario(4,n2,n6);
				ArbolBinarioBusq abb=new ArbolBinarioBusq(root);
				
				abb.InsertarNodo(6,root);
				abb.InsertarNodo(7,root);
				System.out.println("Mayor elemento del sub arbol  izquierdo: "+ abb.BuscarMayorSubArbolIzq(root).getElemento());
				System.out.println("Menor elemento del sub arbol  derecho: "+ abb.BuscarMenorSubArbolDer(root).getElemento() + "\n");
				
				abb.EliminarNodo(root,root);
				
				
				  System.out.println("Arbol en preorden:"); abb.ImprimirPreorden(root);
				  
				  System.out.println("\n" + "Arbol en inorden:"); abb.ImprimirInorden(root);
				  
				  System.out.println("\n" + "Arbol en postorden:");
				  abb.ImprimirPostorden(root);
				 
				break;
			}
			else 
				
				System.out.println("Resuesta no valida");
			}
			
			sc.close();
	}}



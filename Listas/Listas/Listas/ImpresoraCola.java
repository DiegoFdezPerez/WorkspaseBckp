package Listas;
import java.util.*;

public class ImpresoraCola {

	public void impresoraCompartida() {
		
		Queue cola = new LinkedList (); 
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Añade un documento o selecciona imprimir/salir: ");
			String accion = sc.nextLine();
			
			if (accion.equals("salir")) {
				System.out.println("Saliendo de la impresora");
				break;
			}
			
			else if (accion.equals("imprimir")) {
				if (cola.size()>0) {
				System.out.println("Imprimiendo: " + cola.poll());
				}
			
				}
			
			else {
				cola.add(accion);
				}
			if (cola.size()>0)
			System.out.println("Cola de impresion:" + cola);
			else 
				System.out.println("La cola de impresion esta vacia");
		}
	sc.close();
	}
	
}

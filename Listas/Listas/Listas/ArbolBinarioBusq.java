package Listas;
import java.util.*;

public class ArbolBinarioBusq {

	protected NodoBinario raiz;
	
	ArbolBinarioBusq(){
		raiz = null;
	}
	
	ArbolBinarioBusq(Object o){
		raiz = new NodoBinario (o);
	}
	
	public boolean EstaVacio ( ) {
		return raiz == null;
	}
	
	/////////////////////////////////////////////
	///////////////Recorridos///////////////////

	
	public void ImprimirPreorden (NodoBinario nodo) {
		
	 if(nodo != null) {
			 
		System.out.print(nodo.getElemento() + " ");
		
		if(nodo.getNodoIzq()!=null) {
			ImprimirPreorden((NodoBinario) nodo.getNodoIzq());

		}
		
		if(nodo.getNodoDer() != null) {
			ImprimirPreorden((NodoBinario) nodo.getNodoDer());
		}}
	 else 
			System.out.println("El arbol esta vacio");
		
		}
		
	public void ImprimirInorden (NodoBinario nodo) {
	
	  if(nodo != null) {
			
		
		if(nodo.getNodoIzq()!=null) {
				ImprimirInorden((NodoBinario) nodo.getNodoIzq());
		}

		System.out.print(nodo.getElemento() + " ");
			
		if(nodo.getNodoDer() != null) {
			ImprimirInorden((NodoBinario) nodo.getNodoDer());
		}
		}
	  else 
			System.out.println("El arbol esta vacio");

	}
			

	public void ImprimirPostorden (NodoBinario nodo) {

	  if(nodo != null) {
			
		if(nodo.getNodoIzq()!=null) {
			ImprimirPostorden((NodoBinario) nodo.getNodoIzq());

		}
		
		if(nodo.getNodoDer() != null) {
			ImprimirPostorden((NodoBinario) nodo.getNodoDer());
		}
		
		System.out.print(nodo.getElemento() + " ");
	}
	  else 
		System.out.println("El arbol esta vacio");
	}
	
	public NodoBinario getRoot() {
		return raiz;
	}
	
	public void InsertarNodo(int i, NodoBinario a) {
		
		if(i == (int) a.getElemento()) {
			System.out.println("El elemento ya existe en el arbol");
			return;
		}
		else if(i<(int) a.getElemento()) {
			if(a.getNodoIzq()!=null)
			InsertarNodo(i,(NodoBinario) a.getNodoIzq());
			else {
				NodoBinario nuevo= new NodoBinario(i);
				a.setNodoIzq(nuevo);
				System.out.println("Nodo numero:"+ i + " insertado correctamente.");
				}
			
		}
		else if(i>(int) a.getElemento()) {
			if(a.getNodoDer()!=null)
			InsertarNodo(i,(NodoBinario) a.getNodoDer());
			else {
				NodoBinario nuevo= new NodoBinario(i);
				a.setNodoDer(nuevo);
				System.out.println("Nodo numero: "+ i + " insertado correctamente. \n");
				}
		}
	
	}
	
	public void EliminarNodo (NodoBinario el, NodoBinario a)
	{   
		
		if((int) el.getElemento() == (int) a.getElemento()) {
			
			EliminarRaiz(el);
			return;
		}
		
		else if ((int) el.getElemento() < (int) a.getElemento()) {
			
			if (a.getNodoIzq()!=null)
			EliminarNodo(el, (NodoBinario) a.getNodoIzq(),false);
		}

		else if ((int) el.getElemento() > (int) a.getElemento()) {
			if (a.getNodoDer()!=null)
			EliminarNodo(el, (NodoBinario) a.getNodoDer(),false);
		}
		
		System.out.println("Nodo no encontrado");
		return;
	}
	
	public void EliminarNodo (NodoBinario el, NodoBinario a, boolean isLeaf)
	{   
		
		if((int) el.getElemento() == (int) a.getElemento()) {
			
			if (a.getNodoDer()==null && a.getNodoIzq()==null)
				isLeaf = true;
			
			if (isLeaf) {
				EliminarHoja(raiz,a);
			}
			else {
			    EliminarNodoIntermedio(raiz,a);	
			}
			return;
		}
		
		else if ((int) el.getElemento() < (int) a.getElemento()) {
			
			if (a.getNodoIzq()!=null)
			EliminarNodo(el, (NodoBinario) a.getNodoIzq(),false);
			
		}

		else if ((int) el.getElemento() > (int) a.getElemento()) {
			if (a.getNodoDer()!=null)
			EliminarNodo(el, (NodoBinario) a.getNodoDer(),false);
		}
		
		System.out.println("Nodo no encontrado");
		return;
	}
	
	private void EliminarHoja (NodoBinario nodo, NodoBinario el) {
		
		  if(nodo != null) {
				
			
			if(nodo.getNodoIzq()==el) {
					nodo.setNodoIzq(null);
					System.out.println("Nodo eliminado correctamente");
					return;
			}
			else if(nodo.getNodoDer()==el) {
					nodo.setNodoIzq(null);
					System.out.println("Nodo eliminado correctamente");
					return;
		    }
			else if(nodo.getNodoIzq() != null && (int) el.getElemento()< (int) nodo.getElemento()) {
				EliminarHoja ((NodoBinario) nodo.getNodoIzq(),el);
			}
			else if(nodo.getNodoDer() != null && (int) el.getElemento()> (int) nodo.getElemento()) {
				EliminarHoja ((NodoBinario) nodo.getNodoDer(),el);
			}
			}
		  else 
				System.out.println("El arbol esta vacio");
		  
		  System.out.println( "Nodo no encontrado en eliminar hoja (Esto no deberia aparecer nunca)");
		  
		}
	
	private void EliminarNodoIntermedio (NodoBinario nodo, NodoBinario el) {
		
		  if(nodo != null) {
				
			
			if(nodo.getNodoIzq()==el) {
				
				    if (el.getNodoIzq()!=null && el.getNodoDer()!= null) {
				    	
				     if ((int)el.getElemento()-(int) BuscarMayorSubArbolIzq(el).getElemento()>(int) BuscarMenorSubArbolDer(el).getElemento()-(int)el.getElemento()) {
				    	 
				    	 //f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    	 
				    	 
				    }
				 	
				     else if ((int)el.getElemento()-(int) BuscarMayorSubArbolIzq(el).getElemento()<(int) BuscarMenorSubArbolDer(el).getElemento()-(int)el.getElemento()) {
				    	 
				    	 //f2
				    	 NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    	 
				    	 
				     }
				    }
				    else if(el.getNodoIzq()==null) {
				    	
				    	//f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    	
				    }
				    else if(el.getNodoDer()==null) {
				    	
				    	//f2
				    	NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    }
				    
					System.out.println("Nodo eliminado correctamente");
					return;
			}
			else if(nodo.getNodoDer()==el) {
					
				if (el.getNodoIzq()!=null && el.getNodoDer()!= null) {
			    	
				     if ((int)el.getElemento()-(int) BuscarMayorSubArbolIzq(el).getElemento()>(int) BuscarMenorSubArbolDer(el).getElemento()-(int)el.getElemento()) {
				    	 
				    	 //f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    	 
				    	 
				    }
				 	
				     else if ((int)el.getElemento()-(int) BuscarMayorSubArbolIzq(el).getElemento()<(int) BuscarMenorSubArbolDer(el).getElemento()-(int)el.getElemento()) {
				    	 
				    	 //f2
				    	 NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    	 
				    	 
				     }
				    }
				    else if(el.getNodoIzq()==null) {
				    	
				    	//f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    	
				    }
				    else if(el.getNodoDer()==null) {
				    	
				    	//f2
				    	NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (raiz, temp);
				    	 temp.setNodoIzq((NodoBinario) el.getNodoIzq());
				    	 temp.setNodoDer((NodoBinario) el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    }
				    
				
					System.out.println("Nodo eliminado correctamente");
					return;
		    }
			else if(nodo.getNodoIzq() != null && (int) el.getElemento()< (int) nodo.getElemento()) {
				EliminarNodoIntermedio ((NodoBinario) nodo.getNodoIzq(),el);
			}
			else if(nodo.getNodoDer() != null && (int) el.getElemento()> (int) nodo.getElemento()) {
				EliminarNodoIntermedio ((NodoBinario) nodo.getNodoDer(),el);
			}
			}
		  else 
				System.out.println("El arbol esta vacio");
		  
		  System.out.println( "Nodo no encontrado en eliminar hoja (Esto no deberia aparecer nunca)");
		  
		}
	/*pendiente:
	BuscarMayorSubArbolIzq(NodoBinario)
	BuscarMenorSubArbolDer(NodoBinario)
	Funcion f1 y f2
	Eliminar Raiz
	  
	 */
}

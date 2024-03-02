package Listas;


public class ArbolBinarioBusq {

	protected NodoBinario raiz;
	
	ArbolBinarioBusq(){
		raiz = null;
	}
	
	ArbolBinarioBusq(NodoBinario o){
		raiz = o;
	}
	
	protected void setArbolBinarioBusqueda (NodoBinario o) {
		
		raiz =o;
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
			ImprimirPreorden(nodo.getNodoIzq());

		}
		
		if(nodo.getNodoDer() != null) {
			ImprimirPreorden(nodo.getNodoDer());
		}}
	 else 
			System.out.println("El arbol esta vacio");
		
		}
		
	public void ImprimirInorden (NodoBinario nodo) {
	
	  if(nodo != null) {
			
		
		if(nodo.getNodoIzq()!=null) {
				ImprimirInorden(nodo.getNodoIzq());
		}

		System.out.print(nodo.getElemento() + " ");
			
		if(nodo.getNodoDer() != null) {
			ImprimirInorden( nodo.getNodoDer());
		}
		}
	  else 
			System.out.println("El arbol esta vacio");

	}
			

	public void ImprimirPostorden (NodoBinario nodo) {

	  if(nodo != null) {
			
		if(nodo.getNodoIzq()!=null) {
			ImprimirPostorden( nodo.getNodoIzq());

		}
		
		if(nodo.getNodoDer() != null) {
			ImprimirPostorden( nodo.getNodoDer());
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
			InsertarNodo(i, a.getNodoIzq());
			else {
				NodoBinario nuevo= new NodoBinario(i);
				a.setNodoIzq(nuevo);
				System.out.println("Nodo numero:"+ i + " insertado correctamente.");
				}
			
		}
		else if(i>(int) a.getElemento()) {
			if(a.getNodoDer()!=null)
			InsertarNodo(i, a.getNodoDer());
			else {
				NodoBinario nuevo= new NodoBinario(i);
				a.setNodoDer(nuevo);
				System.out.println("Nodo numero: "+ i + " insertado correctamente. \n");
				}
		}
	
	}
	
	public void EliminarNodo (NodoBinario el, NodoBinario a)
	{   
		
		if( el.getElemento() ==  a.getElemento()) {
			
			EliminarRaiz(el);
			return;
		}
		
		else if ( el.getElemento() <  a.getElemento()) {
			
			if (a.getNodoIzq()!=null)
			EliminarNodo(el,  a.getNodoIzq(),false);
		}

		else if (el.getElemento() >  a.getElemento()) {
			if (a.getNodoDer()!=null)
			EliminarNodo(el,  a.getNodoDer(),false);
		}
		else
		System.out.println("Nodo no encontrado");
		return;
	}
	
	public void EliminarNodo (NodoBinario el, NodoBinario a, boolean isLeaf)
	{   
		
		if( el.getElemento() ==  a.getElemento()) {
			
			if (a.getNodoDer()==null && a.getNodoIzq()==null)
				isLeaf = true;
			
			if (isLeaf) {
				EliminarHoja(raiz,a);
			}
			else {
			    EliminarNodoIntermedio(raiz,el);	
			}
			return;
		}
		
		else if ((int) el.getElemento() < (int) a.getElemento()) {
			
			if (a.getNodoIzq()!=null)
			EliminarNodo(el,  a.getNodoIzq(),false);
			
		}

		else if ( el.getElemento() >  a.getElemento()) {
			if (a.getNodoDer()!=null)
			EliminarNodo(el,  a.getNodoDer(),false);
		}
		else
		System.out.println("Nodo no encontrado");
		return;
	}
	
	private void EliminarHoja (NodoBinario nodo, NodoBinario el) {
		
		  if(nodo != null) {
				
			
			if(nodo.getNodoIzq()==el) {
					nodo.setNodoIzq(null);
					System.out.println("Nodo eliminado correctamente. \n");
					return;
			}
			else if(nodo.getNodoDer()==el) {
					nodo.setNodoDer(null);
					System.out.println("Nodo eliminado correctamente. \n");
					return;
		    }
			else if(nodo.getNodoIzq() != null &&  el.getElemento()<  nodo.getElemento()) {
				EliminarHoja ( nodo.getNodoIzq(),el);
			}
			else if(nodo.getNodoDer() != null &&  el.getElemento()>  nodo.getElemento()) {
				EliminarHoja ( nodo.getNodoDer(),el);
			}
			}
		  else 
				System.out.println("El arbol esta vacio");
		  
		}
	
	private void EliminarNodoIntermedio (NodoBinario nodo, NodoBinario el) {
		
		  if(nodo != null) {
				
			
			if(nodo.getNodoIzq()==el) {
				
				    if (el.getNodoIzq()!=null && el.getNodoDer()!= null) {
				    	
				     if (el.getElemento()- BuscarMayorSubArbolIzq(el).getElemento()>= BuscarMenorSubArbolDer(el).getElemento()-el.getElemento()) {
				    	 
				    	 //f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    	 
				    	 
				    }
				 	
				     else if (el.getElemento()- BuscarMayorSubArbolIzq(el).getElemento()< BuscarMenorSubArbolDer(el).getElemento()-el.getElemento()) {
				    	 
				    	 //f2
				    	 NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    	 
				    	 
				     }
				    }
				    else if(el.getNodoIzq()==null) {
				    	
				    	//f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    	
				    }
				    else if(el.getNodoDer()==null) {
				    	
				    	//f2
				    	NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoIzq(temp);
				    }
				    
					return;
			}
			else if(nodo.getNodoDer()==el) {
					
				if (el.getNodoIzq()!=null && el.getNodoDer()!= null) {
			    	
				     if (el.getElemento()- BuscarMayorSubArbolIzq(el).getElemento()>= BuscarMenorSubArbolDer(el).getElemento()-el.getElemento()) {
				    	 
				    	 //f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    	 
				    	 
				    }
				 	
				     else if (el.getElemento()- BuscarMayorSubArbolIzq(el).getElemento()< BuscarMenorSubArbolDer(el).getElemento()-el.getElemento()) {
				    	 
				    	 //f2
				    	 NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    	 
				    	 
				     }
				    }
				    else if(el.getNodoIzq()==null) {
				    	
				    	//f1
				    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    	
				    }
				    else if(el.getNodoDer()==null) {
				    	
				    	//f2
				    	NodoBinario temp = BuscarMayorSubArbolIzq(el);
				    	 EliminarNodo (temp, raiz);
				    	 temp.setNodoIzq( el.getNodoIzq());
				    	 temp.setNodoDer( el.getNodoDer());
				    	 nodo.setNodoDer(temp);
				    }
				    
				
					System.out.println("Nodo eliminado correctamente");
					return;
		    }
			else if(nodo.getNodoIzq() != null &&  el.getElemento()< nodo.getElemento()) {
				EliminarNodoIntermedio ( nodo.getNodoIzq(),el);
			}
			else if(nodo.getNodoDer() != null && el.getElemento()> nodo.getElemento()) {
				EliminarNodoIntermedio ( nodo.getNodoDer(),el);
			}
			}
		  else 
				System.out.println("El arbol esta vacio");
		  
		}
	
	    public NodoBinario BuscarMayorSubArbolIzq (NodoBinario nodo) {
	    	
	    	if(nodo.getNodoIzq()!= null) {
	    	 return	BuscarMayorSubArbolIzq2( nodo.getNodoIzq());
	    	}
	    	else 
	    	  return nodo;
	    }
	    
 public NodoBinario BuscarMayorSubArbolIzq2 (NodoBinario nodo) {
	    	
	    	if(nodo.getNodoDer()!= null) {
	    	 return	BuscarMayorSubArbolIzq2( nodo.getNodoDer());
	    	}
	    	else 
	    	  return nodo;
	    }
	    
	    public NodoBinario BuscarMenorSubArbolDer(NodoBinario nodo) {
         
	    	if (nodo.getNodoDer()!=null)	{
        	return  BuscarMenorSubArbolDer2( nodo.getNodoDer());
          }
          else 
            return nodo;
	    	
	    }
	    
	    public NodoBinario BuscarMenorSubArbolDer2(NodoBinario nodo) {
	         
	    	if (nodo.getNodoIzq()!=null)	{
        	return  BuscarMenorSubArbolDer2( nodo.getNodoIzq());
          }
          else 
            return nodo;
	    	
	    }
	    
	    private void EliminarRaiz (NodoBinario el) {
	    	
	    	
	    	if (el.getNodoIzq()!=null && el.getNodoDer()!= null) {
		    	
			     if (el.getElemento()- BuscarMayorSubArbolIzq(el).getElemento()> BuscarMenorSubArbolDer(el).getElemento()-el.getElemento()) {
			    	 
			    	 //f1
			    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
			    	 EliminarNodo (temp, raiz);
			    	 raiz.setElemento(temp.getElemento());
			    	 return;
			    	 
			    }
			 	
			     else if (el.getElemento()- BuscarMayorSubArbolIzq(el).getElemento()<= BuscarMenorSubArbolDer(el).getElemento()-el.getElemento()) {
			    	 
			    	 //f2
			    	 NodoBinario temp = BuscarMayorSubArbolIzq(el);
			    	 EliminarNodo (temp, raiz);
			    	 raiz.setElemento(temp.getElemento());
			    	 return;
			    	 
			     }
			    }
			    else if(el.getNodoIzq()==null) {
			    	
			    	//f1
			    	 NodoBinario temp = BuscarMenorSubArbolDer(el);
			    	 EliminarNodo (temp, raiz);
			    	 raiz.setElemento(temp.getElemento());
			    	 return;
			    }
			    else if(el.getNodoDer()==null) {
			    	
			    	//f2
			    	 NodoBinario  temp = BuscarMayorSubArbolIzq(el);
			    	 EliminarNodo (temp, raiz);
			    	 raiz.setElemento(temp.getElemento());
			    	 return;
			    }
			  
	    	
	    }
	/*pendiente:
	BuscarMayorSubArbolIzq(NodoBinario)
	BuscarMenorSubArbolDer(NodoBinario)
	Funcion f1 y f2
	Eliminar Raiz
	  
	 */
}

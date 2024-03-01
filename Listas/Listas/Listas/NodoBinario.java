package Listas;

public class NodoBinario {

	private Object elemento;
	private NodoBinario nodoIzq;
	private NodoBinario nodoDer;
	
	public NodoBinario(Object o) {
		this(o,null,null);
	}
	
	public NodoBinario (Object o, NodoBinario izq, NodoBinario der) {
		elemento = o;
		nodoIzq = izq;
		nodoDer = der;
	}
	
	public void setElemento (Object o) {
		elemento = 0;
	}
	
	public void setNodoIzq(NodoBinario i) {
		nodoIzq = i;
	}
	
	public void setNodoDer(NodoBinario d) {
		nodoDer = d;
	}
	
	public Object getElemento(){
		return elemento;
	}
	
	public Object getNodoIzq() {
		return nodoIzq;
	}
	
	public Object getNodoDer() {
		return nodoDer;
	}
}

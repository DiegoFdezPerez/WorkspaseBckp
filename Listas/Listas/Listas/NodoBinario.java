package Listas;

public class NodoBinario {

	private int elemento;
	private NodoBinario nodoIzq;
	private NodoBinario nodoDer;
	
	public NodoBinario(int o) {
		this(o,null,null);
	}
	
	public NodoBinario (int o, NodoBinario izq, NodoBinario der) {
		elemento = o;
		nodoIzq = izq;
		nodoDer = der;
	}
	
	public void setElemento (int o) {
		elemento = o;
	}
	
	public void setNodoIzq(NodoBinario i) {
		nodoIzq = i;
	}
	
	public void setNodoDer(NodoBinario d) {
		nodoDer = d;
	}
	
	public int getElemento(){
		return elemento;
	}
	
	public NodoBinario getNodoIzq() {
		return nodoIzq;
	}
	
	public NodoBinario getNodoDer() {
		return nodoDer;
	}
}

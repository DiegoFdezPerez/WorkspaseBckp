package Listas;
import java.util.*;

class Colecciones {

	public void Sets ()
	{
		//Si se usan threads lo ideal es usar la interfaz Collections.synchronizedSet() al inicializar
		//Lo ideal es definir el tamaño para optimizar los tiempos de ejecución
		
		//HashSet se usa si no se pueden repetir elementos y no importa el orden
		Set hashSet = new HashSet(1000000);
		
		//TreeSet se usa si no se pueden repetir elementos y se desea agrupar por orden de valor
		//Tree set no se puede declarar tamaño
		Set treeSet = new  TreeSet();
		
		//LinkedHashSet se usa si no se pueden repetir elementos y se debe ordenar por orden de insercion
		Set linkedHashSet = new LinkedHashSet(1000000);
		
		Long startTime = System.currentTimeMillis();
		
		for (int i = 0; i<1000000; i++) {
			hashSet.add(i);
		}
		
		Long finishTime = System.currentTimeMillis();
		
		System.out.println("Tiempo de ejecuccion del HashSet: "+ (finishTime - startTime));
		
        startTime = System.currentTimeMillis();
		
		for (int i = 0; i<1000000; i++) {
			treeSet.add(i);
		}
		
		finishTime = System.currentTimeMillis();
		
		System.out.println("Tiempo de ejecuccion del treeSet: "+ (finishTime - startTime));
		
		 startTime = System.currentTimeMillis();
			
			for (int i = 0; i<1000000; i++) {
				linkedHashSet.add(i);
			}
			
			finishTime = System.currentTimeMillis();
			
			System.out.println("Tiempo de ejecuccion del LinkedHashSet: "+ (finishTime - startTime));
		
		
	}
	
	public void Lists () {
		
		//Si se usan threads lo ideal es usar la interfaz Collections.synchronizedList() al inicializar
		//Tiene ventajas como metodos de busqueda, acceso posicional a elementos, mejora el iteratos por defecto, permite realizar operaciones sobre rangos de elemantos de la lista
		
		//Los ArrayLists son mejores para almacenar y acceder a elementos, tienen un tamaño por defecto de 10
		ArrayList array = new ArrayList<>();
		
		//Los LinkedLists son mejores para manipular daos, tienen una referencia a su elemento anterior y posterior, se inicializan por defecto con un tmaño de 0
		LinkedList linked = new LinkedList<>();
		
		//FIFO
		//poll()
		Queue cola = new LinkedList<>();

		//FIFO y LIFO
		Deque deq = new ArrayDeque<>();
		
		//LIFO
		//pop(), peek(),
	    Stack pila = new Stack ();
	  
	    //Iteradores
	    
	    Iterator iterador = pila.iterator();
	    while(iterador.hasNext()) {
	    	//Accion
	    }
	    
	}
	
	public void Maps () {
		
		//Si se usan threads lo ideal es usar la interfaz Collections.synchronizedMap() al inicializar
		//Los mapas se usan de clave/valor
		//put(),get()
		
		//Si no es necesario un orden especifico se usa HashMap
		
	    Map <Integer,List> hash = new HashMap <Integer,List>();
	    
	    //Si es necesario almacenar las claves en funcion de sus valores se usa tree map
	    
	    Map <Integer, List> tree = new TreeMap <Integer,List>();
	    
	    //Si se desea almacenar en funcion del orden de insercion se usa LinkedMap
	    
	    Map <Integer,List> linked = new LinkedHashMap <Integer, List>();
	    
	    
		
	}
}

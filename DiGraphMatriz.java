/**
 * Clase que implementa la interfaz Graph para un 
 * grafo dirigido de matriz de adyacencia.
 */
public class DiGraphMatriz implements Graph{
	
	private int numNodos, numArcos;
	private Nodo nodos[];
	private int arcos[][];

	public DiGraphMatriz () {
		/* implementar */
	}

	/**
	 * Agrega el nodo n. Si el nodo ya existe en el grafo, retorna false.
	 * Si se agrega correctamente el nodo, retorna true.
	 */
	@Override
	public boolean add(Nodo n) {

		/* implementar */
		return false;
	}

	/**
	 * Agrega el Arco a. Si los nodos del arco no existen en el grafo 
	 * o si ya existe un lado entre dichos nodos, retorna false. 
	 * Si se agrega correctamente el nodo, retorna true.
	 */
	@Override
	public boolean add(Arco a) {

		/* implementar */
		return false;
	}

	/**
	 * Retorna un grafo nuevo que es una copia del grafo actual.
	 */
	@Override
	public Object clone() {

		/* implementar */
		return null;
	}

	/**
	 * Retorna true si el grafo contiene un nodo igual a n,
	 * si no retorna false.
	 */
	@Override
	public boolean contains(Nodo n) {

		/* implementar */
		return false;
	}

	/**
	 * Retorna true si el grafo contiene un arco igual a a,
	 * si no retorna false.
	 */
	@Override
	public boolean contains(Arco a) {

		/* implementar */
		return false;
	}

	/**
	 * Remueve del grafo el nodo n con todos sus arcos relacionados.
	 * Si el grafo se modifica (si el nodo existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	@Override
	public boolean remove(Nodo n) {

		/* implementar */
		return false;
	}

	/**
	 * Remueve el arco a del grafo.
	 * Si el grafo se modifica (si el arco existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	@Override
	public boolean remove(Arco a) {

		/* implementar */
		return false;
	}

	/**
	 * Devuelve una lista con todos los nodos del grafo.
	 */
	@Override
	public Lista<Nodo> getNodos() {

		/* implementar */
		return null;
	}
	
	/**
	 * Devuelve una lista con todos los arcos del grafo.
	 */
	@Override
	public Lista<Arco> getArcos() {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve el numero de nodos que hay en el grafo.
	 */
	@Override
	public int getNumNodos() {

		return this.numNodos;
	}
	
	/**
	 * Devuelve el numero de arcos que hay en el grafo.
	 */
	@Override
	public int getNumArcos() {

		return this.numArcos;
	}

	/**
	 * Devuelve una lista con los predecesores del nodo n.
	 */
	@Override
	public Lista<Nodo> getPred(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una lista con los sucesores del nodo n.
	 */
	@Override
	public Lista<Nodo> getSuc(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una lista con los arcos que tienen al nodo n como destino.
	 */
	@Override
	public Lista<Arco> getIn(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una lista con los arcos que tienen al nodo n como fuente.
	 */
	@Override
	public Lista<Arco> getOut(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una representacion en String del grafo.
	 */
	@Override
	public String toString() {

		/* implementar */
		return "";
	}
}
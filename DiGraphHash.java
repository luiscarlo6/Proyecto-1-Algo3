/**
 * Clase que implementa la interfaz Graph para un 
 * grafo dirigido con tablas de hash.
 */
public class DiGraphHash implements Graph{
	
	private int numNodos, numArcos;
	private ArrDin<Nodo> nodos;
	private ArrDin<Lista<Arco>> arcosIn;
	private ArrDin<Lista<Arco>> arcosOut;

	public DiGraphHash () {
		this.nodos = new ArrDin<Nodo>();
		this.arcosIn = new ArrDin<Lista<Arco>>();
		this.arcosOut = new ArrDin<Lista<Arco>>();
		this.numArcos = 0;
		this.numNodos = 0;
	}

	/**
	 * Agrega el nodo n. Si el nodo ya existe en el grafo, retorna false.
	 * Si se agrega correctamente el nodo, retorna true.
	 */
	@Override
	public boolean add(Nodo n){
		if (n==null){
			return false;
		}
		
		if(this.numNodos >= this.nodos.tam()*0.7){
//			this.Ampliar();
			System.out.println("GRAFO LLENO "+this.numNodos+" Nodos"+ this.nodos.tam()*0.7);
			return false;
		}

		int pos = n.hashCode()%this.nodos.tam();
		boolean esta = false;
		if (this.nodos.get(pos)!=null){
			int i = pos;
			int j = 0;
			while (this.nodos.get(i%this.nodos.tam())!=null &&
					!esta && j!=this.nodos.tam()){
				esta = n.equals(this.nodos.get(i%this.nodos.tam()));
				i++;
				j++;
			}
			
			if (!esta){
				pos = i%this.nodos.tam();

			}
		}
		if (!esta){
			this.nodos.add(n, pos);
			this.arcosIn.add(new MiLista<Arco>(),pos);
			this.arcosOut.add(new MiLista<Arco>(),pos);
			this.numNodos++;
			return true;
		}
		return false;

	}

	/**
	 * Agrega el Arco a. Si los nodos del arco no existen en el grafo 
	 * o si ya existe un lado entre dichos nodos, retorna false. 
	 * Si se agrega correctamente el nodo, retorna true.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Arco a) {
		if (a==null){
			return false;
		}
		
		Nodo src = new Nodo(a.getSrc());
    	Nodo dst = new Nodo(a.getDst());
    	int posSrc = this.pos(src);
    	int posDst = this.pos(dst);
    	boolean estaSrc = posSrc!=-1;
    	boolean estaDst = posDst!=-1;
    	
    	if (estaSrc && estaDst){
    		MiLista<Arco> in =(MiLista<Arco>) this.arcosOut.get(posSrc);
			MiLista<Arco> out =(MiLista<Arco>) this.arcosIn.get(posDst);
			if (posDst==posSrc){
				boolean sal = in.contains(a); 
				if (!sal){
					in.add(a);
					this.numArcos++;
    				return true;
				}
			}
			else{				
				boolean as = in.contains(a) && out.contains(a);
				if (!as){
					out.add(a);
					in.add(a);
					this.numArcos++;
					return true;
				}
				return false;
			}
		}
		return false;
	}



	/**
	 * Retorna un grafo nuevo que es una copia del grafo actual.
	 */
	public Object clone() {
		/* implementar */
		return null;
	}

	/**
	 * Retorna true si el grafo contiene un nodo igual a n,
	 * si no retorna false.
	 */
	public boolean contains(Nodo n) {
		if (this.numNodos==0){
			return false;
		}
		boolean esta = false;
		int i = n.hashCode()%this.nodos.tam();
		
		if (n.equals(this.nodos.get(i))){
			return true;
		}
		i++;
		while (this.nodos.get(i%this.nodos.tam())!=null && !esta){
			esta = n.equals(this.nodos.get(i%this.nodos.tam()));
			i++;
		}
		return esta;
	}

	/**
	 * Retorna true si el grafo contiene un arco igual a a,
	 * si no retorna false.
	 */
	public boolean contains(Arco a) {

		boolean esta = false;
    	
    	Nodo src = new Nodo(a.getSrc());
    	Nodo dst = new Nodo(a.getDst());
    	boolean estaSrc = false;
    	boolean estaDst = false;
		
		int posSrc = src.hashCode()%this.nodos.tam();
    	int posDst = dst.hashCode()%this.nodos.tam();
    	if (this.nodos.get(posSrc)==null || this.nodos.get(posDst)==null){
    		return false;
    	}
    	else{
    		if(src.equals(this.nodos.get(posSrc))){
    			esta =((Lista<Arco>) this.arcosOut.get(posSrc)).contains(a);
	  			
    		}
    		else{

	    		int i = posSrc+1;
	    		int j = 0;
	    		estaSrc = false;
	  		  	while (this.nodos.get(i%this.nodos.tam())!=null&&
	  		  			!estaSrc&&j!=this.nodos.tam()){
	  		  	
	  		  		if(src.equals(this.nodos.get(i%this.nodos.tam()))){
	  		  			posSrc = i%this.nodos.tam();
	  		  			estaSrc = true;
	  		  		}
	  		  		i++;
	  		  		j++;
	  		  	}
	  		  	if (estaSrc){
	  		  		esta = ((Lista<Arco>)this.arcosOut.get(posSrc)).contains(a);
	  		  	}
    		}
    		return esta;
    	}
	}

	/**
	 * Remueve del grafo el nodo n con todos sus arcos relacionados.
	 * Si el grafo se modifica (si el nodo existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	public boolean remove(Nodo n) {

		/* implementar */
		return false;
	}

	/**
	 * Remueve el arco a del grafo.
	 * Si el grafo se modifica (si el arco existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	public boolean remove(Arco a) {

		/* implementar */
		return false;
	}

	/**
	 * Devuelve una lista con todos los nodos del grafo.
	 */
	public Lista<Nodo> getNodos() {

		/* implementar */
		return null;
	}
	
	/**
	 * Devuelve una lista con todos los arcos del grafo.
	 */
	public Lista<Arco> getArcos() {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve el numero de nodos que hay en el grafo.
	 */
	public int getNumNodos() {

		return this.numNodos;
	}
	
	/**
	 * Devuelve el numero de arcos que hay en el grafo.
	 */
	public int getNumArcos() {

		return this.numArcos;
	}

	/**
	 * Devuelve una lista con los predecesores del nodo n.
	 */
	public Lista<Nodo> getPred(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una lista con los sucesores del nodo n.
	 */
	public Lista<Nodo> getSuc(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una lista con los arcos que tienen al nodo n como destino.
	 */
	public Lista<Arco> getIn(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una lista con los arcos que tienen al nodo n como fuente.
	 */
	public Lista<Arco> getOut(Nodo n) {

		/* implementar */
		return null;
	}

	/**
	 * Devuelve una representacion en String del grafo.
	 */
	public String toString() {

		/* implementar */
		return "";
	}
	
	private int pos(Nodo n){
		if (n==null){
			return -1;
		}

		boolean esta = false;
		int pos = n.hashCode()%this.nodos.tam();
		
		if (n.equals(this.nodos.get(pos))){
			return pos;
		}
		pos++;
		while (this.nodos.get(pos%this.nodos.tam())!=null && !esta){
			esta = n.equals(this.nodos.get(pos%this.nodos.tam()));
			pos++;
		}

//    	boolean esta = false;
//    	
//    	int pos = n.hashCode()%this.nodos.tam();
//    	
//    	if (this.nodos.get(pos)!=null){
//    		
//    		if (!n.equals((this.nodos.get(pos)))){
//    			int i = pos+1;
//    			int j = 0;
//    			esta = false;
//    			while (this.nodos.get(i%this.nodos.tam())!=null&&
//    					!esta & j!=this.nodos.tam()){
//    				if (n.equals((this.nodos.get(i%this.nodos.tam())))){
//    					pos = i%this.nodos.tam();
//    					esta = true;
//    				}
//    				i++;
//    				j++;
//    			}
//    		}
//    		else
//    			esta = true;
//    	}
    	if (esta)
    		return pos-1;
    	
    	return -1;
	}
}
/**
 * Clase que implementa la interfaz Graph para un 
 * grafo dirigido con tablas de hash.
 */
public class DiGraphHash implements Graph{
	
	private int numNodos, numArcos;
	private ArrDin<Nodo> nodos;
	private ArrDin<Lista<Arco>> arcosIn;
	private ArrDin<Lista<Arco>> arcosOut;

	public DiGraphHash() {
		this.nodos = new ArrDin<Nodo>();
		this.arcosIn = new ArrDin<Lista<Arco>>();
		this.arcosOut = new ArrDin<Lista<Arco>>();
		this.numArcos = 0;
		this.numNodos = 0;
	}
	

	private ArrDin<Nodo> getArrNodos(){
		return this.nodos;
	}
	
	private ArrDin<Lista<Arco>> getArrIn(){
		return this.arcosIn;
	}
	
	private ArrDin<Lista<Arco>> getArrOut(){
		return this.arcosOut;
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
			this.ampliar();
//			System.out.println("GRAFO LLENO "+this.numNodos+" Nodos"+ this.nodos.tam()*0.7);
//			return false;
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
    	boolean as=false;
    	if (estaSrc && estaDst){
    		MiLista<Arco> out =(MiLista<Arco>) this.arcosOut.get(posSrc);
			MiLista<Arco> in =(MiLista<Arco>) this.arcosIn.get(posDst);
			as = !in.contains(a) && !out.contains(a);

			if (as){
				
				out.add(a);
				in.add(a);
				this.numArcos++;
				return true;
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
	@Override
	public boolean contains(Nodo n) {
		if (this.numNodos==0||n==null){
			return false;
		}
		int pos = this.pos(n);
		boolean esta = pos!=-1;
		return esta;
	}

	/**
	 * Retorna true si el grafo contiene un arco igual a a,
	 * si no retorna false.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean contains(Arco a) {
		if (a==null||this.numArcos==0){
			return false;
		}
    	
    	Nodo src = new Nodo(a.getSrc());
    	Nodo dst = new Nodo(a.getDst());
		
		int posSrc = this.pos(src);
    	int posDst = this.pos(dst);
    	boolean estaSrc = posSrc!=-1;
    	boolean estaDst = posDst!=-1;
    	
    	boolean estaArcoSrc = false;
		boolean estaArcoDst = false;
    	
    	if (estaSrc && estaDst){
    		estaArcoSrc = ((MiLista<Arco>) this.arcosOut.get(posSrc)).contains(a);
    		estaArcoDst = ((MiLista<Arco>) this.arcosIn.get(posDst)).contains(a);
    	}
    	
		return estaArcoSrc && estaArcoDst;

	}

	/**
	 * Remueve del grafo el nodo n con todos sus arcos relacionados.
	 * Si el grafo se modifica (si el nodo existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(Nodo n) {
		if (n==null||this.numNodos==0){
			return false;
		}
		int pos = this.pos(n);
		boolean esta = pos!=-1;
		
		if (esta){
			
			Object[] arcosIn = ((MiLista<Arco>) this.arcosIn.get(pos)).toArray();
			Object[] arcosOut = ((MiLista<Arco>) this.arcosOut.get(pos)).toArray();
			int i = 0;
			while (i!=arcosIn.length){
				Arco arc = (Arco) arcosIn[i];
				this.remove(arc);
				i++;
			}
			i=0;
			while (i!=arcosOut.length){
				Arco arc = (Arco) arcosOut[i];
				this.remove(arc);
				i++;
			}

			this.arcosIn.remove(pos);
			this.arcosOut.remove(pos);
			this.nodos.remove(pos);
			this.numNodos--;
			return true;
		}
		return false;
	}

	/**
	 * Remueve el arco a del grafo.
	 * Si el grafo se modifica (si el arco existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(Arco a) {
		if (a==null||this.numArcos==0){
			return false;
		}
		Nodo src = new Nodo(a.getSrc());
    	Nodo dst = new Nodo(a.getDst());
		
		int posSrc = this.pos(src);
    	int posDst = this.pos(dst);
    	boolean estaSrc = posSrc!=-1;
    	boolean estaDst = posDst!=-1;
    	
    	if (estaSrc && estaDst){
    		MiLista<Arco> out =((MiLista<Arco>) this.arcosOut.get(posSrc));
			MiLista<Arco> in =((MiLista<Arco>) this.arcosIn.get(posDst));
			boolean quitado = out.remove(a)&&in.remove(a);
			if (quitado)
				this.numArcos--;
			return quitado;
		}
			return false;
	}

	/**
	 * Devuelve una lista con todos los nodos del grafo.
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Lista<Nodo> getNodos() {
		Lista<Nodo> lista = new MiLista();
		int i = 0;
		int j = 0;
		
		while(i!=this.nodos.tam() && j!=this.numNodos){
			if (this.nodos.get(i)!=null){
				lista.add( (Nodo) this.nodos.get(i));
				j++;
			}
			i++;
		}
		return lista;
	}
	
	/**
	 * Devuelve una lista con todos los arcos del grafo.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Lista<Arco> getArcos() {
    	Lista<Arco> lista = new MiLista<Arco>();
    	Arco a = null;
    	
    	if (this.numArcos==0){
        	return lista;
        }        
    	
        int i = 0;
        int k = 0;
        while (i!=this.nodos.tam()){
        	
        	if (this.nodos.get(i)!=null){
        			
        		MiLista<Arco> listaIn =(MiLista<Arco>) this.arcosIn.get(i);
        		MiLista<Arco> listaOut = ((MiLista<Arco>) this.arcosOut.get(i));
        		ListIterator<Arco> it = listaIn.iterator();
        		k = 0;
        		
        		while (k!=listaIn.getSize()) {
            		a = it.next();
            		if (!lista.contains(a)){
            			lista.add(a);
            		}
            		k++;
            	}
        		
        		
        		it = listaOut.iterator();
        		k = 0;
        		while (k!=listaOut.getSize()) {
            		a = it.next();
            		if (!lista.contains(a)){
            			lista.add(a);
            		}
            		k++;
            	}
        	}
        	i++;
        	
        }
        
    	
		return lista;
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
	@SuppressWarnings("unchecked")
	public Lista<Nodo> getPred(Nodo n) {
		Lista<Nodo> lista = new MiLista<Nodo>();
    	if (this.numArcos==0){
        	return lista;
        }

        int pos = this.pos(n);
        boolean esta = pos!=-1;
       
    	if (esta){
    		MiLista<Arco> listaIn = ((MiLista<Arco>) this.arcosIn.get(pos));
			ListIterator<Arco> it = listaIn.iterator();
    		int k = 0;
    		Nodo a = null;
    		while (k!=listaIn.getSize()) {
        		a = new Nodo(it.next().getSrc());
    			lista.add(a);
        		k++;
        	}
		}
    	return lista;
	}
        
        	

	/**
	 * Devuelve una lista con los sucesores del nodo n.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Lista<Nodo> getSuc(Nodo n) {
		Lista<Nodo> lista = new MiLista<Nodo>();
    	if (this.numArcos==0){
        	return lista;
        }

        int pos = this.pos(n);
        boolean esta = pos!=-1;
       
    	if (esta){
    		MiLista<Arco> listaOut = ((MiLista<Arco>) this.arcosOut.get(pos));
			ListIterator<Arco> it = listaOut.iterator();
    		int k = 0;
    		Nodo a = null;
    		while (k!=listaOut.getSize()) {
        		a = new Nodo(it.next().getDst());
    			lista.add(a);
        		k++;
        	}
		}
    	return lista;
	}

	/**
	 * Devuelve una lista con los arcos que tienen al nodo n como destino.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Lista<Arco> getIn(Nodo n) {

		int pos = this.pos(n);
		boolean esta = pos!=-1;
		
		if (esta){
			return ((Lista<Arco>) this.arcosIn.get(pos));
		}
		return new MiLista<Arco>();
	}

	/**
	 * Devuelve una lista con los arcos que tienen al nodo n como fuente.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Lista<Arco> getOut(Nodo n) {

		int pos = this.pos(n);
		boolean esta = pos!=-1;
			
		if (esta){
			return ((Lista<Arco>) this.arcosOut.get(pos));
		}
		return new MiLista<Arco>();
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
		int i=0;
		while (/*this.nodos.get(pos%this.nodos.tam())!=null*/i!=this.nodos.tam() && !esta){
			esta = n.equals(this.nodos.get(pos%this.nodos.tam()));
			pos++;
			i++;
		}
		
//		
//		    	boolean esta = false;
//		    	
//		    	int pos = n.hashCode()%this.nodos.tam();
//		    	
//		    	if (this.nodos.get(pos)!=null){
//		    		
//		    		if (!n.equals((this.nodos.get(pos)))){
//		    			int i = pos+1;
//		    			int j = 0;
//		    			esta = false;
//		    			while (this.nodos.get(i%this.nodos.tam())!=null&&
//		    					!esta & j!=this.nodos.tam()){
//		    				if (n.equals((this.nodos.get(i%this.nodos.tam())))){
//		    					pos = i%this.nodos.tam();
//		    					esta = true;
//		    				}
//		    				i++;
//		    				j++;
//		    			}
//		    		}
//		    		else
//		    			esta = true;
//		    	}
    	if (esta)
    		return pos-1;
    	
    	return -1;
	}
	
	private void ampliar(){
		Lista<Nodo> nodos = this.getNodos();
		Lista<Arco> arcos = this.getArcos();
		this.nodos.resize();
		this.arcosIn.resize();
		this.arcosOut.resize();
		this.numArcos = 0;
		this.numNodos = 0;
		
		ListIterator<Nodo> it1 = ((MiLista<Nodo>)nodos).iterator();
		int i = 0;
		while (i!=nodos.getSize()){
			Nodo n = it1.next();
			this.add(n);
			i++;
		}
		
		ListIterator<Arco> it2 = ((MiLista<Arco>)arcos).iterator();
		i = 0;
		
		while (i!=arcos.getSize()){
			Arco a = it2.next();
			this.add(a);
			i++;
		}
		
	}
}
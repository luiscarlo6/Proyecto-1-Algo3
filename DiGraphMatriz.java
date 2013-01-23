/**
 * Clase que implementa la interfaz Graph para un 
 * grafo dirigido de matriz de adyacencia.
 */
public class DiGraphMatriz implements Graph{
	
	private int numNodos, numArcos;
	private Nodo nodos[];
	private boolean arcos[][];
	private int anterior,actual;

	public DiGraphMatriz () {
		this.numNodos = 0;
		this.numArcos = 0;
		this.anterior = 5;
		this.actual = 8;
		this.nodos = new Nodo[this.actual];
		this.arcos = new boolean[this.actual][this.actual];
	}

	/**
	 * Agrega el nodo n. Si el nodo ya existe en el grafo, retorna false.
	 * Si se agrega correctamente el nodo, retorna true.
	 */
	@Override
	public boolean add(Nodo n) {

		if(this.contains(n)){
			return false;
		}
		this.Ampliar();
		//System.out.println(this.nodos.length);
		//System.out.println(this.arcos.length);
		this.nodos[this.numNodos] = n;
		this.numNodos++;
		return true;
	}

	/**
	 * Agrega el Arco a. Si los nodos del arco no existen en el grafo 
	 * o si ya existe un lado entre dichos nodos, retorna false. 
	 * Si se agrega correctamente el nodo, retorna true.
	 */
	@Override
	public boolean add(Arco a) {
		int Temp[]=new int[2];
		Temp[0] = -1;
		Temp[1] = -1;
		
		this.Buscar(Temp, a.getSrc(), a.getDst());
		
		if (Temp[0]>-1 && Temp[1]>-1){
			this.arcos[Temp[0]][Temp[1]]=true;
			this.numArcos++;
			return true;
			
		}
		
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
		int i=0;
		
		while(i!=this.numNodos){
			if(this.nodos[i].equals(n)){
				return true;
			}
			i++;
		}
		
		return false;
	}

	/**
	 * Retorna true si el grafo contiene un arco igual a a,
	 * si no retorna false.
	 */
	@Override
	public boolean contains(Arco a) {

		int Temp[]=new int[2];
		Temp[0] = -1;
		Temp[1] = -1;
		
		this.Buscar(Temp, a.getSrc(), a.getDst());//busco las posisiones si existen
		
		if (Temp[0]>-1 && Temp[1]>-1){
			this.arcos[Temp[0]][Temp[1]]=true;
			return true;
			
		}
		return false;
	}

	/**
	 * Remueve del grafo el nodo n con todos sus arcos relacionados.
	 * Si el grafo se modifica (si el nodo existia en este), retorna true.
	 * Si el grafo se mantiene igual, retorna false.
	 */
	@Override
	public boolean remove(Nodo n) {

		if(n==null){
			return false;
		}
		
		int Pos=-1;
		
		Pos= this.Buscar(n.toString());
		
		if (Pos!=-1){
			
			this.Reajustar(Pos);
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
	public boolean remove(Arco a) {

		int Temp[]=new int[2];
		Temp[0] = -1;
		Temp[1] = -1;
		
		this.Buscar(Temp, a.getSrc(), a.getDst());
		
		if (Temp[0]>-1 && Temp[1]>-1){
			
			if(this.arcos[Temp[0]][Temp[1]]==true){
				this.arcos[Temp[0]][Temp[1]]=false;
				return true;
			}
		}		
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


	@Override
	public int colisiones() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void Imprimir(){
		DiGraphMatriz Aux;
		Aux = this;
		int i;
		
		i=0;
		while(i!=this.numNodos){
			System.out.println(Aux.nodos[i]);
			i++;
			
		}
		
		
	}
	
	
	
	private final void Ampliar(){
		
		if (this.numNodos >= this.nodos.length){
				System.gc();
				Nodo NodoNuevo[];
				boolean ArcosNuevos[][];
				int Temp;
				
				//recalculo el tamano del nuevo arreglo
				// calculando un fibonacci
				Temp = this.actual;
				this.actual = this.actual + this.anterior;
				this.anterior = Temp;
				
				NodoNuevo = new Nodo[this.actual];
				ArcosNuevos = new boolean[this.actual][this.actual];
				
				System.arraycopy(this.nodos, 0, NodoNuevo, 0, this.nodos.length);
				
				//System.out.println();
				//System.out.println(this.nodos.length);
				//System.out.println();
				for (int i = 0; i != this.nodos.length; i++) {
					//System.out.println("Entreeee"+i);
					//int[] member = new int[this.actual];
					System.arraycopy(this.arcos[i], 0, ArcosNuevos[i], 0, this.nodos.length);
					// = member;
				}
				
				this.nodos = NodoNuevo;
				this.arcos = ArcosNuevos;
				System.gc();
		}
	}	
	
	
	private final void Buscar(int[] Al, String N1, String N2){
		
		int i=0,j=0;
		
		
		while (i!=this.numNodos && j!=2){
			
			if(this.nodos[i].toString().equals(N1)){
				Al[0] = i;
				j++;
			}
			if (this.nodos[i].toString().equals(N2)){
				Al[1] = i;
				j++;
			}
			i++;
		}
		
	}
	
	
	
	private final void Reajustar(int Pos){
		

			System.gc();
			Nodo NodoNuevo[];
			boolean ArcosNuevos[][];
			int Temp;
			
			NodoNuevo = new Nodo[this.actual];
			ArcosNuevos = new boolean[this.actual][this.actual];
			
			//System.arraycopy(this.nodos, 0, NodoNuevo, 0, this.nodos.length);
			
			int i=0,j=0,k=0,l=0;
			boolean Aux=false,Aux1=false,Aux2=false,Aux3=false;
			while(i!=this.numNodos){
				j=0;
				if(i==Pos && !Aux3){
					k=i+1;
					Aux2=true;
				}else if(i!=Pos) {
					k=i;
				}
				
				while(j!=this.numNodos-1){
		
					if(j==Pos && !Aux1){
						l=j+1;
						Aux =true;
					}else if(j!=Pos && !Aux1){
						l=j;
					}
					if(Aux){
						l=j+1;
						Aux1=true;
					}
					
					ArcosNuevos[i][j]= this.arcos[k][l];
					
					j++;
				}
				
				if (Aux2){
					k=i+1;
					Aux3=true;
				}
				NodoNuevo[i]=this.nodos[k];
				
				i++;
			}
			this.nodos = NodoNuevo;
			this.arcos = ArcosNuevos;
			System.gc();
}

	
	
private final int Buscar(String N1){
		
		int i=0,Pos=-1;
		
		
		while (i!=this.numNodos && !(Pos>-1)){
			
			if(this.nodos[i].toString().equals(N1)){
				Pos = i;
			}
			i++;
		}
		return Pos;
	}
	


public final void Imprimir1(){
	int i=0;
	while (i!=this.arcos.length){
		int j=0;
		while (j!=this.arcos.length){
			System.out.print(this.arcos[i][j]+"\t");
			j++;
		}
		System.out.println();
		i++;
	}
	
}

}
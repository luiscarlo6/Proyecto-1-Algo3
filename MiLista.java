/**
 * Clase que implementa la interfaz Lista
 * Esta es una clase parametrizada con tipo (clase) E; i.e., la
 * lista contiene elementos de tipo E.
 */
public class MiLista<E> implements Lista<E>{
    /*
     * Modelo de representacion: lista doblemente enlazada 
     * con un centinela.
     * La primera "caja" esta vacia.
     */
	private Caja<E> centinela = null;
	private int tam = 0;
	
    /*
     * Constructor
     */
    public MiLista() {
    	this.tam = 0;
    	this.centinela = new Caja<E>(null);
    	this.centinela.cambiarAnterior(this.centinela);
    	this.centinela.cambiarSiguiente(this.centinela);
    	
    }

    /**
     * Agrega un elemento a la lista.
     */
    public boolean add(E element) {
    	
    	
    	if (element==null || this.contains(element)) {
    		return false;
    	}
    	if (this.tam==0) {
    		this.centinela.cambiarAnterior(element);
    		this.centinela.cambiarSiguiente(this.centinela.cajaAnt());
    	}
    	else {
    		Caja<E> ult = this.centinela.cajaAnt();
    		ult.cambiarSiguiente(element);
    		ult.cajaSig().cambiarSiguiente(this.centinela);
    	}
    	this.tam ++;
    	return true;
    }

    /**
     * Elimina todos los elementos de la lista. La lista queda
     * como recien creada.
     */
    public void clear(){
    	this.tam = 0;
    	this.centinela = new Caja<E>(null);
    	this.centinela.cambiarAnterior(this.centinela);
    	this.centinela.cambiarSiguiente(this.centinela);
    }

    /**
     * Determina si el elemento dado esta en la lista.
     */
    public boolean contains(Object element){
    	if (element==null){
    		return false;
    	}
    	Caja<E> aux = this.centinela.cajaSig();
    	int i = 0;
    	
    	while (i!=this.tam){
    		if (aux.elemento().equals(element)){
    			return true;
    		}
    		i++;
    		aux = aux.cajaSig();
    	}
    	return false;
    }

    /**
     * Determina si la lista dada es igual a la lista.
     */
    public boolean equals(Lista<E> lista){
    	boolean sent = false;
    	
    	if (this==null || lista==null){
    		return false;
    	}
    	
    	if (this.tam==0 && lista.getSize()==0){
    		return true;
    	}
    	
    	if (this.tam==lista.getSize()){
    		
    		Caja<E> aux1 = this.centinela.cajaSig();
    		Caja<E> aux2 = lista.getCaja();
//    		sent = aux1.verContenido()==aux2.verContenido();
    		int i = 0;
    		sent = true;
    		while (i!=this.tam && i!=lista.getSize() && sent){
    			sent = aux1.elemento().equals(aux2.elemento());
    			aux1 = aux1.cajaSig();
        		aux2 = aux2.cajaSig();
        		i ++;
    		}
    	}
    	return sent;
    }
    
    /**
	 *Retorna la primera "caja" de la lista 
	 **/
    public Caja<E> getCaja(){
    	if (this==null){
    		return null;
    	}
    	return this.centinela.cajaSig();
    }
    
    /**
     *  Retorna el primer de la lista.
     */
    public E get(){
    	if (this==null){
    		return null;
    	}
    	return this.centinela.cajaSig().elemento();
    }

    /**
     * Determina si la lista es vacia.
     */
    public boolean isEmpty(){
    	 return this==null || this.getSize()==0;
    }

    /**
     * Elimina el elemento dado de la lista. Si la lista cambia,
     * retorna true, sino retorna false.
     */
    public boolean remove(E element){

    	if (element==null || this.isEmpty()) {
            return false;
        }
    	else {
        	int i = 0;
            Caja<E> aux1 = this.getCaja();            
            boolean sent = aux1.elemento().equals(element);
            
            while ( i!=this.tam && !sent && aux1.cajaSig().elemento()!=null) {
                sent = aux1.cajaSig().elemento().equals(element);
            	i ++;
            	aux1 = aux1.cajaSig();            	
            }
            if (sent){
            	aux1.cajaAnt().cambiarSiguiente(aux1.cajaSig());
            	this.tam--;
            }
            
            return sent;
    	}
    }

    /**
     * Retorna el numero de elementos en la lista
     */
    public int getSize(){
    	if (this==null){
    		return 0;
    	}
    	return this.tam;
    }

    /**
     * Retorna un arreglo que contiene todos los elementos
     * en esta lista.
     */
    public Object[] toArray() {
    	if (this==null){
    		return new Object[0];
    	}
    	if (this.tam==0){
    		return new Object[this.tam];
    	}
    	
    	Object[] Alista = new Object[this.tam];
    	int i = 0;
    	Caja<E> e = this.getCaja();
    	while (i!=this.tam){
    		Alista[i] = e.elemento();
    		i ++;
    		e = e.cajaSig();
    	}
    	return Alista;
    }
}

// End List.
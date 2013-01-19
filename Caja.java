/**
 * Clase que implementa una caja que 
 * contiene un elemento de tipo E con
 * apunntador a una caja anterior y una
 * siguiente
 */
public class Caja<E> {
	
	private Caja<E> siguiente = null;
	private Caja<E> anterior = null;
	private E elemento = null;
	
	/**
     *Constructor por defecto 
     */
	public Caja() {
		this.siguiente = null;
		this.anterior=null;
		this.elemento=null;
	}
	
	/**
     * Constructor agregando un elemento
     */
	public Caja(E e){
		this.elemento = e;
		this.siguiente = null;
		this.anterior=null;		
	}
	
	/**
     * Cambia el elemento de la caja
     */
	public boolean cambiarElemento(E e){
		this.elemento = e;
		return true;
	}
	
	/**
     * cambia el elemento de la caja siguiente
     */
	public boolean cambiarSiguiente(E e){
		Caja<E> sig = new Caja<E>(e);
		if (this!=null){
			this.siguiente = sig;
			sig.anterior = this;
			return true;
		}
		return false;
	}
	
	/**
     * retorna la caja siguiente
     */
	public Caja<E> cajaSig(){
		return this.siguiente;
	}
	
	/**
     * retorna la caja anterior
     */
	public Caja<E> cajaAnt(){
		return this.anterior;
	}
	
	/**
     * Cambia la caja siguiente de la caja actual
     */
	public boolean cambiarSiguiente(Caja<E> e){
		if (this!=null){
			this.siguiente = e;
			e.anterior = this;
			return true;
		}
		return false;
	}
	
	/**
     * Cambia la caja anterior de la caja actual
     * por una que contenga a el elemento "e"
     */
	public boolean cambiarAnterior(E e){
		Caja<E> ant = new Caja<E>(e);
		if (this!=null){
			this.anterior = ant;
			ant.siguiente = this;
			return true;
		}
		return false;
	}
	
	/**
     * Cambia la caja siguiente de la caja actual
     */
	public boolean cambiarAnterior(Caja<E> e){
		if (this!=null){
			this.anterior = e;
			e.siguiente = this;
			return true;
		}
		return false;
	}
	
	/**
     * Retorna el elemento de la caja
     */
	public E elemento(){
		return this.elemento;
	}
	
	/**
     * retorna el elemento de la caja siguiente
     */
	public E siguiente(){
		return this.siguiente.elemento;
	}
	
	/**
     * retorna el elemento de la caja anterior
     */
	public E anterior(){
		return this.anterior.elemento;
	}
	
	/**
     * dice si la caja contiene el elemento "e"
     */
	public boolean contiene(E e){
		if (e!=null){
			return this.elemento.equals(e);
		}
		else{
			return false;
		}		
	}
	
	/**
     * devuelve en string el elemento que esta en la caja
     */
	public String toString() {
		return this.elemento.toString();
	}
	 
	/**
     * dice si dos cajas son iguales
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean equals(Caja c) {
		if (c==null){
			return false;
		}
		Caja<E> d = ((Caja<E>) c);
        return (c instanceof Caja<?>) && d.elemento.equals(d.elemento);
	}
}
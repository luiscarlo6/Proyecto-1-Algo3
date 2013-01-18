
public class Caja<E> {
	
	private Caja<E> siguiente = null;
	private Caja<E> anterior = null;
	private E elemento = null;
	
	public Caja() {
		this.siguiente = null;
		this.anterior=null;
		this.elemento=null;
	}
	
	public Caja(E e){
		this.elemento = e;
		this.siguiente = null;
		this.anterior=null;		
	}
	public boolean cambiarElemento(E e){
		this.elemento = e;
		return true;
	}
	
	public boolean cambiarSiguiente(E e){
		Caja<E> sig = new Caja<E>(e);
		if (this!=null){
			this.siguiente = sig;
			sig.anterior = this;
			return true;
		}
		return false;
	}
	
	public Caja<E> cajaSig(){
		return this.siguiente;
	}
	
	public Caja<E> cajaAnt(){
		return this.anterior;
	}
	
	public boolean cambiarSiguiente(Caja<E> e){
		if (this!=null){
			this.siguiente = e;
			e.anterior = this;
			return true;
		}
		return false;
	}
	
	public boolean cambiarAnterior(E e){
		Caja<E> ant = new Caja<E>(e);
		if (this!=null){
			this.anterior = ant;
			ant.siguiente = this;
			return true;
		}
		return false;
	}
	
	public boolean cambiarAnterior(Caja<E> e){
		if (this!=null){
			this.anterior = e;
			e.siguiente = this;
			return true;
		}
		return false;
	}
	
	public E elemento(){
		return this.elemento;
	}
	
	public E siguiente(){
		return this.siguiente.elemento;
	}
	
	public E anterior(){
		return this.anterior.elemento;
	}
	
	public boolean contiene(E e){
		if (e!=null){
			return this.elemento.equals(e);
		}
		else{
			return false;
		}		
	}
	
	public String toString() {
		return this.elemento.toString();
	}
	 
	@SuppressWarnings("unchecked")
	public boolean equals(Object c) {
		if (c==null){
			return false;
		}
		Caja<E> d = ((Caja<E>) c);
        return (c instanceof Caja<?>) && d.elemento.equals(d.elemento);
	}
}
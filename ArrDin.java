/**
 * Clase que implementa un arreglo dinamico.
 */
/*
 * Luiscarlo Rivera
 * Jose Prado
 */
public class ArrDin<E>{
	
	private Object arr[] = null;
	private int anterior;
	private int actual;
	private int ocupados;
	
	/**
	 * Construcctor por defecto
	 **/
	public ArrDin(){
		this.anterior = 21;
		this.actual = 34;
		this.ocupados = 0;
		this.arr = new Object[actual];
	}
	
	/**
	 * Agrega un elemento a la posicion 
	 * "pos" del arreglo 
	 **/
	public boolean add(E e,int pos){
		if (e==null){
			return false;
		}		
		this.ampliar();
		if (this.arr[pos]==null){
			this.ocupados++;
		}
		this.arr[pos] = e;
		return true;
	}
	
	/**
	 * Retorna el objeto almacenado en la posicion 
	 * "pos" del arreglo
	 **/
	public Object get(int pos){
		return this.arr[pos];
	}
	
	/**
	 * Amplia el tamaño del arreglo en funcion de
	 * la sucecion de fibonacci
	 **/
	public void ampliar(){
		if (!(this.ocupados>=this.actual)){
			return;			
		}
		
		int nuevoTam = this.actual+this.anterior;
		this.anterior = this.actual;
		this.actual = nuevoTam;
		Object nuevoArr[] = new Object[nuevoTam];
		
		System.arraycopy(this.arr, 0, nuevoArr, 0, this.arr.length);
		
//		for (int i= 0; i!=this.arr.length;i++){
//			nuevoArr[i] = this.arr[i];
//		}
		this.arr = nuevoArr;
	}
	
	/**
	 * Elimina todos los elementos del arreglo
	 * (el arreglo queda como recien creado)
	 **/
	public void clear(){
		this.ocupados = 0;
		this.arr = new Object[actual];
	}
	
	/**
	 * Verifica si el arreglo contiene el elemento o
	 **/
	public boolean contains(E o){
		int i = 0;
		boolean e = false;
		if (this.arr.length == 0) 
				return false;
		else {
		while((!this.arr[i].equals(o)) && (i < this.arr.length)) {
			i++;
		}

		if (this.arr[i].equals(o)){
			e = true;
		}
		return e;
		}
	}
	
	/**
	 * retorna el arreglo
	 **/
	public Object[] getArr(){
		return this.arr;
	}
	
	/**
	 * retorna el tamaño del arreglo
	 **/
	public int tam(){
		return this.arr.length;
	}
}

/**
 * 
 */

/**
 * @author luiscarlo
 *
 */
public class ArrDin<E>{
	
	private Object arr[] = null;
	private int anterior;
	private int actual;
	private int ocupados;
	
	public ArrDin(){
		this.anterior = 21;
		this.actual = 34;
		this.ocupados = 0;
		this.arr = new Object[actual];
	}
	
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
	
	public void ampliar(){
		if (!(this.ocupados>=this.actual)){
			return;			
		}
		
		int nuevoTam = this.actual+this.anterior;
		this.anterior = this.actual;
		this.actual = nuevoTam;
		Object nuevoArr[] = new Object[nuevoTam];
		
		System.arraycopy(this.arr, 0, nuevoArr, 0, this.arr.length);
		this.arr = nuevoArr;
	}
	
	public void clear(){
		this.ocupados = 0;
		this.arr = new Object[actual];
	}
	
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
	
	
	public Object[] getArr(){
		return this.arr;
	}
	
	public int tam(){
		return this.arr.length;
	}
}

/**
 * 
 */

/**
 * @author luiscarlo
 *
 */
public interface DynamicArray<E> {	
	
	
	/**
	 * Agrega un elemento
	 **/
	public boolean add(E e);	
	
	/**
	 * 
	 **/
	public boolean add(E e,int pos);
	
	/**
	 * 
	 **/
	Object get(int pos);
	
	/**
	 * 
	 **/
	void ampliar();

	/**
	 * 
	 **/
	public void clear();
	
	/**
	 * 
	 **/
	public boolean contains(E o);
	
	/**
	 * 
	 **/
	public Object[] getArr();
	
	/**
	 * 
	 **/
	public int tam();
	
	/**
	 * 
	 **/
	public boolean remove(int pos);
	
	/**
	 * 
	 **/
	public boolean remove(E e);
	
}

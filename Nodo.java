import java.lang.Math;
/**
 * Clase que almacena la informacion de las aristas en el grafo.
 */

public class Nodo {

	//id es unico
	private String id = null;

  /**
	 * Construcctor por defecto
	 */
	
	public Nodo(){
		this.id = "";
	}
	
	
	/**
	 * Crea un nodo con id i.
	 */
	public Nodo (String i) {
		this.id = new String(i);
	}

	/**
	 * Retorna un nuevo nodo que es copia de this.
	 */
	@Override
	protected Object clone() {
		return new Nodo(this.id);
	}

	/**
     * Indica si el nodo de entrada es igual a this.
     */
	@Override
	public boolean equals(Object o) {
		Nodo n;

		if (o == null)
			return false;

		if (!(o instanceof Nodo))
			return false;

		n = (Nodo) o;

		if (this.id.equalsIgnoreCase(n.id))
			return true;

		return false;
	}

	/**
     * Retorna la representacion en String del nodo.
     */
	@Override
	public String toString() {

		return new String(this.id);
	}

	/**
	 * Retorna el codigo hash para un nodo.
	 */
	@Override
	public int hashCode() {
    	int hash=13;
    	int len = this.id.length();
    	for (int i = 0; i < len; i++) {
    		hash = 37 * hash + this.id.charAt(i);
    	}

//		hash = Math.abs(this.id.hashCode());
    	
    	return Math.abs(hash);
	}
}
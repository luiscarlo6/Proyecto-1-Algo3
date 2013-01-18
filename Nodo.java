import java.lang.Math;
/**
 * Clase que almacena la informacion de las aristas en el grafo.
 */

public class Nodo {

	//id es unico
	private String id = null;

	/**
	 * Construcctor por defecto
	 **/
	
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

		int radix = 128; /*Que es equivalente a 2^7*/
		int hash=0;/*Valor del string id*/

		/*como el string no es mas que un polinomio se evalua mediante el metodo de HORNER*/
		for (int i = this.id.length()-1; i >= 0; i--){
            hash = this.id.charAt(i) + (radix*hash);
      }
      return(hash);
	}
	
	
	public static void main(String args[]) {
		Nodo Aux, Aux1;
		Object Aux3;
		
			Aux = new Nodo();
			Aux1 = new Nodo("Nodo1");
			Aux3= Aux1.clone();
			
			//System.out.println();
			//System.out.println(Aux.toString());
			
			//System.out.println(Aux1.toString());
			
			//Aux1=new Nodo("HOLAAA");
			//System.out.println(Aux1.toString());
			//System.out.println(Aux3.toString());
			
			
			
			System.out.println(Aux1.hashCode());
			//System.out.println(Aux3.hashCode());
	}
	
}
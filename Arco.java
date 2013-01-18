import java.lang.Math;

/**
 * Clase que almacena la informacion de las aristas en el grafo.
 */
public class Arco {

    private String src = null;
    private String dst = null;

   /**
     * Constructor por defecto
     */
    public Arco() {
        this.src = "";
        this.dst = "";
    }
    
    /**
     * Crea una arista entre los vertices src y dst.
     */
    public Arco(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    /**
     * Retorna una nueva arista que es copia de this.
     */
    @Override
    protected Object clone() {
    	// se copian (clonan) todos los objetos internos, 
    	// no solo asignar las referencia.
    	return new Arco(new String(this.src), new String(this.dst));
    }

    /**
     * Indica si la arista de entrada es igual a this.
     */
    public boolean equals(Object o) {
        Arco Temp;
        
        if(o==null){
			 return false;
        }
        
        if (!(o instanceof Nodo)){
			 return false;
        }
        
        Temp = (Arco) o;

		  if (this.src.equalsIgnoreCase(Temp.src) && this.dst.equalsIgnoreCase(Temp.dst)){
			 return true;
        }
        
        return false;
    }

    /**
     * Retorna el vertice src de la arista.
     */
    public String getSrc() {
        return(new String(this.src));
    }

    /**
     * Retorna el vertice dst de la arista.
     */
    public String getDst() {
        return(new String(this.dst));
    }

    /**
     * Retorna la representacion en String de la arista.
     */
    @Override
    public String toString() {
        return "("+src + ", " + dst+")";
    }

    /**
     * Retorna el codigo hash para un arco.
     */
    @Override
    public int hashCode() {
		int radix = 128; /*Que es equivalente a 2^7*/
		int hash=0;/*Valor del string src*/
		int hash1=0;/*valor del string dst*/
		
		/*como el string no es mas que un polinomio se evalua mediante el metodo de HORNER*/
		for (int i = this.src.length()-1; i >= 0; i--){
            hash = this.src.charAt(i) + (radix*hash);
      }
      
		/*como el string no es mas que un polinomio se evalua mediante el metodo de HORNER*/
		for (int i = this.dst.length()-1; i >= 0; i--){
            hash1 = this.dst.charAt(i) + (radix*hash1);
      }
		
     	return Math.abs(hash+hash1);
    }

    
    	public static void main(String args[]) {
		Arco Aux, Aux1;
		Object Aux3;
		
			Aux = new Arco();
			Aux1 = new Arco("a","b");
			Aux3= Aux1.clone();
			
			System.out.println();
			System.out.println(Aux.toString());
			
			System.out.println(Aux1.toString());
			
			Aux1=new Arco("A","B");
			System.out.println(Aux1.toString());
			System.out.println(Aux3.toString());
			
			
			
			System.out.println(Aux1.hashCode());
			System.out.println(Aux3.hashCode());
    
		}
    
    
    
    
    
} /*Fin de arco*/

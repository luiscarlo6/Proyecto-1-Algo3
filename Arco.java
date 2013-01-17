/**
 * Clase que almacena la informacion de las aristas en el grafo.
 */
public class Arco {

    private String src = null;
    private String dst = null;

    /**
     * Crea una arista entre los vertices src y dst.
     */
    public Arco(String src, String dst) {
        /* implementar */
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
        /*implementar*/
        return false;
    }

    /**
     * Retorna el vertice src de la arista.
     */
    public String getSrc() {
        /*implementar*/
        return null;
    }

    /**
     * Retorna el vertice dst de la arista.
     */
    public String getDst() {
        /* implementar */
        return null;
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
        /* implementar */
        return 0;
    }

}
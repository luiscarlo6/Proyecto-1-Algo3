
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tiempoInicio = System.currentTimeMillis();
		Nodo A;
		Arco B;
		int max = 50;
		Graph grafo = new DiGraphHash();
		
		for (int i = 0;i!=max;i++){
			A = new Nodo("Nodo_"+1);
			grafo.add(A);
		}
		
		for (int i = 0;i!=max;i++){
			B = new Arco("Nodo_"+1);
			grafo.add(A);
		}
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}

}





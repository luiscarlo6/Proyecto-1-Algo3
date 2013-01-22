
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tiempoInicio = System.currentTimeMillis();
		Nodo A;
		Arco B;
		int max = 100;
		Graph grafo = new DiGraphHash();
		
		for (int i = 0;i!=max;i++){
			A = new Nodo("Nodo_"+i);
//			System.out.println(grafo.add(A));
			grafo.add(A);
		}
		for (int i = 0;i!=max;i++){
			B = new Arco("Nodo_"+i,"Nodo_"+(max-i));
			System.out.println(B.toString()+" "+grafo.add(B));
//			grafo.add(B);
		}
		
		for (int i = 0;i!=max;i++){
			A = new Nodo("Nodo_"+i);
			B = new Arco("Nodo_"+i,"Nodo_"+(max-i));
//			System.out.println(B.toString()+" "+grafo.contains(B));

		}
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}

}





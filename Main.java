
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tiempoInicio = System.currentTimeMillis();
		Nodo A;
		int max = 1000000;
		int colisiones = 0;
		ArrDin arr = new ArrDin();
		boolean arreglo[] = new boolean[max];
		
		for (int i = 0; i!=max-250000 ; i++){
			A = new Nodo("Nodo_"+i);
//			System.out.println("pos "+i+" "+arr.add(A, i)+"tam arr "+arr.tam());		
//			arr.add(A, i);
			System.out.println(A.toString()+" "+A.hashCode()%max);
			if (arreglo[A.hashCode()%max]==true){
				colisiones++;
			}
			arreglo[A.hashCode()%max] = true;
		}
		System.out.println("colisiones "+colisiones);
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}

}

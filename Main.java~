
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tiempoInicio = System.currentTimeMillis();
		Nodo A;
		int max = 2000000;
		int colisiones = 0;
		ArrDin arr = new ArrDin();
		
		for (int i = 0; i!=max ; i++){
			A = new Nodo("Nodo_"+i);
//			System.out.println("pos "+i+" "+arr.add(A, i)+"tam arr "+arr.tam());		
			arr.add(A, i);
			
		}
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}

}

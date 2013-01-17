
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Nodo A;
		int max = 1000000;
		int colisiones = 0;
		ArrDin arr = new ArrDin();
		
		for (int i = 0; i!=max ; i++){
			A = new Nodo("Nodo_"+i);
			System.out.println("pos "+i+" "+arr.add(A, i));		
			
		}

	}

}

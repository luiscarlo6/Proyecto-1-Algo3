
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Nodo A;
		int max = 100000;
		int colisiones = 0;
		boolean arr[] = new boolean[max];
		
		for (int i = 0; i!=max ; i++){
			A = new Nodo("Nodo_"+i);
//			System.out.println(A.hashCode()%max);
			if (arr[A.hashCode()%max]==false){
				arr[A.hashCode()%max] = true;
			}
			else{
				colisiones++;
			}
			
			
		}
		System.out.println("Colisiones " + colisiones);

	}

}

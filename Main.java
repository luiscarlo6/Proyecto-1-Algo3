
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tiempoInicio = System.currentTimeMillis();
		Nodo A;
		int max = 100000;
		int colisiones = 0;
		Lista<Nodo> lis = new MiLista<Nodo>();
		boolean arr[] = new boolean[max];
		for (int i=0;i!=max;i++){
			A=new Nodo("Nodo_"+i);
			System.out.println(i+" "+lis.add(A));
			if (arr[A.hashCode()%max]==true){
				
//				System.out.println("colision en "+A.hashCode()+" "+(A.hashCode()%max)+" "+A.toString());
				colisiones++;
			}
			lis.add(A);
			arr[A.hashCode()%max]=true;
		}

		System.out.println("colisiones "+colisiones);
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}

}

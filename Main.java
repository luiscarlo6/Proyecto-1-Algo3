
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tiempoInicio = System.currentTimeMillis();
		Nodo A;
		int max = 100;
		Lista<Nodo> lis = new MiLista<Nodo>();
		
		for (int i=0;i!=max;i++){
			A = new Nodo("Nodo_"+i);
//			System.out.println(lis.add(A));
			lis.add(A);
		}
		Object arrN[]=lis.toArray();
		for (int i=0;i!=max/2;i++){
			A = new Nodo("Nodo_"+i);
			lis.remove(A);
//			System.out.println(((Nodo)arrN[i]).toString());
		}
		
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
	}

}

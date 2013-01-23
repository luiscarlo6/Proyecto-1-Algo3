public class Main {

        /**
         * @param args
         */
         
         
        public static void main(String[] args) {
                
                DiGraphMatriz G;
                
                G = new DiGraphMatriz ();
                Nodo  t;
                
                
                int i=0;
                
                while (i!=7){
                        
                        //System.out.println("Nodo"+i);
                        Nodo n = new Nodo("Nodo_"+i);
                        G.add(n);
                        i++;
                        
                }
                
                i=0;
                
                while (i!=10){
                        
                        //System.out.println("Nodo"+i);
                        Arco n = new Arco("Nodo_"+i,"Nodo_"+(i+1));
                        //System.out.println(G.add(n));
                        G.add(n);
                        i++;
                        
                }
                
                i=0;
                
                while (i!=10){
                        
                        //System.out.println("Nodo"+i);
                        Arco n = new Arco("Nodo_"+(i+1),"Nodo_"+i);
                        //System.out.println(G.add(n));
                        G.add(n);
                        i++;
                        
                }
                
                
                i=0;
                /*while (i!=10){
                        
                        //new Nodo("Nodo_"+i)));
                        Nodo n = new Nodo("Nodo_"+i*2);
                        System.out.println(G.remove(n));
                        i++;
                        
                }*/
                
                while (i!=10){
                        
                        //System.out.println("Nodo"+i);
                        Arco n = new Arco("Nodo_"+i,"Nodo_"+(i+1));
                        //System.out.println(G.add(n));
                        G.add(n);
                        i++;
                        
                }
                
                i=0;
                while (i!=10){
                        
                        //System.out.println("Nodo"+i);
                        Arco n = new Arco("Nodo_"+i,"Nodo_"+(i+1));
                        //System.out.println(G.add(n));
                        G.remove(n);
                        i++;
                        
                }
                
                i=0;
                
                while (i!=10){
                        
                        //System.out.println("Nodo"+i);
                        Arco n = new Arco("Nodo_"+(i+1),"Nodo_"+i);
                        //System.out.println(G.add(n));
                        G.remove(n);
                        i++;
                        
                }
                
                G.Imprimir1();
                
        }
         
         
        /* 
        public static void main(String[] args) {
                long tiempoInicio = System.currentTimeMillis();
                Nodo A;
                Arco B;
                int max =200;
                Graph grafo = llenar(true,true,max);

                for (int i = 0; i < max; i++) {
                    Nodo n = new Nodo("Nodo_"+i);
//                  System.out.println("contains nodo:"+n.toString()+" "+grafo.contains(n));
//                  grafo.remove(n);
                }
                for (int i = 0; i < max; i += 2) {
                    Nodo n1 = new Nodo("Nodo_"+i);

                    for (int j = 1; j < max; j += 2) {

                    Nodo n2 = new Nodo("Nodo_"+j);
                        Arco a = new Arco(n1.toString(), n2.toString());
//                  System.out.println("contains arco:"+a.toString()+" "+grafo.contains(a));
//                      grafo.remove(a);
                    }
                }
                
                
                Lista<Nodo> listaNodo = grafo.getNodos();
                ListIterator<Nodo> it = ((MiLista<Nodo>) listaNodo).iterator();
                for (int i = 0; i < max; i++){
//                      A = it.next();
//                      System.out.println(A.toString());
                }
                
                Lista<Arco> listaArco = grafo.getArcos();
                ListIterator<Arco> it2 = ((MiLista<Arco>) listaArco).iterator();
                for (int i = 0; i < listaArco.getSize(); i++){
//                      B = it2.next();
//                      System.out.println(B.toString());
                }
                
                Lista<Nodo> listaPred = grafo.getPred(new Nodo("Nodo_1"));
                ListIterator<Nodo> it3 = ((MiLista<Nodo>) listaPred).iterator();
                for (int i = 0; i < listaPred.getSize(); i++){
//                      A = it3.next();
//                      System.out.println(A.toString());
                }
                
                Lista<Nodo> listaSuc = grafo.getSuc(new Nodo("Nodo_2"));
                ListIterator<Nodo> it4 = ((MiLista<Nodo>) listaSuc).iterator();
                for (int i = 0; i < listaSuc.getSize(); i++){
//                      A = it4.next();
//                      System.out.println(A.toString());
                }
                
                Lista<Arco> listaIn = grafo.getIn(new Nodo("Nodo_1"));
                ListIterator<Arco> it5 = ((MiLista<Arco>) listaIn).iterator();
                for (int i = 0; i < listaIn.getSize(); i++){
//                      B = it5.next();
//                      System.out.println(B.toString());
                }
                
                Lista<Arco> listaOut = grafo.getIn(new Nodo("Nodo_5"));
                ListIterator<Arco> it6 = ((MiLista<Arco>) listaOut).iterator();
                for (int i = 0; i < listaOut.getSize(); i++){
//                      B = it6.next();
//                      System.out.println(B.toString());
                }
                
                System.out.println("Arcos: "+grafo.getNumArcos()+" Nodos: "+grafo.getNumNodos());
                long totalTiempo = System.currentTimeMillis() - tiempoInicio;
                System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
        }
        
        
        private static Graph llenar(boolean lista, boolean hacerEq, int maxN) {
                Graph d1 = null;

                if (lista)
                    d1 = new DiGraphHash();
                else
                    d1 = new DiGraphMatriz();

                for (int i = 0; i < maxN; i++) {
                    Nodo n = new Nodo("Nodo_"+i);
                    d1.add(n);
//                  System.out.println("add "+n.toString()+" "+d1.add(n));
                    
                }
                int p=0;
                for (int i = 0; i < maxN; i += 2) {
                    Nodo n1 = new Nodo("Nodo_"+i);

                    for (int j = 1; j < maxN; j += 2) {
                        Nodo n2 = new Nodo("Nodo_"+j);
                        Arco a = new Arco(n1.toString(), n2.toString());
                        p++;
                        boolean b1 = false;
                        boolean b2 = false;

                        if (lista)
                            b2 = d1.add((Arco) a.clone());
                        else if (hacerEq)
                            b2 = d1.add((Arco) a.clone());
                        else
                            if ((i!=2) || (j != 3))
                                b2 = d1.add((Arco) a.clone());
                        
//                                      System.out.printf("Agregando %s %s\n" , a, b2);
                    }
                }
                System.out.println(p);
                return d1;
            }
*/
}
package Ejercicio_1;

class DisjointSet{
	private int[] set;

        //Getter
	public int[] getSet(){
		return set;
	}
        
        //Metodo constructor
	public DisjointSet(int numElements) {		
		set = new int [numElements];
		for(int i = 0; i < set.length; i++){
			set[i] = -1;
		}
	}

	//Unir dos conjuntos
	public void union(int root1, int root2) {
            //Si root2 es la mas pequeña hacerla la nueva raiz
            if(set[root2] < set[root1]){
                    set[root1] = root2;
            }
            else {
                //Cambiar si son iguales las raizes
                if(set[root1] == set[root2]){
                        set[root1]--;
                }
                //Hacer la root1 la nueva raiz
                set[root2] = root1;
            }
	}

	//Metodo para buscar la raiz
	public int find(int x) {
            //Si el arbol es una raiz retorna el index
            if(set[x] < 0){
                    return x;
            }
            int next = x;
            //Ciclo hasta encontrar la raiz
            while(set[next] > 0){
                    next=set[next];
            }
            return next;
	}
	
}

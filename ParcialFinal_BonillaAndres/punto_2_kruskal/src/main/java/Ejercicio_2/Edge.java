package Ejercicio_2;


class Edge implements Comparable<Edge>{
	private int vertex1;
	private int vertex2;
	private int weight;

        //Metodo constructor
	public Edge(int vertex1, int vertex2, int weight){
		this.vertex1=vertex1;
		this.vertex2=vertex2;
		this.weight=weight;
	}

        //Getters y Setters
	public int getVertex1(){
		return vertex1;
	}

	public int getVertex2(){
		return vertex2;
	}

	public int getWeight(){
		return weight;
	}

        //Metodo para comparar el peso de dos aristas
	@Override
	public int compareTo(Edge otherEdge) {
		return this.getWeight() - otherEdge.getWeight();
	}

	@Override
	public String toString() {
		return "Arista ("+getVertex1()+", "+getVertex2()+") Peso="+getWeight();
	}
}
package Ejercicio_2;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	public static void main(String[] args) {
            
            //Lista de aristas
            ArrayList<Edge> graphEdges = new ArrayList<Edge>();		
            graphEdges.add(new Edge(1, 2, 2));
            graphEdges.add(new Edge(1, 3, 3));
            graphEdges.add(new Edge(2, 4, 2));
            graphEdges.add(new Edge(3, 4, 1));
            graphEdges.add(new Edge(4, 5, 2));
            graphEdges.add(new Edge(4, 6, 4));
            graphEdges.add(new Edge(5, 6, 1));
            graphEdges.add(new Edge(5, 7, 2));
            graphEdges.add(new Edge(6, 7, 2));
            graphEdges.add(new Edge(6, 8, 1));
            graphEdges.add(new Edge(7, 8, 3));

            //Cantidad de vertices
            int nodeCount = 8;

            Kruskal graph = new Kruskal();
            graph.kruskalMST(graphEdges, nodeCount);
        }

        //Metodo para encontrar MST
	public void kruskalMST(ArrayList<Edge> graphEdges, int nodeCount){

                //Ordenar las aristas segun el peso
		Collections.sort(graphEdges);
                
                //Lista vacia de aristas para almacenar el MST
		ArrayList<Edge> mstEdges = new ArrayList<Edge>();

                //Instanciar la clase DisjointSet
		DisjointSet nodeSet = new DisjointSet(nodeCount+1);

                //Ciclo para recorrer las aristas
		for(int i=0; i<graphEdges.size() && mstEdges.size()<(nodeCount-1); i++){
			Edge currentEdge = graphEdges.get(i);
                        //Encontrar la raiz de un vertice de una arista
			int root1 = nodeSet.find(currentEdge.getVertex1());
			int root2 = nodeSet.find(currentEdge.getVertex2());
			
                        //Agregar la arista y unir conjuntos si no se genera ciclo
			if(root1 != root2){
				mstEdges.add(currentEdge);
				nodeSet.union(root1, root2);
			}
		}
                
                String outputMessage = "";

		outputMessage+="\nResultado de MST ("+mstEdges.size()+" aristas)\n";
		int mstTotalEdgeWeight = 0;
		for(Edge edge: mstEdges){
			outputMessage+=edge +"\n";
			mstTotalEdgeWeight += edge.getWeight();
		}
		outputMessage+="\nPeso total de todas las aristas en MST = " + mstTotalEdgeWeight;

                System.out.println("a = 1\nb = 2\nc = 3\nd = 4\ne = 5\nf = 6\ng = 7\nh = 8");
		System.out.println(outputMessage);

	}
}

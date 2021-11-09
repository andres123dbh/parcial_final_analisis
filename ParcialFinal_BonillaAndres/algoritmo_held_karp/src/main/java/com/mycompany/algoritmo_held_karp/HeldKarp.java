package com.mycompany.algoritmo_held_karp;

import java.util.HashSet;
import java.util.Set;

public class HeldKarp {
    private int[][] matriz;
    private int numVertices = -1; 
    private HashTable costoMinimo;
    private HashTable padres;
    private LinkedList datos;
    
    //Metodo para usar el algoritmo Held Karp
    public void run(int[][] data, int verticies) {
        matriz = data;
        numVertices = verticies;
        datos = new LinkedList();
        createSets();
        int size = numVertices*numVertices;
        costoMinimo = new HashTable(size);
        padres    = new HashTable(size);

        int result = TSP();
        
        printPath(0);
        
        System.out.println(", Distancia recorrida: " + result);
    }
    
    //Calcular la distancia minima recorrida
    private int TSP(){
        Node curr = datos.top;
        while(curr != null){
            for(int i = 1; i < numVertices; i++) {
                if(curr.dato.contains(i)) {
                    continue;
                }
                int[] temp = loop(curr.dato, Integer.MAX_VALUE, 0, i);
                if(curr.dato.isEmpty()) {
                    temp[0] = matriz[0][i];
                }
                costoMinimo.insert(curr.dato, i, temp[0]);
                padres.insert(curr.dato, i, temp[1]);
            }
            curr = curr.siguiente;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < numVertices; i++) {
            set.add(i);
        }
        int[] temp = loop(set, Integer.MAX_VALUE, -1, 0);
        padres.insert(set, 0, temp[1]);
        return temp[0];
    }
    private int[] loop(Set<Integer> set, int min, int minPos, int val){
        int[] results = new int[2];
        results[0] = min;
        results[1] = minPos;
        //Copiar en setCopy la lista set
        Set<Integer> setCopy = deepCopy(set);
        for(int k : set) {
            int cost = matriz[k][val] + Cost(setCopy, k);
            if(cost < results[0]) {
                results[0] = cost;
                results[1] = k;
            }
        }
        return results;
    }
    private int Cost(Set<Integer> dato, int j) {
        dato.remove(j);
        int cost = costoMinimo.get(dato, j);
        dato.add(j);
        return cost;
    }
    private Set<Integer> deepCopy(Set<Integer> set){
        Set<Integer> result = new HashSet<>();
        for(int i: set){
            result.add(i);
        }
        return result;
    }
    
    //Metodo para imprimir la ruta
    private void printPath(int start) {
        String order = "";
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numVertices; i++) {
            set.add(i);
        }
        while(!set.isEmpty()) {
            //Arreglo para empezar desde 1 y llegar hasta n vertices
            order = (start) + " -> " + order;
            set.remove(start);
            start = padres.get(set,start);
        }
        order = (start) + " -> " + order;// we start from vertex 0
        System.out.print("Shortest path: " + order.substring(0,order.length()-4));
        // -4 to remove the last " -> "
    }
    private void printSets(){
        Node top = datos.top;
        while(top != null){
            if(top.dato.isEmpty()){
                System.out.println("[0]");
            }
            else{
                System.out.println(top.dato);    
            }
            top = top.siguiente;
        }
    }
    
    //Metodo para crear conjuntos
    private void createSets() {
        int result[] = new int[numVertices-1];
        generateCombination(0, 0, result);
    }
    
    //Metodo para generar combinaciones
    private void generateCombination(int start, int end, int result[]) {
        if(end != result.length) {
            Set<Integer> set = new HashSet<>();
            if(end > 0){
                for(int i = 0; i < end; i++) {
                    set.add(result[i]);
                } 
            }
            datos.addOrdered(set);
            for(int i = start; i < result.length; i++) {
                result[end] = i+1;
                generateCombination(i+1, end+1, result);
            }
        }
    }
}

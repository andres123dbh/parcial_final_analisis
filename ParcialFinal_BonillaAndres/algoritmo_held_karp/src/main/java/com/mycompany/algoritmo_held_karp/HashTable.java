package com.mycompany.algoritmo_held_karp;

import java.util.Set;

public class HashTable {
    private class Node {  
        public Set<Integer> dato;
        public int vertice;
        public int costoMinimo;
        public Node siguiente;
        public Node(Set<Integer> data, int vertex, int minCost) {  
            this.dato = data;  
            this.vertice = vertex;
            this.costoMinimo = minCost;
            this.siguiente = null;
        }  
    }
    
    //Metodo constructor
    public HashTable(int size){
        list = new Node[size];
        for(int i = 0; i < list.length;i++){
            list[i] = null;
        }
        totalSize = 0;
    }
    
    //lista de nodos
    private Node[] list;
    
    //Tamaño de la Hash Table
    public int totalSize;
    
    //Metodo para obtener la ubicacion del elemento
    private int hash(int vertex, Set<Integer> data){
        if(data != null){
            return ((23 * vertex + (data.hashCode())) % list.length);
        }
        else{
            return vertex % list.length;
        }
    }
    
    //Metodo para insertar un dato
    public void insert(Set<Integer> input, int vertex, int minCost) {
        Node temp = new Node(input,vertex,minCost);
        int key = hash(vertex,input);
        if(list[key] == null){
            list[key] = temp;
        }
        else{
            Node curr = list[key];
            while(curr.siguiente != null){
                curr = curr.siguiente;
            }
            curr.siguiente = temp;
        }
        totalSize++;
    }
    
    //Metodo para obtener un dato
    public int get(Set<Integer> set, int vertex){
        int key = hash(vertex,set);
        Node curr = list[key];
        if(!set.containsAll(curr.dato) || curr.vertice != vertex){
            while(curr.siguiente != null){
                if(vertex == curr.vertice){
                    if(set.containsAll(curr.dato)){
                        return curr.costoMinimo;
                    }
                }
                curr = curr.siguiente;
            }
        }
        return curr.costoMinimo;
    }

}

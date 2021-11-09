package com.mycompany.algoritmo_held_karp;

import java.util.Set;

public class LinkedList {
    public Node top;
    public int size = 0;
    
    //Metodo constructor 1
    public LinkedList() { 
    top = null;
    }
    
    //Metodo constructor 2
    public LinkedList(Set<Integer> set) { 
        top = new Node(set);
        top.siguiente = null;
    }
    
    //Añadir y ordenar a la lista
    public void addOrdered(Set<Integer> set) { 
        Node newNode = new Node(set);
        if(top == null){
            top = newNode;
            top.siguiente = null;
        }
        else{
            Node curr = top;
            Node prev = curr;
            boolean end = false;
            
            while(curr != null && !end){
                if(prev.dato.size() == set.size() && curr.dato.size() > set.size()){
                    end = true;
                }
                else{
                    prev = curr;
                    curr = curr.siguiente;
                }
            }
            if(end){
                prev.siguiente = newNode;
                newNode.siguiente = curr;
            }
            else{
                if(curr != null){
                    curr.siguiente = newNode; 
                }
                else{
                    prev.siguiente = newNode; 
                }
            }
        }
        size++;
    }
    
    //Revisar si un dato esta en la lista
    public boolean contains(Set<Integer> set){
        boolean result = false;
        if(!isEmpty()){
            Node start = top;
            while(start.siguiente != null){
                if(start.dato.containsAll(set)){
                    return true;
                }
                start = start.siguiente;
            }
        }
        return result;
    }
    
    //Comprobar si la lista simple esta vacia
    public boolean isEmpty(){
        return top == null;
    }
    
    //Eliminar un dato de la lista
    public void remove(Set<Integer> set){
        Node curr = top;
        Node prev = curr;
        while(curr != null & curr.dato != set){
            prev = curr;
            curr = curr.siguiente;
        }
        if(curr.dato == set){
            prev.siguiente = curr.siguiente;
        }
        size--;
    }
}

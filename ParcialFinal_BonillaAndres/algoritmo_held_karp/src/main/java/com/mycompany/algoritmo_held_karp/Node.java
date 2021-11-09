package com.mycompany.algoritmo_held_karp;

import java.util.Set;

public class Node {
    public Node siguiente;
    public Set<Integer> dato;
    public Node(Set<Integer> dato){
    this.dato = dato;
    this.siguiente = null;
   }
}

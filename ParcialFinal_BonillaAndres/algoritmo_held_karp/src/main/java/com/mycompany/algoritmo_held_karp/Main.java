package com.mycompany.algoritmo_held_karp;

public class Main {

    public static void main(String args[]) {
        int numVertices = 3;
        int [][] matriz = new int[numVertices][numVertices]; 
        HeldKarp HeldKarp = new HeldKarp();
        System.out.println("Ejemplo 1 de algoritmo Held Karp");
        matriz[0][0] = 0;
        matriz[0][1] = 1;
        matriz[0][2] = 2;
        matriz[1][0] = 6;
        matriz[1][1] = 0;
        matriz[1][2] = 3;
        matriz[2][0] = 5;
        matriz[2][1] = 4;
        matriz[2][2] = 0;
        HeldKarp.run(matriz, numVertices);
        
        System.out.println("\nEjemplo 2 de algoritmo Held Karp");
        int numVertices2 = 4;
        int [][] matriz2 = new int[numVertices2][numVertices2]; 
        matriz2[0][0] = 0;
        matriz2[0][1] = 2;
        matriz2[0][2] = 9;
        matriz2[0][3] = 10;
        matriz2[1][0] = 1;
        matriz2[1][1] = 0;
        matriz2[1][2] = 6;
        matriz2[1][3] = 4;
        matriz2[2][0] = 15;
        matriz2[2][1] = 7;
        matriz2[2][2] = 0;
        matriz2[2][3] = 8;
        matriz2[3][0] = 6;
        matriz2[3][1] = 3;
        matriz2[3][2] = 12;
        matriz2[3][3] = 0;
        HeldKarp.run(matriz2, numVertices2);
    }
}

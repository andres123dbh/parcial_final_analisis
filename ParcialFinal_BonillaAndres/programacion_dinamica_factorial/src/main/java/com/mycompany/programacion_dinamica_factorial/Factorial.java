package com.mycompany.programacion_dinamica_factorial;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Factorial {

    public static void main(String args[]) {
        
        //Variable para saber el maximo y el factorial a calcular
        int n;
        
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Ingresar un numero para calcular el factorial");
        
        //Recibir el numero maximo del long[] y el cual saber el factorial
        n = sn.nextInt();

        //Para almacenar todos los factoriales hasta n
        long[] factorial = new long[n + 1];
        
        //Llamar metodo factoriales
        factoriales(n,factorial);
        
        System.out.println("Factorial:");
        System.out.printf(n + "! = " + factorial[n]);
    }
    
    //Metodo para calcular y almacenar tosdos los factoriales hasta n
    public static void factoriales(int maximo,long[] factorial) {
        //Almacenar el ultimo factorial que es igual a 1
        factorial[0] = 1;
        
        //Ciclo para recorre el array y asi calcular y almacenar cada factorial hasta n
        for (int i = 1; i <= maximo; i++) {
            factorial[i] = i * factorial[i - 1];
        }
    }
}

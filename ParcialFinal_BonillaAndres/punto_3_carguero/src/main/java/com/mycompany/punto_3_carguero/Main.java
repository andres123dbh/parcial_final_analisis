package com.mycompany.punto_3_carguero;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        
        Scanner sn = new Scanner(System.in);
        
        //Instanciar un ArrayList<Contenedor> para almacenar contenedores antes de guardarlos en el carguero
        ArrayList<Contenedor> contenedores = new ArrayList<>();
        
        //Instanciar diferentes contenedores
        Contenedor c1 = new Contenedor("c1", 100);
        contenedores.add(c1);
        Contenedor c2 = new Contenedor("c2", 155);
        contenedores.add(c2);
        Contenedor c3 = new Contenedor("c3", 50);
        contenedores.add(c3);
        Contenedor c4 = new Contenedor("c4", 112);
        contenedores.add(c4);
        Contenedor c5 = new Contenedor("c5", 70);
        contenedores.add(c5);
        Contenedor c6 = new Contenedor("c6", 80);
        contenedores.add(c6);
        Contenedor c7 = new Contenedor("c7", 60);
        contenedores.add(c7);
        Contenedor c8 = new Contenedor("c8", 118);
        contenedores.add(c8);
        Contenedor c9 = new Contenedor("c9", 110);
        contenedores.add(c9);
        Contenedor c10 = new Contenedor("c10", 55);
        contenedores.add(c10);
        
        //Instanciar la clase ordenamientoQuickSort
        ordenamientoQuickSort ordenar = new ordenamientoQuickSort();

        //Lamamr el metodo ordenarQuickSort
        ordenar.ordenarQuickSort(contenedores);
        
        //Instanciar carguero con capacidad de 700 toneladas
        Carguero carguero = new Carguero(700);
        
        System.out.println("---------------------------------");
        System.out.println("1.Cargar maximixando cantidad de contenedores \n2.Cargar maximixando número de toneladas");
        System.out.println("---------------------------------");

        //Condicional para el switch
        int opcion = Integer.parseInt(sn.nextLine());
        
        switch(opcion){
            case 1:
                System.out.println("Maximizar el número de contenedores cargados.");
                System.out.println("---------------------------------");
                
                //Llamar al metodo maximoContenedores
                carguero.maximoContenedores(contenedores, carguero);
                
                //Llamar al metodo ordenarCarga
                carguero.ordenarCarga();
                
                //Llamar al metodo verInformacion
                carguero.verInformacion();
                break;
            case 2:
                System.out.println("Maximizar el número de toneladas cargadas.");
                System.out.println("---------------------------------");
                
                //Llamar al metodo maximoToneladas
                carguero.maximoToneladas(contenedores, carguero);
                
                //Llamar al metodo ordenarCarga
                carguero.ordenarCarga();
                
                //Llamar al metodo verInformacion
                carguero.verInformacion();
                break;
            default:
                //Digito una opcion no valida
                System.out.println("---------------------------------");
                System.out.println("Esa opción no es valida");
                System.out.println("---------------------------------");
                break;
        }
    }
}

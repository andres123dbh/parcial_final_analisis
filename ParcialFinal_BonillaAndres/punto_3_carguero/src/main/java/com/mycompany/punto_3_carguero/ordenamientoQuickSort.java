package com.mycompany.punto_3_carguero;

import java.util.ArrayList;

public class ordenamientoQuickSort {

    //Metodo principar para el ordenamiento QuickSort
    public void ordenarQuickSort(ArrayList<Contenedor> array){
        array = quickSort1(array);
    }

    //Metodo auxiliar del metodo principal que retorna ArrayList<Contenedor>
    public ArrayList<Contenedor> quickSort1(ArrayList<Contenedor> numeros){
        return quickSort2(numeros,0,numeros.size()-1);
    }

    //Metodo auxiliar del metodo auxilair que retorna ArrayList<Contenedor>
    public ArrayList<Contenedor> quickSort2(ArrayList<Contenedor> numeros, int izquierda, int  derecha){
        //Revisar si la posicion de la izquierda es mayor o igual a de la derecha
        if(izquierda>=derecha){
            return numeros;
        }
        //Asignar derecha e izquierda
        int i = izquierda;
        int d = derecha;
        //Reisar si izquierda y derecha son diferentes
        if(izquierda!=derecha){
            //Asignar el pivote
            int pivote = izquierda;
            //While con el condiional ed que izquierda y derecha sean diferentes diferentes
            while(izquierda != derecha){
                //While con el condicional de que el peso en la pocicion derecha sea mayor o igual al peso del pivote e izquierda sea menor a derecha
                while(numeros.get(derecha).getPeso()>= numeros.get(pivote).getPeso() && izquierda<derecha){
                    derecha--;
                }
                //While con el condicional de que el peso en la pocicion izuierda menor al peso del pivote e izquierda sea menor a derecha
                while(numeros.get(izquierda).getPeso()< numeros.get(pivote).getPeso() && izquierda<derecha){
                    izquierda--;
                }
                //Reisar si izquierda y derecha son diferentes
                if(derecha!=izquierda){
                    //Variable para almacenar temporalmente un contenedor
                    Contenedor temp = numeros.get(derecha);
                    //Cambiar el contenedor de la pocicion de la derecha por el contenedor de la pocicion de la derecha
                    numeros.set(derecha,numeros.get(izquierda));
                    //Cambiar el contenedor de la pocicion de la izquierda por el contenedor de la variable temporal
                    numeros.set(izquierda,temp);
                }
                //Reisar si izquierda y derecha son iguales
                if(izquierda==derecha){
                    //Recursividad
                    quickSort2(numeros, i, izquierda-1);
                    quickSort2(numeros, izquierda+1, d);
                }
            }
        }
        //Retorno de ser caso contrario
        else{
            return numeros;
        }
        return numeros;
    }

}

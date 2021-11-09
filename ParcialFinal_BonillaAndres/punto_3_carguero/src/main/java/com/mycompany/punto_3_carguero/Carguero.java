package com.mycompany.punto_3_carguero;
import java.util.ArrayList;

public class Carguero{
    private int capacidadCarga;
    private ArrayList<Contenedor> contenedores = new ArrayList<>();

    //Metodo constructor
    public Carguero(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;  
    }

    //Getters y Setters
    public int getCapacidadCarga() {
        return this.capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public ArrayList<Contenedor> getContenedores() {
        return this.contenedores;
    }

    public void setContenedores(ArrayList<Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    //Metodo para saber el peso actual del carguero
    public int pesoActual(){
        //Instanciar variable peso
        int peso = 0;
        //Revisar si el ArrayList<Contenedor> esta vacio
        if(this.contenedores.size() != 0){
            //Ciclo for que recorre el ArrayList<Contenedor> 
            for(Contenedor contenedor : this.contenedores){
                peso += contenedor.getPeso();
            }
        }
        //Retorno del volor de la variale peso
        return peso;
    }

    //Metodo para agregar un contenedor al carguero
    public void agregarContenedor(Contenedor contenedor){
        //Agregar contenedor al ArrayList<Contenedor> 
        this.contenedores.add(contenedor);
    }

    //Metodo para ordenar de menor a mayor la carga del carguero
    public void ordenarCarga(){
        //Instanciar la clase ordenamientoQuickSort
        ordenamientoQuickSort ordenar = new ordenamientoQuickSort();
        //Llamar el metodo ordenarQuickSort
        ordenar.ordenarQuickSort(contenedores);
    }

    //Metodo para ver la informacion del carguero y su carga
    public void verInformacion(){
        System.out.println("---------------------------------");
        System.out.println("Capacidad de carga: " + this.capacidadCarga);
        System.out.println("Cantidad de contenedores: " + this.contenedores.size());
        System.out.println("Peso actual del buque: " + this.pesoActual());
        System.out.println("---------------------------------");
        System.out.println("Carga:");
        System.out.println("---------------------------------");
        for(Contenedor contenedor : this.contenedores){
            System.out.println("Conteneedor: " + contenedor.getNombre());
            System.out.println("Peso de Contenedor: " + contenedor.getPeso());
            System.out.println("---------------------------------");
        }
    }

    //Metodo para agregar carga al carguero maximizando la cantidad de contenedores
    public void maximoContenedores(ArrayList<Contenedor> contenedores,Carguero buque){
        //Ciclo for que va de 0 a la cantidad de contenedores - 1
        for (int i = 0; i < contenedores.size(); i++) {
            //Condicional para revisar que el peso del contenedor + el peso actual del buque sea menor o igual a la capacidad de carga
            if(contenedores.get(i).getPeso() + buque.pesoActual() <= buque.getCapacidadCarga()){
                buque.agregarContenedor(contenedores.get(i));
            }
	}
    }

    //metodo para agregar carga al carguero maximizando el numero de toneladas
    public void maximoToneladas(ArrayList<Contenedor> contenedores,Carguero buque){
        //Ciclo for que va de la cantidad de contenedores - 1 hasta 0
        for (int i = contenedores.size() - 1; i >= 0; i--) {
            //Condicional para revisar que el peso del contenedor + el peso actual del buque sea menor o igual a la capacidad de carga
            if(contenedores.get(i).getPeso() + buque.pesoActual() <= buque.getCapacidadCarga()){
                buque.agregarContenedor(contenedores.get(i));
            }
	}
    }
}

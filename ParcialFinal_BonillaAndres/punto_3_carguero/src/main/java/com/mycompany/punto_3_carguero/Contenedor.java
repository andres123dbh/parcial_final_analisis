package com.mycompany.punto_3_carguero;

public class Contenedor {
    private String nombre;
    private int peso;

    //Metodo constructor
    public Contenedor(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    //Getters y Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}

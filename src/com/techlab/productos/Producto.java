package com.techlab.productos;
import java.util.Scanner;

public class Producto {
    //Atributos


    static  int IdContador = 0;
    int id;
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;

        id = IdContador++;


    }

}

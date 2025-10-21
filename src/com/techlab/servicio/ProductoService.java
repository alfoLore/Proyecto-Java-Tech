package com.techlab.servicio;

import com.techlab.productos.Producto;

import java.util.List;
import java.util.Scanner;

public class ProductoService {
    public void agregarProducto(Scanner sc, List<Producto> productos){
        String nombre;
        double precio;
        int stock;

        System.out.println("Agregar  Producto\n");


        System.out.print(" Nombre : \n");
        nombre = sc.nextLine();
        System.out.print(" Precio : \n");
        precio = sc.nextDouble();
        System.out.print(" stock : \n");
        stock = sc.nextInt();

        System.out.println("Datos del producto : \n");
        productos.add(new Producto(nombre, precio, stock));
        System.out.println("Nombre: " + nombre );
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);

        System.out.println("Productos agregados con exito\n");

    }
}

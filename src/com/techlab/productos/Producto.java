package com.techlab.productos;

public abstract class Producto {
    private static int contador = 1;
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.id = contador++;
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if(precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
        this.precio = precio;
    }
    public int getStock() { return stock; }
    public void setStock(int stock) {
        if(stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.stock = stock;
    }

    public abstract String detalles();

    @Override
    public String toString() {
        return String.format("ID: %d | %s | $%.2f | Stock: %d", id, nombre, precio, stock);
    }
}

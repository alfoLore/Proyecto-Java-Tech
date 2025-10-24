package com.techlab.main;

import java.util.ArrayList;
import com.techlab.productos.Producto;

public class ProductoService {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) { productos.add(p); }
    public ArrayList<Producto> getProductos() { return productos; }

    public Producto buscarPorId(int id) {
        for(Producto p : productos) if(p.getId() == id) return p;
        return null;
    }

    public Producto buscarPorNombre(String nombre) {
        for(Producto p : productos) if(p.getNombre().equalsIgnoreCase(nombre)) return p;
        return null;
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public void listarProductos() {
        for(Producto p : productos) System.out.println(p.detalles());
    }
}

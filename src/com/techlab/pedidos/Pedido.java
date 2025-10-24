package com.techlab.pedidos;

import java.util.ArrayList;
import com.techlab.productos.Producto;
import com.techlab.excepciones.StockInsuficienteException;

public class Pedido {
    private static int contador = 1;
    private int id;
    private ArrayList<LineaPedido> lineas = new ArrayList<>();

    public Pedido() { this.id = contador++; }

    public int getId() { return id; }
    public ArrayList<LineaPedido> getLineas() { return lineas; }

    public void agregarProducto(Producto producto, int cantidad) throws StockInsuficienteException {
        if(cantidad > producto.getStock()) {
            throw new StockInsuficienteException("Stock insuficiente para: " + producto.getNombre());
        }
        producto.setStock(producto.getStock() - cantidad);
        lineas.add(new LineaPedido(producto, cantidad));
    }

    public double calcularTotal() {
        double total = 0;
        for(LineaPedido lp : lineas) total += lp.getSubtotal();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido ID: " + id + "\n");
        for(LineaPedido lp : lineas) {
            sb.append(lp.getProducto().getNombre())
                    .append(" x")
                    .append(lp.getCantidad())
                    .append(" -> $")
                    .append(lp.getSubtotal())
                    .append("\n");
        }
        sb.append("Total: $").append(calcularTotal()).append("\n");
        return sb.toString();
    }
}

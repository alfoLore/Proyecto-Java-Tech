package com.techlab.main;

import java.util.Scanner;
import java.time.LocalDate;
import com.techlab.productos.*;
import com.techlab.pedidos.Pedido;
import com.techlab.excepciones.StockInsuficienteException;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ProductoService productoService = new ProductoService();
    private static PedidoService pedidoService = new PedidoService();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            try { opcion = Integer.parseInt(sc.nextLine()); }
            catch(Exception e) { System.out.println("Ingrese un número válido."); continue; }

            switch(opcion) {
                case 1: agregarProducto(); break;
                case 2: productoService.listarProductos(); break;
                case 3: buscarActualizarProducto(); break;
                case 4: eliminarProducto(); break;
                case 5: crearPedido(); break;
                case 6: pedidoService.listarPedidos(); break;
                case 7: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida."); break;
            }
        } while(opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Listar Productos");
        System.out.println("3. Buscar/Actualizar Producto");
        System.out.println("4. Eliminar Producto");
        System.out.println("5. Crear Pedido");
        System.out.println("6. Listar Pedidos");
        System.out.println("7. Salir");
        System.out.print("Seleccione opción: ");
    }

    private static void agregarProducto() {
        System.out.print("Tipo de producto (1-Bebida, 2-Comida): ");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Precio: "); double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Stock: "); int stock = Integer.parseInt(sc.nextLine());

        Producto p = null;
        try {
            switch(tipo) {
                case 1:
                    System.out.print("Litros: "); double litros = Double.parseDouble(sc.nextLine());
                    p = new Bebida(nombre, precio, stock, litros);
                    break;
                case 2:
                    System.out.print("Fecha de vencimiento (YYYY-MM-DD): "); LocalDate fecha = LocalDate.parse(sc.nextLine());
                    p = new Comida(nombre, precio, stock, fecha);
                    break;
                default: System.out.println("Tipo inválido."); return;
            }
            productoService.agregarProducto(p);
            System.out.println("Producto agregado con éxito.");
        } catch(Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    private static void buscarActualizarProducto() {
        System.out.print("Ingrese ID del producto: "); int id = Integer.parseInt(sc.nextLine());
        Producto p = productoService.buscarPorId(id);
        if(p == null) { System.out.println("Producto no encontrado."); return; }
        System.out.println("Producto encontrado: " + p.detalles());

        System.out.print("Actualizar precio? (S/N): ");
        if(sc.nextLine().equalsIgnoreCase("S")) {
            System.out.print("Nuevo precio: "); p.setPrecio(Double.parseDouble(sc.nextLine()));
        }

        System.out.print("Actualizar stock? (S/N): ");
        if(sc.nextLine().equalsIgnoreCase("S")) {
            System.out.print("Nuevo stock: "); p.setStock(Integer.parseInt(sc.nextLine()));
        }
        System.out.println("Producto actualizado.");
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese ID del producto a eliminar: "); int id = Integer.parseInt(sc.nextLine());
        productoService.eliminarProducto(id);
        System.out.println("Producto eliminado si existía.");
    }

    private static void crearPedido() {
        Pedido pedido = new Pedido();
        while(true) {
            System.out.print("Ingrese ID de producto a agregar (0 para terminar): ");
            int id = Integer.parseInt(sc.nextLine());
            if(id == 0) break;
            Producto p = productoService.buscarPorId(id);
            if(p == null) { System.out.println("Producto no encontrado."); continue; }

            System.out.print("Cantidad: "); int cantidad = Integer.parseInt(sc.nextLine());
            try { pedido.agregarProducto(p, cantidad); }
            catch(StockInsuficienteException e) { System.out.println(e.getMessage()); }
        }
        pedidoService.agregarPedido(pedido);
        System.out.println("Pedido creado. Total: $" + pedido.calcularTotal());
    }
}

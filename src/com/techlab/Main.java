package com.techlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.techlab.excepciones.SoloNumerosException;
import com.techlab.excepciones.PedidoInvalidoException;
import com.techlab.excepciones.NumInvalException;
import com.techlab.excepciones.ProductoNoEncontradoException;
import com.techlab.productos.Producto;
import com.techlab.servicio.ProductoService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        List<Producto> productos = new ArrayList<Producto>();
        ProductoService prodService = new ProductoService();
        do {
            try {
                System.out.println("\n========= MENÚ =========");
                System.out.println("1) Agregar un producto");
                System.out.println("2) Listar productos");
                System.out.println("3) Buscar un producto");
                System.out.println("4) Actualizar un producto");
                System.out.println("5) Eliminar un producto");
                System.out.println("6) Crear un pedido");
                System.out.println("7) Listar pedidos");
                System.out.println("8) Salir");
                System.out.println("========================");
                System.out.print("Elija una opción: ");

                if (!sc.hasNextInt()) {
                    throw new SoloNumerosException("Debe ingresar solo números.");
                }

                opcion = sc.nextInt();
                sc.nextLine(); // limpiar el salto de línea

                switch (opcion) {
                    case 1 -> System.out.println("→ Agregando producto...");
                    case 2 -> System.out.println("→ Listando productos...");
                    case 3 -> System.out.println("→ Buscando producto...");
                    case 4 -> System.out.println("→ Actualizando producto...");
                    case 5 -> System.out.println("→ Eliminando producto...");
                    case 6 -> System.out.println("→ Creando pedido...");
                    case 7 -> System.out.println("→ Listando pedidos...");
                    case 8 -> System.out.println("→ Saliendo del sistema... ¡Hasta luego!");
                    default -> System.out.println("⚠️ Opción no válida. Intente de nuevo.");
                }

            } catch (SoloNumerosException e) {
                System.out.println("❌ Error: " + e.getMessage());
                sc.nextLine(); // limpiar entrada inválidsc.nextLine();
            } catch (ProductoNoEncontradoException e) {
                System.out.println("❌ Error: " + e.getMessage());
                sc.nextLine();
            } catch (PedidoInvalidoException e) {
                System.out.println("❌ Error: " + e.getMessage());
                sc.nextLine();
            } catch (NumInvalException e) {
                System.out.println("❌ Error: " + e.getMessage());
                sc.nextLine();
            }

        } while (opcion != 8);

        sc.close();
    }
}

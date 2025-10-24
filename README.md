Proyecto Java Tech - Sistema de Gestión de Productos y Pedidos
Descripción

Este proyecto es un sistema de gestión de productos y pedidos desarrollado en Java, utilizando Programación Orientada a Objetos, herencia, polimorfismo y manejo de excepciones.

Permite:

Ingresar y almacenar productos (Bebidas y Comidas).

Listar, buscar, actualizar y eliminar productos.

Crear pedidos, verificar stock y calcular el total.

Manejo de errores y validaciones (por ejemplo, stock insuficiente).

Estructura del Proyecto

El proyecto está organizado en paquetes:

com.techlab.productos  --> Clases Producto, Bebida, Comida
com.techlab.pedidos    --> Clases Pedido, LineaPedido
com.techlab.excepciones--> Excepciones personalizadas (StockInsuficienteException)
com.techlab.main       --> Clase Main y servicios (ProductoService, PedidoService)

Tecnologías

Java 8+

IntelliJ IDEA (o cualquier IDE compatible con Java)

Git y GitHub para control de versiones

Instrucciones de uso

Clonar el repositorio:

git clone https://github.com/alfoLore/Proyecto-Java-Tech.git


Abrir el proyecto en IntelliJ IDEA.

Ejecutar la clase Main.java

Menú interactivo disponible:

1. Agregar Producto
2. Listar Productos
3. Buscar/Actualizar Producto
4. Eliminar Producto
5. Crear Pedido
6. Listar Pedidos
7. Salir


Seguir las instrucciones en consola para agregar productos, crear pedidos y actualizar stock.

Características destacadas

Polimorfismo y Herencia:

Producto es la clase base, Bebida y Comida son subclases que agregan atributos específicos.

Excepciones personalizadas:

StockInsuficienteException para manejar casos donde no hay stock suficiente.

Validaciones de datos:

Evita ingresar precios negativos o stock inválido.

Rastreo de productos y pedidos:

Cada producto y pedido tiene un ID único autogenerado.

Ejemplo de flujo

Agregar una bebida: "Café Premium", precio 150.0, stock 20, 1.5 litros.

Agregar una comida: "Galletas", precio 50.0, stock 10, fecha vencimiento 2025-12-31.

Crear un pedido con 2 unidades de Café y 1 unidad de Galletas.

El sistema calcula automáticamente el total y descuenta stock.

Autor Lorena Febbraro

Nombre: Lorena Febbraro

GitHub: https://github.com/alfoLore/Proyecto-Java-Tech.git

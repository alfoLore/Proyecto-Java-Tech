package com.techlab.main;

import java.util.ArrayList;
import com.techlab.pedidos.Pedido;

public class PedidoService {
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido p) { pedidos.add(p); }
    public ArrayList<Pedido> getPedidos() { return pedidos; }

    public void listarPedidos() {
        for(Pedido p : pedidos) System.out.println(p);
    }
}

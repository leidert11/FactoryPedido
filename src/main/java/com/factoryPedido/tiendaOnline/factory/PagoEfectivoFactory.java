package com.factoryPedido.tiendaOnline.factory;


public class PagoEfectivoFactory implements PagoFactory {
    // Método crearPago, que implementa el método de la interfaz PagoFactory
    public Pago crearPago(String tipo) {
        // Si el tipo es efectivo, devuelve un objeto de tipo PagoEfectivo
        if (tipo.equals("efectivo")) {
            return new PagoEfectivo(0);
        }
        // Si no, devuelve null
        else {
            return null;
        }
    }
}

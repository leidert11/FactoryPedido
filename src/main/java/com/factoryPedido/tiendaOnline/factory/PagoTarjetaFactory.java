
package com.factoryPedido.tiendaOnline.factory;


public class PagoTarjetaFactory implements PagoFactory {
    // Método crearPago, que implementa el método de la interfaz PagoFactory
    public Pago crearPago(String tipo) {
        // Si el tipo es tarjeta, devuelve un objeto de tipo PagoTarjeta
        if (tipo.equals("tarjeta")) {
            return new PagoTarjeta("", "", null);
        }
        // Si no, devuelve null
        else {
            return null;
        }
    }
}

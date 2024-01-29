
package com.factoryPedido.tiendaOnline.factory;

public interface PagoFactory {
    // Método crearPago, que recibe un parámetro de tipo String que indica el tipo de pago que se quiere crear y devuelve un objeto de tipo Pago
    public Pago crearPago(String tipo);
}

package com.factoryPedido.tiendaOnline.factory;

public class PagoEfectivo implements Pago {
    private int numeroFactura;

    // Constructor con parámetros
    public PagoEfectivo(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    // Getter y setter
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String toString() {
        return "PagoEfectivo [numeroFactura=" + numeroFactura + "]";
    }

    // Método realizarPago, que implementa el método de la interfaz Pago
    @Override
    public void pagar() {
        // Lógica específica para el pago en efectivo
        System.out.println("Realizando pago en efectivo para la factura #" + numeroFactura);

        // Simular la impresión de la factura
        imprimirFactura();

        // Registrar el pago en la base de datos
        registrarPagoEnBaseDeDatos();

        // Actualizar el estado de la factura a "Pagado"
        actualizarEstadoFactura();

        System.out.println("Pago en efectivo realizado con éxito.");
    }

    // Método para simular la impresión de la factura
    private void imprimirFactura() {
        System.out.println("Imprimiendo factura para la factura #" + numeroFactura);
        // Lógica de impresión de factura
    }

    // Método para simular el registro del pago en la base de datos
    private void registrarPagoEnBaseDeDatos() {
        System.out.println("Registrando pago en la base de datos para la factura #" + numeroFactura);
        // Lógica de registro en la base de datos
        // Podrías utilizar tu clase DAO correspondiente para realizar la operación de registro
    }

    // Método para simular la actualización del estado de la factura a "Pagado"
    private void actualizarEstadoFactura() {
        System.out.println("Actualizando estado de la factura a 'Pagado' para la factura #" + numeroFactura);
        // Lógica de actualización del estado de la factura
        // Podrías utilizar tu clase DAO correspondiente para realizar la operación de actualización
    }
}

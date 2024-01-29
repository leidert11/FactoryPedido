
package com.factoryPedido.tiendaOnline.factory;

import java.sql.Date;


public class PagoTarjeta implements Pago {
    // Atributos específicos de la forma de pago con tarjeta
    private String numeroTarjeta;
    private String codigoSeguridad;
    private Date fechaVencimiento;

    // Constructor con parámetros
    public PagoTarjeta(String numeroTarjeta, String codigoSeguridad, Date fechaVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters y setters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    // Método toString
    public String toString() {
        return "PagoTarjeta [numeroTarjeta=" + numeroTarjeta + ", codigoSeguridad=" + codigoSeguridad + ", fechaVencimiento=" + fechaVencimiento + "]";
    }

    // Método pagar, que implementa el método de la interfaz Pago
    public void pagar() {
        // Implementa la lógica para realizar el pago con tarjeta
        // Por ejemplo, validar la tarjeta, procesar el pago, cambiar el estado, etc.
    }
}

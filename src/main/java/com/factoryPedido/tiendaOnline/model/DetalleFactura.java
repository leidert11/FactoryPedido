/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factoryPedido.tiendaOnline.model;

/**
 *
 * @author Usuario
 */
public class DetalleFactura {
    private int id;
    private int cantidad;
    private double subtotal;

    public DetalleFactura(int id, int cantidad, double subtotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura :" + "id=" + id + "\n" + 
        ", cantidad=" + cantidad + "\n" + 
        ", subtotal=" + subtotal ;
    }
    
    
}

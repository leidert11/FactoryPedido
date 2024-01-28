/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factoryPedido.tiendaOnline.model;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Factura {
    
    private int id;
    private int numero;
    private Date fecha;
    private double iva;
    private double total ;

    public Factura(int id, int numero, Date fecha, double iva, double total) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura :" + "id=" + id + "\n" +
            "numero=" + numero + "\n" + 
            "fecha=" + fecha + "\n" + 
            "iva=" + iva + "\n" + 
            "total=" + total ;
    }
    
    
}

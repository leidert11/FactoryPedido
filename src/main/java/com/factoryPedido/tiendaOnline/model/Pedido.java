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
public class Pedido {
    
    private int id;
    private Date fecha;
    private int total;
    private String estado;

    public Pedido(int id, Date fecha, int total, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido " + "id=" + id + "\n" +  
            "fecha=" + fecha + "\n" + 
            "total=" + total + "\n" + 
            "estado=" + estado ;
    }


}

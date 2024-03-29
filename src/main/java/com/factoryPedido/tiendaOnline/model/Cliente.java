/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.factoryPedido.tiendaOnline.model;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
        private int id;
        private String nombre;
        private String email;
        private String direccion;
    
        // Constructor por defecto, sin parámetros
        public Cliente() {
            id = 0;
            nombre = "";
            email = "";
            direccion = "";
        }
    
        // Constructor con parámetros
        public Cliente(int id, String nombre, String email, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
            this.direccion = direccion;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente :" + "id=" + id  + "\n" + 
                "nombre=" + nombre  + "\n" +
                "email=" + email  + "\n" + 
                "direccion=" + direccion;
    }
    
    
}

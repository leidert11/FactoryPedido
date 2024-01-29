package com.factoryPedido.tiendaOnline.model.DAO.Operaciones;

import com.factoryPedido.tiendaOnline.model.Cliente;
// import com.factoryPedido.tiendaOnline.model.DAO.Conexion;
import com.factoryPedido.tiendaOnline.model.DAO.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements  Dao<Cliente> {
    private Connection connection;

    @Override
    public void insertar(Cliente obj) {
        // Hacer un casting al tipo Cliente
        Cliente cliente = (Cliente) obj;
        try {
            PreparedStatement stm = connection.prepareStatement("insert into clientes (id, nombre, email, direccion) values (?, ?, ?, ?)");
            stm.setInt(1, cliente.getId());
            stm.setString(2, cliente.getNombre());
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getDireccion());
            int resultado = stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public void actualizar(Cliente obj) {
        // Hacer un casting al tipo Cliente
        Cliente cliente = (Cliente) obj;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("update clientes set nombre = ?, email = ?, direccion = ? where id = ?");
            stm.setString(1, cliente.getNombre());
            stm.setString(2, cliente.getEmail());
            stm.setString(3, cliente.getDireccion());
            stm.setInt(4, cliente.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
    
    public void eliminar(Cliente obj){
        // Hacer un casting al tipo Cliente
        Cliente cliente = (Cliente) obj;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("delete from clientes where id = ?");
            stm.setInt(1, cliente.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
    
    @Override
    public Cliente buscar(Object id) {
        Cliente cliente = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement("select * from clientes where id = ?");
            // Hacer un casting al tipo int
            stm.setInt(1, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el cliente: " + e.getMessage());
        }
        return cliente;
    }
    
}



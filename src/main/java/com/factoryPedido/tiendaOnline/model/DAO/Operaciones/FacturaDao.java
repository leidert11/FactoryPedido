package com.factoryPedido.tiendaOnline.model.DAO.Operaciones;

import com.factoryPedido.tiendaOnline.model.Factura;
import com.factoryPedido.tiendaOnline.model.DAO.Dao;
import com.factoryPedido.tiendaOnline.model.DAO.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDao implements Dao<Factura> {
    private Connection connection;

    @Override
    public void insertar(Factura obj) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO facturas (id, numero, fecha, iva, total) VALUES (?, ?, ?, ?, ?)");
            stm.setInt(1, obj.getId());
            stm.setInt(2, obj.getNumero());
            stm.setDate(3, new java.sql.Date(obj.getFecha().getTime()));
            stm.setDouble(4, obj.getIva());
            stm.setDouble(5, obj.getTotal());
            int resultado = stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la factura: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public void actualizar(Factura obj) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("UPDATE facturas SET numero = ?, fecha = ?, iva = ?, total = ? WHERE id = ?");
            stm.setInt(1, obj.getNumero());
            stm.setDate(2, new java.sql.Date(obj.getFecha().getTime()));
            stm.setDouble(3, obj.getIva());
            stm.setDouble(4, obj.getTotal());
            stm.setInt(5, obj.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la factura: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public void eliminar(Factura obj) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("DELETE FROM facturas WHERE id = ?");
            stm.setInt(1, obj.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la factura: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public Factura buscar(Object id) {
        Factura factura = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement("SELECT * FROM facturas WHERE id = ?");
            stm.setInt(1, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                factura = new Factura();
                factura.setId(rs.getInt("id"));
                factura.setNumero(rs.getInt("numero"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setIva(rs.getDouble("iva"));
                factura.setTotal(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la factura: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
        return factura;
    }

    private void cerrarConexiones() {
        Conexion.getInstance().cerrarConexiones(connection);
    }
    
    private Connection obtenerConexion() {
        return Conexion.getInstance().getConnection();
    }

    public List<Factura> obtenerTodasLasFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            connection = obtenerConexion();
            stm = connection.prepareStatement("SELECT * FROM facturas");
            rs = stm.executeQuery();

            while (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id"));
                factura.setNumero(rs.getInt("numero"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setIva(rs.getDouble("iva"));
                factura.setTotal(rs.getDouble("total"));

                listaFacturas.add(factura);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todas las facturas: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }

        return listaFacturas;
    }
}

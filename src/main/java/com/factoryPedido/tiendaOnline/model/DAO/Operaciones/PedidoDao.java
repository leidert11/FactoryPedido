package com.factoryPedido.tiendaOnline.model.DAO.Operaciones;

import com.factoryPedido.tiendaOnline.model.Pedido;
import com.factoryPedido.tiendaOnline.model.DAO.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

public class PedidoDao implements Dao<Pedido> {
    private Connection connection;

    @Override
    public void insertar(Pedido obj) {
        Pedido pedido = (Pedido) obj;
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO pedidos (id, fecha, total, estado) VALUES (?, ?, ?, ?)");
            stm.setInt(1, pedido.getId());
            stm.setDate(2, new java.sql.Date(pedido.getFecha().getTime()));
            stm.setInt(3, pedido.getTotal());
            stm.setString(4, pedido.getEstado());
            int resultado = stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public void actualizar(Pedido obj) {
        Pedido pedido = (Pedido) obj;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("UPDATE pedidos SET fecha = ?, total = ?, estado = ? WHERE id = ?");
            stm.setDate(1, new java.sql.Date(pedido.getFecha().getTime()));
            stm.setInt(2, pedido.getTotal());
            stm.setString(3, pedido.getEstado());
            stm.setInt(4, pedido.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public void eliminar(Pedido obj) {
        Pedido pedido = (Pedido) obj;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("DELETE FROM pedidos WHERE id = ?");
            stm.setInt(1, pedido.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public Pedido buscar(Object id) {
        Pedido pedido = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement("SELECT * FROM pedidos WHERE id = ?");
            stm.setInt(1, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setFecha(rs.getDate("fecha"));
                pedido.setTotal(rs.getInt("total"));
                pedido.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
        return pedido;
    }

    private void cerrarConexiones() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

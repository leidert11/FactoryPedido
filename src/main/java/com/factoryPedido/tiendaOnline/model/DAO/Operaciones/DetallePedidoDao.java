package com.factoryPedido.tiendaOnline.model.DAO.Operaciones;

import com.factoryPedido.tiendaOnline.model.DetallePedido;
import com.factoryPedido.tiendaOnline.model.DAO.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DetallePedidoDao implements Dao<DetallePedido> {
    private Connection connection;

    @Override
    public void insertar(DetallePedido obj) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO detalle_pedido (id, cantidad, subtotal) VALUES (?, ?, ?)");
            stm.setInt(1, obj.getId());
            stm.setInt(2, obj.getCantidad());
            stm.setDouble(3, obj.getSubtotal());
            int resultado = stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el detalle del pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public void actualizar(DetallePedido obj) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("UPDATE detalle_pedido SET cantidad = ?, subtotal = ? WHERE id = ?");
            stm.setInt(1, obj.getCantidad());
            stm.setDouble(2, obj.getSubtotal());
            stm.setInt(3, obj.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el detalle del pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public void eliminar(DetallePedido obj) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("DELETE FROM detalle_pedido WHERE id = ?");
            stm.setInt(1, obj.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el detalle del pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public DetallePedido buscar(Object id) {
        DetallePedido detallePedido = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement("SELECT * FROM detalle_pedido WHERE id = ?");
            stm.setInt(1, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                detallePedido = new DetallePedido();
                detallePedido.setId(rs.getInt("id"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedido.setSubtotal(rs.getDouble("subtotal"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el detalle del pedido: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
        return detallePedido;
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

package com.factoryPedido.tiendaOnline.model.DAO.Operaciones;

import com.factoryPedido.tiendaOnline.model.Producto;
import com.factoryPedido.tiendaOnline.model.DAO.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

public class ProductoDao implements  Dao<Producto>  {
    private Connection connection;

    public void insertar(Producto obj)  {
        Producto producto = (Producto) obj;
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO productos (id, nombre, precio, stock) VALUES (?, ?, ?, ?)");
            stm.setInt(1, producto.getId());
            stm.setString(2, producto.getNombre());
            stm.setDouble(3, producto.getPrecio());
            stm.setInt(4, producto.getStock());
            int resultado = stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    public void actualizar(Producto obj)  {
        Producto producto = (Producto) obj;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ?");
            stm.setString(1, producto.getNombre());
            stm.setDouble(2, producto.getPrecio());
            stm.setInt(3, producto.getStock());
            stm.setInt(4, producto.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    public void eliminar(Producto obj)  {
        Producto producto = (Producto) obj;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("DELETE FROM productos WHERE id = ?");
            stm.setInt(1, producto.getId());
            int resultado = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
    }

    @Override
    public Producto buscar(Object id) {
        Producto producto = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement("select * from productos where id = ?");
            // Hacer un casting al tipo int
            stm.setInt(1, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el producto: " + e.getMessage());
        } 
        return producto;
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

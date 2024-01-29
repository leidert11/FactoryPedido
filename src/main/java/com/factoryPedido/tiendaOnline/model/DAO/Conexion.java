package com.factoryPedido.tiendaOnline.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instance = null;
    private Connection connection = null;

    private Conexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/factoryPedido";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    // Método para cerrar conexiones
    public void cerrarConexiones(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public Connection obtenerConexion() throws SQLException {
        return Conexion.getInstance().getConnection();
    }
}

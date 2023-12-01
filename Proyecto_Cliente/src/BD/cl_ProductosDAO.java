/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto_cliente.Modulo_Productos_Ventas.clProductos;

public class cl_ProductosDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_proyecto_cl";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "";

    private final String INSERT_PRODUCTO_SQL = "INSERT INTO tbl_productos (Nombre, precio, cantidad, identificacion) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_PRODUCTOS = "SELECT * FROM tbl_productos";
    private final String UPDATE_PRODUCTO_SQL = "UPDATE tbl_productos SET Nombre = ?, precio = ?, cantidad = ? WHERE identificacion = ?";
    private final String DELETE_PRODUCTO_SQL = "DELETE FROM tbl_productos WHERE identificacion = ?";
    private final String SELECT_PRODUCTO_BY_ID = "SELECT * FROM tbl_productos WHERE identificacion = ?";

    public List<clProductos> getAllProductos() {
        List<clProductos> productos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTOS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clProductos producto = new clProductos(
                        resultSet.getString("Nombre"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("cantidad"),
                        resultSet.getString("identificacion")
                );
                producto.setId(resultSet.getInt("id"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public clProductos getProductoById(int id) {
        clProductos producto = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                producto = new clProductos(
                        resultSet.getString("Nombre"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("cantidad"),
                        resultSet.getString("identificacion")
                );
                producto.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    public void insertProducto(clProductos producto) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTO_SQL)) {

            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setDouble(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setString(4, producto.getIdentificacion());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProducto(clProductos producto) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTO_SQL)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setDouble(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setString(4, producto.getIdentificacion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteProducto(String identificacion) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM tbl_productos WHERE identificacion ='" + identificacion + "'");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



public void actualizarCantidadEnStock(String identificacion, int cantidadVendida) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tbl_productos SET cantidad = cantidad - ? WHERE identificacion = ?")) {
        preparedStatement.setInt(1, cantidadVendida);
        preparedStatement.setString(2, identificacion);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

/**
 *
 * @author andro
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_cliente.Modulo_Productos_Ventas.clVenta;

public class cl_VentasDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_proyecto_cl";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "";

    private final String INSERT_VENTA_SQL = "INSERT INTO tbl_ventas (idProducto, cantidad, precioUnitario, fechaVenta, direccion_venta, cliente) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SELECT_ALL_VENTAS = "SELECT * FROM tbl_ventas";
    // Otros SQL statements según tus necesidades

    public List<clVenta> getAllVentas() {
        List<clVenta> ventas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VENTAS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clVenta venta = new clVenta(
                        resultSet.getInt("idVenta"),
                        resultSet.getString("idProducto"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDouble("precioUnitario"),
                        resultSet.getDate("fechaVenta"),
                        resultSet.getString("direccion_venta"),
                        resultSet.getString("cliente")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    public void insertVenta(clVenta venta) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VENTA_SQL)) {

            preparedStatement.setString(1, venta.getIdProducto());
            preparedStatement.setInt(2, venta.getCantidad());
            preparedStatement.setDouble(3, venta.getPrecioUnitario());
            preparedStatement.setDate(4, new java.sql.Date(venta.getFechaVenta().getTime()));
            preparedStatement.setString(5, venta.getDireccion_venta());
            preparedStatement.setString(6, venta.getCliente());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
  
    public void deleteVenta(int idVenta) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM tbl_ventas WHERE idVenta ='" + idVenta + "'");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

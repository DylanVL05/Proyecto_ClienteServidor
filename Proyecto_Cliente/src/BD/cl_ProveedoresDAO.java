/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_cliente.ModuloProvedor.clProvedor;

public class cl_ProveedoresDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_proyecto_cl";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "";

    private final String INSERT_PROVEEDOR_SQL = "INSERT INTO tbl_proveedores (id_Provedor, nombreProve, emailProve, telefono) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_PROVEEDORES = "SELECT * FROM tbl_proveedores";
    private final String UPDATE_PROVEEDOR_SQL = "UPDATE tbl_proveedores SET nombreProve = ?, emailProve = ?, telefono = ? WHERE id_Provedor = ?";
    private final String DELETE_PROVEEDOR_SQL = "DELETE FROM tbl_proveedores WHERE id_Provedor = ?";

    public List<clProvedor> getAllProveedores() {
        List<clProvedor> proveedores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROVEEDORES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clProvedor proveedor = new clProvedor(
                        resultSet.getString("id_Provedor"),
                        resultSet.getString("nombreProve"),
                        resultSet.getString("emailProve"),
                        resultSet.getString("telefono")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public void insertProveedor(clProvedor proveedor) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROVEEDOR_SQL)) {

            preparedStatement.setString(1, proveedor.getId_Provedor());
            preparedStatement.setString(2, proveedor.getNombreProve());
            preparedStatement.setString(3, proveedor.getEmailProve());
            preparedStatement.setString(4, proveedor.getTelefono());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProveedor(clProvedor proveedor) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROVEEDOR_SQL)) {

            preparedStatement.setString(1, proveedor.getNombreProve());
            preparedStatement.setString(2, proveedor.getEmailProve());
            preparedStatement.setString(3, proveedor.getTelefono());
            preparedStatement.setString(4, proveedor.getId_Provedor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
         public void deleteProveedor(String id_Provedor) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM tbl_proveedores WHERE id_Provedor ='" + id_Provedor + "'");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
        
        
    }

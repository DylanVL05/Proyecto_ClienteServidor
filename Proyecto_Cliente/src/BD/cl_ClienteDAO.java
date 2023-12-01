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
import proyecto_cliente.Modulo_Empleado_Cliente.clCliente;

public class cl_ClienteDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_proyecto_cl";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "";

    private final String INSERT_CLIENTE_SQL = "INSERT INTO tbl_clientes (nombre, edad, identificacion, tel_Cliente, direccion_Cl) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_ALL_CLIENTES = "SELECT * FROM tbl_clientes";
    private final String UPDATE_CLIENTE_SQL = "UPDATE tbl_clientes SET nombre = ?, edad = ?, tel_Cliente = ?, direccion_Cl = ? WHERE identificacion = ?";
    private final String DELETE_CLIENTE_SQL = "DELETE FROM tbl_clientes WHERE identificacion = ?";
    private final String SELECT_CLIENTE_BY_ID = "SELECT * FROM tbl_clientes WHERE identificacion = ?";

    public List<clCliente> getAllClientes() {
        List<clCliente> clientes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clCliente cliente = new clCliente(
                        resultSet.getString("tel_Cliente"),
                        resultSet.getString("direccion_Cl"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("identificacion")
                );
                cliente.setId(resultSet.getInt("id"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public clCliente getClienteByIdentificacion(String identificacion) {
        clCliente cliente = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTE_BY_ID)) {
            preparedStatement.setString(1, identificacion);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cliente = new clCliente(
                        resultSet.getString("tel_Cliente"),
                        resultSet.getString("direccion_Cl"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("identificacion")
                );
                cliente.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void insertCliente(clCliente cliente) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTE_SQL)) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setInt(2, cliente.getEdad());
            preparedStatement.setString(3, cliente.getIdentificacion());
            preparedStatement.setString(4, cliente.getTel_Cliente());
            preparedStatement.setString(5, cliente.getDireccion_Cl());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(clCliente cliente) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENTE_SQL)) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setInt(2, cliente.getEdad());
            preparedStatement.setString(3, cliente.getTel_Cliente());
            preparedStatement.setString(4, cliente.getDireccion_Cl());
            preparedStatement.setString(5, cliente.getIdentificacion());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCLiente(String identificacion) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM tbl_clientes WHERE identificacion ='" + identificacion + "'");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
    
    

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
import proyecto_cliente.Modulo_Empleado_Cliente.clEmpleado;

public class cl_EmpleadoDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_proyecto_cl";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "";

   private final String INSERT_EMPLEADO_SQL = "INSERT INTO tbl_empleados (nombre, edad, salario, puesto, identificacion) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_ALL_EMPLEADOS = "SELECT * FROM tbl_empleados";
    private final String UPDATE_EMPLEADO_SQL = "UPDATE tbl_empleados SET nombre = ?, edad = ?, puesto = ?, salario = ? WHERE identificacion = ?";
    private final String DELETE_EMPLEADO_SQL = "DELETE FROM tbl_empleados WHERE identificacion = ?";
    private final String SELECT_EMPLEADO_BY_ID = "SELECT * FROM tbl_empleados WHERE identificacion = ?";

    public List<clEmpleado> getAllEmpleados() {
        List<clEmpleado> empleados = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLEADOS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clEmpleado empleado = new clEmpleado(
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("identificacion"),
                        resultSet.getString("puesto"),
                        resultSet.getDouble("salario")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public clEmpleado getEmpleadoById(int id) {
        clEmpleado empleado = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLEADO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empleado = new clEmpleado(
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("identificacion"),
                        resultSet.getString("puesto"),
                        resultSet.getDouble("salario")
                );
                empleado.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }

 public void insertEmpleado(clEmpleado empleado) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLEADO_SQL)) {
        preparedStatement.setString(1, empleado.getNombre());
        preparedStatement.setInt(2, empleado.getEdad());
        preparedStatement.setDouble(3, empleado.getSalario());
        preparedStatement.setString(4, empleado.getPuesto());
        preparedStatement.setString(5, empleado.getIdentificacion());
        // Falta un valor para el parámetro 6 en la consulta SQL
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

   public void updateEmpleado(clEmpleado empleado) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLEADO_SQL)) {
        preparedStatement.setString(1, empleado.getNombre());
        preparedStatement.setInt(2, empleado.getEdad());
        preparedStatement.setString(3, empleado.getPuesto());
        preparedStatement.setDouble(4, empleado.getSalario());
        preparedStatement.setString(5, empleado.getIdentificacion());

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void deleteEmpleado(String identificacion) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM tbl_empleados WHERE identificacion ='" + identificacion + "'");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

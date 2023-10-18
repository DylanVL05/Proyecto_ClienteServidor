/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

/**
 *
 * @author andro
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Almacenamiento_Ventas {
    private static DataOutputStream archivoGuardar;
    private static DataInputStream archivoLectura;

    public static void almacenar(clVenta venta) {
        try {
            archivoGuardar = new DataOutputStream(new FileOutputStream("ventas.txt", true));
            archivoGuardar.writeUTF(venta.getIDProducto());
            archivoGuardar.writeInt(venta.getCantidad());
            archivoGuardar.writeDouble(venta.getPrecioUnitario());
            archivoGuardar.writeLong(venta.getFechaVenta().getTime()); // Guardar la fecha como un long
            archivoGuardar.close();
            JOptionPane.showMessageDialog(null, "Venta almacenada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos de la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<clVenta> cargarVentas() {
        ArrayList<clVenta> ventas = new ArrayList<>();
        try {
            archivoLectura = new DataInputStream(new FileInputStream("ventas.txt"));
            while (archivoLectura.available() > 0) {
                String idProducto = archivoLectura.readUTF();
                int cantidad = archivoLectura.readInt();
                double precioUnitario = archivoLectura.readDouble();
                long fechaVentaMillis = archivoLectura.readLong();
                Date fechaVenta = new Date(fechaVentaMillis);
                clVenta venta = new clVenta(idProducto, cantidad, precioUnitario, fechaVenta);
                ventas.add(venta);
            }
            archivoLectura.close();
            JOptionPane.showMessageDialog(null, "Ventas cargadas correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las ventas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ventas;
    }
}
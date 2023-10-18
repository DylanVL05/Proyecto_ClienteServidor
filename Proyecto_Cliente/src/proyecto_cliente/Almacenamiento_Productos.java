/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author andro
 */
public class Almacenamiento_Productos {
    
    
       private static DataOutputStream archivoGuardar;
    private static DataInputStream archivoLectura;

    public static void almacenar(clProductos producto) {
        try {
            archivoGuardar = new DataOutputStream(new FileOutputStream("productos.txt", true));
            archivoGuardar.writeUTF(producto.getNombre());
            archivoGuardar.writeUTF(producto.getID());
            archivoGuardar.writeDouble(producto.getPrecio());
            archivoGuardar.writeInt(producto.getCantidad());
            archivoGuardar.close();
            JOptionPane.showMessageDialog(null, "Producto almacenado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<clProductos> cargarProductos() {
        ArrayList<clProductos> productos = new ArrayList<>();
        try {
            archivoLectura = new DataInputStream(new FileInputStream("productos.txt"));
            while (archivoLectura.available() > 0) {
                String nombre = archivoLectura.readUTF();
                String id = archivoLectura.readUTF();
                double precio = archivoLectura.readDouble();
                int cantidad = archivoLectura.readInt();
                clProductos producto = new clProductos(nombre, id, precio, cantidad);
                productos.add(producto);
            }
            archivoLectura.close();
            JOptionPane.showMessageDialog(null, "Productos cargados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productos;
    }

    
    
    
    
    
    
    
    
    
    
    
}

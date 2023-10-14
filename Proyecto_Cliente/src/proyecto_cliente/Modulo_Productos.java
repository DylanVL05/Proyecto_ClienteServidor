/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;


import java.io.*;
import java.util.ArrayList;




/**
 *
 * @author andro
 */
public class Modulo_Productos {
    //Modulo de productos  
    
      private static final String NOMBRE_ARCHIVO = "productos.txt";
      
      
      
      
       public static void agregarProducto(clProductos producto) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(NOMBRE_ARCHIVO, true))) {
            dos.writeUTF(producto.getID());
            dos.writeUTF(producto.getNombre());
            dos.writeDouble(producto.getPrecio());
            dos.writeInt(producto.getCantidad());
        } catch (IOException e) {
            e.printStackTrace(); // Maneja las excepciones de escritura 
        }
    }
    
       
       
       
    
    
    
    
    
    
    
    
    
    
    
    
    
}

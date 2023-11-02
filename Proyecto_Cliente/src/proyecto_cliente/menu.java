/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

import proyecto_cliente.Modulo_Productos_Ventas.Modulo_Productos;
import proyecto_cliente.Modulo_Productos_Ventas.clProductos;
import javax.swing.JOptionPane;

/**
 *
 * @author andro
 */
public class menu {
    
    
    
    
    public static void Menu(){
    
       String ID = "ID_GENERADO"; 
       Modulo_Productos moduloProductos = new Modulo_Productos(ID);    
        
        int opcion;
        do {
            String menu = "1. Agregar producto\n2. Buscar producto por ID\n3. Eliminar producto por ID\n4. Actualizar producto por ID\n5. Mostrar productos\n6. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch (opcion) {
                case 1:
                     
                     ID = JOptionPane.showInputDialog("Introduce el ID del producto:");
                    
                    String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto:"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad del producto:"));
                    clProductos nuevoProducto = new clProductos(nombre, ID, precio, cantidad);
                    moduloProductos.agregarProducto(nuevoProducto);
                    break;
                case 2:
                    String buscarID = JOptionPane.showInputDialog("Introduce el ID del producto a buscar:");
                    int indice = moduloProductos.buscarXID(buscarID);
                    if (indice != -1) {
                        JOptionPane.showMessageDialog(null, "Producto encontrado en la posición " + indice);
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    }
                    break;
                case 3:
                    String eliminarID = JOptionPane.showInputDialog("Introduce el ID del producto a eliminar:");
                    moduloProductos.eliminarProducto(eliminarID);
                    break;
                case 4:
                    String actualizarID = JOptionPane.showInputDialog("Introduce el ID del producto a actualizar:");
                    int indiceActualizar = moduloProductos.buscarXID(actualizarID);
                    if (indiceActualizar != -1) {
                        String nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre del producto:");
                        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio del producto:"));
                        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nueva cantidad del producto:"));
                        clProductos nuevoProductoActualizado = new clProductos(nuevoNombre, actualizarID, nuevoPrecio, nuevaCantidad);
                        moduloProductos.actualizar(nuevoProductoActualizado, indiceActualizar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    }
                    break;
                case 5:
                    String listaProductos = moduloProductos.mostrarProductos();
                    JOptionPane.showMessageDialog(null, listaProductos);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 6);
    }
    
    
    
    //Un menu de prueba 
       public static void main(String[] args) {
        
       Menu();
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
}

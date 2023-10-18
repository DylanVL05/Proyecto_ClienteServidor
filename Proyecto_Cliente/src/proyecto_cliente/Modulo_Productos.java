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
    
      //private static final String NOMBRE_ARCHIVO = "productos.txt";
      
     
      
      
      /*
      
      
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
    
       */
    
     private Modulo_Ventas moduloVentas;
     private String nombre;  
     private String ID;
    private ArrayList<clProductos> productos;

    
    public Modulo_Productos(String ID) {
        this.nombre = nombre;
        this.ID = ID;
        productos = Almacenamiento_Productos.cargarProductos();
        moduloVentas = new Modulo_Ventas();
    }

    public ArrayList<clProductos> getAnimalitos() {
        return productos;
    }
    
    public void agregarProducto(clProductos productos){
        this.productos.add(productos);
        Almacenamiento_Productos.almacenar(productos);
    }
    
    public int buscarXID(String ID){
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getID().equals(ID)){
                return i;
            }
        }
        return -1;
    }
    
    public void eliminarProducto(String ID){
        int ind = buscarXID(ID);
        if (ind!=-1){
            productos.remove(ind);
        }
    }
    
    
    public void actualizar(clProductos nuevo_producto, int ind){
        productos.set(ind, nuevo_producto);
    }
    

    public String mostrarProductos(){
        String salida = "Listado de Productos \n";
        for(int i = 0; i < productos.size(); i++){
            salida+="Nombre: "+productos.get(i).getNombre()+"\n";
            salida+="ID: "+productos.get(i).getID()+"\n";
            salida+="Cantidad Disponible: "+productos.get(i).getCantidad()+"\n";
            salida+="Precio: "+productos.get(i).getPrecio()+"\n";
             
        }
        return salida;
    }
    
       
        public void venderProducto(String ID, int cantidadAVender, double precioUnitario) {
        int ind = buscarXID(ID);
        if (ind != -1) {
            clProductos producto = productos.get(ind);
            int cantidadDisponible = producto.getCantidad();

            if (cantidadDisponible >= cantidadAVender) {
                producto.setCantidad(cantidadDisponible - cantidadAVender);
                actualizar(producto, ind);
                moduloVentas.agregarVenta(ID, cantidadAVender, precioUnitario);
                System.out.println("Venta realizada. Cantidad vendida: " + cantidadAVender);
            } else {
                System.out.println("No hay suficiente cantidad disponible para la venta.");
            }
        } else {
            System.out.println("Producto no encontrado con el ID proporcionado.");
        }
    } 
    
    
    
    
    
    
    
}

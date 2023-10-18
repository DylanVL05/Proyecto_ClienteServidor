/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

/**
 *
 * @author andro
 */
public class clProductos {
 
  private String Nombre, ID;
  
  private double precio;
  
  private int cantidad;

    public clProductos(String Nombre, String ID, double precio, int cantidad) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "clProductos{" + "Nombre=" + Nombre + ", ID=" + ID + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }


  
    
    
    
    
    
}

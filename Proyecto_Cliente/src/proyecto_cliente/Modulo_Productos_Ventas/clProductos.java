/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente.Modulo_Productos_Ventas;

/**
 *
 * @author andro
 */
public class clProductos {
   private int id;
  private String Nombre;

  private double precio;
  
  private int cantidad;
  private String identificacion;

    public clProductos(String Nombre, double precio, int cantidad, String identificacion) {
        this.Nombre = Nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
  

    public clProductos() {
    }


  
  

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "clProductos{" + "id=" + id + ", Nombre=" + Nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", identificacion=" + identificacion + '}';
    }




  
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente.Modulo_Productos_Ventas;

import java.util.Date;

/**
 *
 * @author andro
 */
public class clVenta {
    
    
    
   private String IDProducto;
    private int cantidad;
    private double precioUnitario;
    private Date fechaVenta;

    public clVenta(String IDProducto, int cantidad, double precioUnitario, Date fechaVenta) {
        this.IDProducto = IDProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVenta = fechaVenta;
    }

    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "clVenta{" + "IDProducto=" + IDProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", fechaVenta=" + fechaVenta + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

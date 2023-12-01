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
    
    
    private int idVenta;
    private String idProducto;
    private int cantidad;
    private double precioUnitario;
    private Date fechaVenta;
    private String direccion_venta;
    private String cliente;
    

    public clVenta(int idVenta, String idProducto, int cantidad, double precioUnitario, Date fechaVenta,String direccion_venta, String cliente) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVenta = fechaVenta;
        this.direccion_venta = direccion_venta;
        this.cliente= cliente;
    }

    public clVenta(String idProducto, int cantidad, double precioUnitario, Date fechaVenta) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVenta = fechaVenta;
    }

    public String getDireccion_venta() {
        return direccion_venta;
    }

    public void setDireccion_venta(String direccion_venta) {
        this.direccion_venta = direccion_venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    
    
    
    
    
    
    
    
    public clVenta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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
        return "clVenta{" + "idVenta=" + idVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", fechaVenta=" + fechaVenta + '}';
    }


    
    
    
    
    
    
    
    
    
    
    
    
}

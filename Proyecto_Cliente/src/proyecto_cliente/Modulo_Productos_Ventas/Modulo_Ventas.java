/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente.Modulo_Productos_Ventas;

/**
 *
 * @author andro
 */
import java.util.ArrayList;
import java.util.Date;

public class Modulo_Ventas {
    private ArrayList<clVenta> ventas;

    public Modulo_Ventas() {
        ventas = new ArrayList<>();
    }

    public void agregarVenta(String IDProducto, int cantidad, double precioUnitario) {
        Date fechaVenta = new Date();
        clVenta venta = new clVenta(IDProducto, cantidad, precioUnitario, fechaVenta);
        venta.setIDProducto(IDProducto);
        venta.setCantidad(cantidad);
        venta.setPrecioUnitario(precioUnitario);
        venta.setFechaVenta(new Date()); // Fecha actual

        ventas.add(venta);
    }

    public void listarVentas() {
        for (clVenta venta : ventas) {
            System.out.println("ID Producto: " + venta.getIDProducto());
            System.out.println("Cantidad vendida: " + venta.getCantidad());
            System.out.println("Precio unitario: " + venta.getPrecioUnitario());
            System.out.println("Fecha de venta: " + venta.getFechaVenta());
            System.out.println("---------------------------");
        }
    }

    public clVenta buscarVentaPorID(String ID) {
        for (clVenta venta : ventas) {
            if (venta.getIDProducto().equals(ID)) {
                return venta;
            }
        }
        return null; // Si no se encuentra la venta con el ID especificado
    }
}
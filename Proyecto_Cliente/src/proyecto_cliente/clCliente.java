/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

/**
 *
 * @author andro
 */
public class clCliente extends Persona {
    
    private String tel_Cliente;
    
    private String direccion_Cl;

    public clCliente(String tel_Cliente, String direccion_Cl, String nombre, int edad, String cedula) {
        super(nombre, edad, cedula);
        this.tel_Cliente = tel_Cliente;
        this.direccion_Cl = direccion_Cl;
    }

    public String getTel_Cliente() {
        return tel_Cliente;
    }

    public void setTel_Cliente(String tel_Cliente) {
        this.tel_Cliente = tel_Cliente;
    }

    public String getDireccion_Cl() {
        return direccion_Cl;
    }

    public void setDireccion_Cl(String direccion_Cl) {
        this.direccion_Cl = direccion_Cl;
    }

    @Override
    public String toString() {
        return super.toString() + "tel_Cliente=" + tel_Cliente + ", direccion_Cl=" + direccion_Cl + '}';
    }
    
    
    
    
    
    
}




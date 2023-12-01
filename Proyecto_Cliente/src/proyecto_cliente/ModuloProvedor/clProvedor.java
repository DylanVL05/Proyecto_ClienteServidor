/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente.ModuloProvedor;

/**
 *
 * @author andro
 */
public class clProvedor {
    private String id_Provedor;
    private String nombreProve;
    
    private String emailProve;
    
    private String telefono;

    public clProvedor(String id_Provedor, String nombreProve, String emailProve, String telefono) {
        this.id_Provedor = id_Provedor;
        this.nombreProve = nombreProve;
        this.emailProve = emailProve;
        this.telefono = telefono;
    }

    public String getId_Provedor() {
        return id_Provedor;
    }

    public void setId_Provedor(String id_Provedor) {
        this.id_Provedor = id_Provedor;
    }


    
    
    
    public String getNombreProve() {
        return nombreProve;
    }

    public void setNombreProve(String nombreProve) {
        this.nombreProve = nombreProve;
    }

    public String getEmailProve() {
        return emailProve;
    }

    public void setEmailProve(String emailProve) {
        this.emailProve = emailProve;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "clProvedor{" + "id_Provedor=" + id_Provedor + ", nombreProve=" + nombreProve + ", emailProve=" + emailProve + ", telefono=" + telefono + '}';
    }


    
    
    
    
    
    
    
    
}

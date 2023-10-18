/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

/**
 *
 * @author andro
 */
public class clProvedor {
    
    private String nombreProve;
    
    private String emailProve;
    
    private String telefono;

    public clProvedor(String nombreProve, String emailProve, String telefono) {
        this.nombreProve = nombreProve;
        this.emailProve = emailProve;
        this.telefono = telefono;
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
        return "clProvedor{" + "nombreProve=" + nombreProve + ", emailProve=" + emailProve + ", telefono=" + telefono + '}';
    }
    
    
    
    
    
    
    
    
    
    
}

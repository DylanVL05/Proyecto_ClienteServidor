/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author andro
 */
public class Login {
    
 
    
      private String usuario = "admin";
    private String contrasena = "password";
    
    public boolean autenticar(String usuarioInput, String contrasenaInput) {
        return usuario.equals(usuarioInput) && contrasena.equals(contrasenaInput);
    }
    
    public boolean realizarAutenticacion() {
        String usuarioInput = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
        String contrasenaInput = JOptionPane.showInputDialog("Ingrese la contraseña:");
        
        return autenticar(usuarioInput, contrasenaInput);
    } 
    
    
}

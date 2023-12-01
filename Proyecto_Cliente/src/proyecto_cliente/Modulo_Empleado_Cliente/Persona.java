/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cliente.Modulo_Empleado_Cliente;

/**
 *
 * @author andro
 */                            //Clase padre Persona  
public abstract class Persona implements imprimir {
 
    private String nombre;
    
    private int id;
    
    private int edad;
    
    private String identificacion;
 
    public Persona(String nombre, int id, int edad, String cedula) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.identificacion = cedula;
    }

    public Persona(String nombre, int edad, String identificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.identificacion = identificacion;
    }

    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }



    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", cedula=" + identificacion + '}';
    }

    @Override
    public void imprimir() {
        System.out.println(nombre+ "\n");
        System.out.println(edad + "\n");
        System.out.println(identificacion+ "\n");
    }
    

    
    
    
    
    
}

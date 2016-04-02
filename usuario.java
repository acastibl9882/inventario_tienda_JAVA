/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Alvaro Castiblanco, Julian Betancourt
 */
public class Usuario {
    
    public String Id;
    public String nombre;
    public String contraseña;

    public Usuario(String Id) {
        this.Id = Id;
    }    
    
    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }        

    public Usuario(String Id, String nombre, String contraseña) {
        this.Id = Id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }        

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}

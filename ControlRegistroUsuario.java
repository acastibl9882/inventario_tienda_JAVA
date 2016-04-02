/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.SqlUsuario;
import datos.Usuario;

/**
 *
 * @author Alvaro Castiblanco, Julian Betancourt
 */
public class ControlRegistroUsuario {

    public SqlUsuario sqlUsuario;
    public Usuario usuario;

    public ControlRegistroUsuario() {
        sqlUsuario = new SqlUsuario();
    }

    /**
     * Llena la tabla de usuarios
     *
     * @return
     */
    public String[][] llenarTabla() {
        return sqlUsuario.selectUsuarios();
    }

    /**
     * Envia los datos necesarios para crear un nuevo producto en la base de
     * datos
     *
     * @param nombre
     * @param clave
     */
    public void agregarUsuario(String nombre, String clave) {
        usuario = new Usuario(nombre, clave);
        sqlUsuario.insertUsuario(usuario);
    }

    /**
     * Envia el id del usuario para que sea eliminado de la base de datos
     *
     * @param id
     */
    public void eliminarUsuario(String id) {
        usuario = new Usuario(id);        
        sqlUsuario.deleteUsuario(usuario);
    }

    /**
     * Envia los datos necesarios para actualizar los datos de un registro de la
     * tabla usuario en la base de datos
     *
     * @param id
     * @param nombre
     * @param clave
     */
    public void modificarUsuario(String id, String nombre, String clave) {
        usuario = new Usuario(id, nombre, clave);
        sqlUsuario.updateUsuarios(usuario);
    }

    /**
     * Envia el id del usuario y retorna un array de una dimensión con los datos
     * de ese usuario
     *
     * @param id
     * @return
     */
    public String[] traerUsuario(String id) {
        return sqlUsuario.selectUsuarioPorId(id);
    }
}

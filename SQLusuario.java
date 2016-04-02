/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alvaro Castiblanco, Julian Betancourt
 */
public class SqlUsuario {

    private Conexion conexion;
    private Connection conector;
    private String consulta;
    private Statement st;
    private ResultSet rs;
    public String[][] datosTabla;
    public String[] datosEditor;
    public Usuario usuario;

    /**
     * Se encarga de realizar la consulta para verificar si existe un usuario y
     * una clave que coincidad en la tabla usuarios con los parametros enviados
     *
     * @param usuario
     * @param clave
     * @return
     */
    public Boolean verificaUsuario(String usuario, String clave) {

        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "SELECT count(*) FROM inventario.usuarios WHERE usuario ='" + usuario + "' AND clave=" + clave;
        int i = 0;
        Boolean bandera = false;
        try {
            st = (Statement) conector.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                i = rs.getInt(1);
            }

            if (i != 0) {
                bandera = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bandera;
    }

    /**
     * Se encarga de realizar la consulta y recibir el resultado, basicamente
     * trae todo lo que esta en la tabla produusuarios y los inserta en el array
     * dataTabla
     *
     * @return
     */
    public String[][] selectUsuarios() {

        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "SELECT count(*) FROM inventario.usuarios";

        try {
            st = (Statement) conector.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                datosTabla = new String[rs.getInt(1)][3];
            }
            consulta = "SELECT * FROM inventario.usuarios";
            rs = st.executeQuery(consulta);

            int i = 0;
            while (rs.next()) {
                datosTabla[i][0] = rs.getInt(1) + "";
                datosTabla[i][1] = rs.getString(2);
                datosTabla[i][2] = rs.getString(3);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return datosTabla;
    }

    /**
     * Realiza la inserción de un registro en la tabla usuarios
     *
     * @param usuario
     */
    public void insertUsuario(Usuario usuario) {
        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "INSERT INTO inventario.usuarios (usuario, clave) VALUES ('" + usuario.getNombre() + "','" + usuario.getContraseña() + "')";

        try {
            st = (Statement) conector.createStatement();
            st.executeUpdate(consulta);

            conector.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Se encarga de eliminar el registro de la tabla usuarios al cual
     * corresponda el idUsuario
     *
     * @param usuario
     */
    public void deleteUsuario(Usuario usuario) {
        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "DELETE FROM inventario.usuarios WHERE idusuario = " + usuario.getId();

        try {
            st = (Statement) conector.createStatement();
            st.executeUpdate(consulta);
            conector.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Actualiza un registro de la tabla usuarios con los parametros de este
     * metodo al cual corresponda el id de la tabla usuarios
     *
     * @param usuario
     */
    public void updateUsuarios(Usuario usuario) {
        conexion = new Conexion();
        conector = (Connection) conexion.getConector();

        consulta = "UPDATE inventario.usuarios SET usuario='" + usuario.getNombre() + "', clave ='" + usuario.getContraseña() + "' WHERE idusuario = " + usuario.getId();
        try {
            st = (Statement) conector.createStatement();
            st.executeUpdate(consulta);
            conector.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Se encarga de realizar la consulta y recibir el resultado, basicamente
     * trae el registro de la tabla usuarios correspondientes al idUsuario y los
     * inserta en el array datosEditor
     *
     * @param idUsuario
     * @return
     */
    public String[] selectUsuarioPorId(String idUsuario) {

        conexion = new Conexion();
        conector = (Connection) conexion.getConector();

        try {
            consulta = "SELECT * FROM inventario.usuarios WHERE idusuario = " + idUsuario;
            rs = st.executeQuery(consulta);
            datosEditor = new String[2];
            while (rs.next()) {
                datosEditor[0] = rs.getString(2);
                datosEditor[1] = rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return datosEditor;
    }
}

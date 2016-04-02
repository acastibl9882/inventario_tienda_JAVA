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
public class SqlProducto {

    private Conexion conexion;
    private Connection conector;
    private String consulta;
    private Statement st;
    private ResultSet rs;
    public String[][] datosTabla;
    public String[] datosEditor;
    public Producto producto;

    /**
     * Se encarga de realizar la consulta y recibir el resultado, basicamente
     * trae todo lo que esta en la tabla productos y los inserta en el array
     * dataTabla
     *
     * @return
     */
    public String[][] selectProductos() {

        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "SELECT count(*) FROM inventario.productos";

        try {
            st = (Statement) conector.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                datosTabla = new String[rs.getInt(1)][5];
            }
            consulta = "SELECT * FROM inventario.productos";
            rs = st.executeQuery(consulta);

            int i = 0;
            while (rs.next()) {
                datosTabla[i][0] = rs.getInt(1) + "";
                datosTabla[i][1] = rs.getString(2);
                datosTabla[i][2] = rs.getString(3);
                datosTabla[i][3] = rs.getString(4);
                datosTabla[i][4] = rs.getString(5);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return datosTabla;
    }


    /**
     * Realiza la inserción de un registro en la tabla productos
     * @param producto 
     */
    public void insertProduto(Producto producto) {
        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "INSERT INTO inventario.productos (nombre, precio, cantidad, iva) VALUES ('" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getCantidad() + "','" + producto.getIva() + "')";

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
     * Se encarga de eliminar el registro de la tabla productos al cual
     * corresponda el idProducto
     *
     * @param producto
     */
    public void deleteProducto(Producto producto) {
        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "DELETE FROM inventario.productos WHERE id = " + producto.id;
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
     * Actualiza un registro de la tabla productos con los parametros de este
     * metodo al cual corresponda el id de la tabla productos
     *
     * @param producto
     */
    public void updateProductos(Producto producto) {
        conexion = new Conexion();
        conector = (Connection) conexion.getConector();
        consulta = "UPDATE inventario.productos SET nombre='" + producto.getNombre() + "', precio ='" + producto.getPrecio() + "', cantidad ='" + producto.getCantidad() + "', iva ='" + producto.getIva() + "' WHERE id = " + producto.getId();
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
     * trae el registro de la tabla productos correspondientes al idProducto y
     * los inserta en el array datosEditor
     *
     * @param idProducto
     * @return
     */
    public String[] selectProductosPorId(String idProducto) {

        conexion = new Conexion();
        conector = (Connection) conexion.getConector();

        try {
            consulta = "SELECT * FROM inventario.productos WHERE id = " + idProducto;
            rs = st.executeQuery(consulta);
            datosEditor = new String[4];
            while (rs.next()) {
                datosEditor[0] = rs.getString(2);
                datosEditor[1] = rs.getString(3);
                datosEditor[2] = rs.getString(4);
                datosEditor[3] = rs.getString(5);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return datosEditor;
    }

}

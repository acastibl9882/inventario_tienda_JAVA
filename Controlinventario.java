package logica;

import datos.Producto;
import datos.SqlProducto;

/**
 *
 * @author Alvaro Castiblanco, Julian Betancourt
 */
public class ControlInventario {

    public SqlProducto sqlProducto;
    public Producto producto;

    public ControlInventario() {
        sqlProducto = new SqlProducto();
    }

    /**
     * Llena la tabla de productos
     *
     * @return
     */
    public String[][] llenarTabla() {
        return sqlProducto.selectProductos();
    }

    /**
     * Envia los datos necesarios para crear un nuevo producto en la base de
     * datos
     *
     * @param nombre
     * @param precio
     * @param cantidad
     * @param iva
     */
    public void agregarProducto(String nombre, String precio, String cantidad, String iva) {
        producto = new Producto(nombre, precio, cantidad, iva);                
        sqlProducto.insertProduto(producto);
    }

    /**
     * Envia el id del producto para que sea eliminado de la base de datos
     *
     * @param id
     */
    public void eliminarProducto(String id) {
        producto = new Producto(id);
        sqlProducto.deleteProducto(producto);
    }

    /**
     * Envia los datos necesarios para actualizar los datos de un registro de la
     * tabla producto en la base de datos
     *
     * @param id
     * @param nombre
     * @param precio
     * @param cantidad
     * @param iva
     */
    public void modificarProducto(String id, String nombre, String precio, String cantidad, String iva) {
        producto = new Producto(id, nombre, precio, cantidad, iva);
        sqlProducto.updateProductos(producto);
    }

    /**
     * Envia el id del producto y retorna un array de una dimensión con los
     * datos de ese producto
     *
     * @param id
     * @return
     */
    public String[] traerProducto(String id) {
        return sqlProducto.selectProductosPorId(id);
    }

}

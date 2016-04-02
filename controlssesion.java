package logica;

import datos.SqlUsuario;
import javax.swing.JOptionPane;
import ventanas.InicioSesion;
import ventanas.VentanaPrincipal;
import ventanas.VentanaUsuario;

/**
 *
 * @author Alvaro Castiblanco, Julian Betancourt
 */
public class ControlSesion {

    public SqlUsuario sqlUsuario;
    public VentanaUsuario vu;
    public VentanaPrincipal vp ;

    public ControlSesion() {
        sqlUsuario = new SqlUsuario();
    }

    /**
     * Verifica que el usuario que ingreso exista y que coincida su contraseña
     * si es así lo envia a la ventana de inventario
     *
     * @param usuario
     * @param clave
     * @param is
     */
    public void verificarIdentidad(String usuario, String clave, InicioSesion is) {
        if (sqlUsuario.verificaUsuario(usuario, clave)) {
            is.setVisible(false);
            vp = new VentanaPrincipal();
            vp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(is, "Ingreso la clave o el usuario incorrectamente ");
        }

    }

    /**
     * Verifica que el usuario que ingreso exista y que coincida su contraseña
     * si es así lo envia a la ventana de Registro de usuarios
     *
     * @param usuario
     * @param clave
     * @param is
     */
    public void registrarUsuario(String usuario, String clave, InicioSesion is) {
        if (sqlUsuario.verificaUsuario(usuario, clave)) {
            is.setVisible(false);
            vu = new VentanaUsuario();
            vu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(is, "Ingreso la clave o el usuario administrador incorrectamente ");
        }

    }
}

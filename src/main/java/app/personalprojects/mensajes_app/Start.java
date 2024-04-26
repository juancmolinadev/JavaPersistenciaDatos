package app.personalprojects.mensajes_app;

import java.sql.Connection;

/**
 *
 * @author MolinAnimation
 */
public class Start {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

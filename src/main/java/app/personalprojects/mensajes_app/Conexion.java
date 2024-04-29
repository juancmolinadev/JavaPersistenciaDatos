
package app.personalprojects.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MolinAnimation
 */
public class Conexion {
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mensajes_app", "root", "");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}

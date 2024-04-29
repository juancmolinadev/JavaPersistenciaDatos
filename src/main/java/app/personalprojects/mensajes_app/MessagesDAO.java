/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.personalprojects.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MolinAnimation
 */
public class MessagesDAO {
    public static void createMessageDB(MessageDTO message) {
        ConnectionJDBC con = new ConnectionJDBC();

        try (Connection conn = con.getConnection()) {
            PreparedStatement stmt = null;

            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, message.getMensaje());
                stmt.setString(2, message.getAutor_mensaje());

                stmt.executeUpdate();
                System.out.println("Message was created");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void readMessagesDB() {

    }

    public static void deleteMessagesDB(int id_mensajes) {

    }

    public static void updateMessagesDB(MessageDTO message) {

    }

}

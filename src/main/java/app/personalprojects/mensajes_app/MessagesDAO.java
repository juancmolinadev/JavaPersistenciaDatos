/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.personalprojects.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void showMessagesDB() {
        ConnectionJDBC con = new ConnectionJDBC();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try (Connection conn = con.getConnection()) {

            String query = "SELECT * FROM mensajes";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje") +
                        "\n Message: " + rs.getString("mensaje") +
                        "\n Author: " + rs.getString("autor_mensaje") +
                        "\n Created on: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Can't reach any messages");
            System.out.println(e);
        }
    }

    public static void deleteMessagesDB(int messageId) {
        ConnectionJDBC con = new ConnectionJDBC();

        try (Connection conn = con.getConnection()) {
            PreparedStatement stmt = null;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, messageId);
                stmt.executeUpdate();

                System.out.println("Message " + messageId + " was deleted succesfully");
            } catch (SQLException e) {
                System.out.println("The message with id: " + messageId + " wasn't found");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateMessagesDB(MessageDTO message) {
        ConnectionJDBC con = new ConnectionJDBC();

        try (Connection conn = con.getConnection()) {
            PreparedStatement stmt = null;

            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, message.getMensaje());
                stmt.setInt(2, message.getId_mensaje());
                stmt.executeUpdate();
                System.out.println("Message was updated succesfully");

            } catch (SQLException e) {
                System.out.println("Can't update the message");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.personalprojects.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author MolinAnimation
 */
public class MessagesService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write a message");
        String userMessage = sc.nextLine();

        System.out.println("Write your name");
        String userAuthor = sc.nextLine();

        MessageDTO message = new MessageDTO();
        message.setMensaje(userMessage);
        message.setAutor_mensaje(userAuthor);

        MessagesDAO.createMessageDB(message);

    }

    public static void showMessages() {

    }

    public static void deleteMessages() {

    }

    public static void editMessages() {

    }
}

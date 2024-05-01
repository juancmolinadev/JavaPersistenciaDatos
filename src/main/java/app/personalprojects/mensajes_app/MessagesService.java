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
        MessagesDAO.showMessagesDB();
    }

    public static void deleteMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type id message, if you dont have it press 0 to see all messages");
        int userAnswer = sc.nextInt();

        if (userAnswer != 0) {
            MessagesDAO.deleteMessagesDB(userAnswer);
        }else{
            showMessages();
            deleteMessages();
        }

    }

    public static void editMessages() {

    }
}

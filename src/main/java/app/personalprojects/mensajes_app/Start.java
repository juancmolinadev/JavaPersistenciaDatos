package app.personalprojects.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author MolinAnimation
 */
public class Start {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;
        do {
            System.out.println("____________________");
            System.out.println("Starting app \n " +
                    "1. Create message \n " +
                    "2. Show message \n " +
                    "3. Edit message \n" +
                    "4. Delete message \n" +
                    "5. Exit");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessagesService.createMessage();
                    break;
                case 2:
                    MessagesService.showMessages();
                    break;
                case 3:
                    MessagesService.editMessages();
                    break;
                case 4:
                    MessagesService.deleteMessages();
                    break;
                default:
                    break;
            }

        } while (option != 5);
    }
}

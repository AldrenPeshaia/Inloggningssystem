package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ObjectMapper objectMapper = new ObjectMapper();
        /***
         * Här så börjas allt, jag skapade min menu genom att använda sout (System out print)
         *
         */
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------");
            System.out.println("1. Create account");
            System.out.println("2. View account details");
            System.out.println("3. Exit");
            System.out.println("---------------------------");

            int choice = reader.nextInt();
            reader.nextLine();
            /***
             * Här så använde jag mig av switch metoden för att använda case eftersom jag ska kunna använda t.ex create account eller
             * View account details
             * I case 1 alltså Create account så ska de spelas upp att du ska kunna skriva in full name sedan finns det en reader.nextline då
             * du ska kunna skriva in username och sist din password, när du har gjort det så skapas en user i json.
             */
            switch (choice) {
                case 1:
                    System.out.println("Enter your full name:");
                    String fullName = reader.nextLine();
                    System.out.println("Enter your username:");
                    String username = reader.nextLine();
                    System.out.println("Enter your password:");
                    String password = reader.nextLine();
                    userService.createUserAccount(fullName, username, password);
                    break;

                /***
                 * I case 2 så handlar det om att du ska kunna läsa en användares information
                 * Jag använde mig utav counter då för varje user som skapas så blir de -1 -2 -3 -4 osv
                 * sedan så behöver man skriva in en username som finns i json om inte det finns så behöver du skriva igen.
                 */
                case 2:
                    int counter = 1;
                    for (Users item : userService.users){
                        System.out.println(counter+ "- "+item.getUserName());
                        counter++;
                    }
                    System.out.println("Enter your username:");
                    String viewUsername = reader.nextLine();
                    userService.viewUsersDetails(viewUsername);
                    break;

                /***
                 * I case 3 så är det ganska simplet där programmet stängs av.
                 * Längst ner om du inte klickar något så får du medealande där de står att du inte använde en giltig siffra.
                 */
                case 3:
                    System.out.println("you closed the program!");
                    try {
                        objectMapper.writeValue(UserService.usersFile, userService.users);
                    } catch (IOException e) {
                        System.err.println("could not save your information " + e.getMessage());
                    }
                    return;
                default:
                    System.out.println("you pushed the wrong button. Try again");
            }
        }
    }

}

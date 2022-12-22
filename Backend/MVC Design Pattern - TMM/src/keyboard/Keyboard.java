package keyboard;

import user.User;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Keyboard {

    public Keyboard() {
        Scanner sc = new Scanner(System.in);
    }

    private static void addObjectToList(User user) {
        List<User> users = new ArrayList<>();
        users.add(user);
    }

    public static void createUserObject(User user) {

        Scanner sc = new Scanner(System.in);
        InputValidator inputValidator = new InputValidator();

        String login = sc.nextLine();
        while (!inputValidator.isValidLog(login)) {
            login = sc.nextLine();
        }
        user.setLogin(login);

        String password = sc.nextLine();
        while (!inputValidator.isValidPass(password)) {
            password = sc.nextLine();
        }
        user.setPassword(password);

        String firstName = sc.nextLine();
        while (inputValidator.isValidName(firstName)) {
            firstName = sc.nextLine();
        }
        user.setFirstName(firstName);

        String lastName = sc.nextLine();
        while (!inputValidator.isValidName(lastName)) {
            lastName = sc.nextLine();
        }
        user.setLastName(lastName);

        String email = sc.nextLine();
        while (!inputValidator.isValidEm(email)) {
            email = sc.nextLine();
        }
        user.setEmail(email);

        // ZACHOWAJ juzera
        addObjectToList(user);

        // PODSUMOWANIE
        System.out.println("You've just created a new user: " + user.getClass());
    }
}

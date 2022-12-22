package registerStrategy;

import user.AdminUser;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterAdmin implements RegisterStrategy {

    private List<AdminUser> adminList = new ArrayList<>();

    // BEFORE REGISTERING A NEW USER: SUMMARY
//    @Override
//    public void register(User user) {
//
//        Scanner sc = new Scanner(System.in);
//        InputValidator inputValidator = new InputValidator();
//
//        String login = sc.nextLine();
//        while (!inputValidator.isValidLog(login)) {
//            login = sc.nextLine();
//        }
//        user.setLogin(login);
//
//        String password = sc.nextLine();
//        while (!inputValidator.isValidPass(password)) {
//            password = sc.nextLine();
//        }
//        user.setPassword(password);
//
//        String firstName = sc.nextLine();
//        while (inputValidator.isValidName(firstName)) {
//            firstName = sc.nextLine();
//        }
//        user.setFirstName(firstName);
//
//        String lastName = sc.nextLine();
//        while (!inputValidator.isValidName(lastName)) {
//            lastName = sc.nextLine();
//        }
//        user.setLastName(lastName);
//
//        String email = sc.nextLine();
//        while (!inputValidator.isValidEm(email)) {
//            email = sc.nextLine();
//        }
//        user.setEmail(email);
//
//        // PODSUMOWANIE
//        System.out.println("You're about to create a new user: " + user);
//
//        saveUser(user);
//    }

    @Override
    public void register(User user) {

        Scanner sc = new Scanner(System.in);

        System.out.print("login: ");
        String login = sc.nextLine();
        user.setLogin(login);

        System.out.print("password: ");
        String password = sc.nextLine();
        user.setPassword(password);

        System.out.print("firstName: ");
        String firstName = sc.nextLine();
        user.setFirstName(password);

        System.out.print("lastName: ");
        String lastName = sc.nextLine();
        user.setLastName(password);

        System.out.print("email: ");
        String email = sc.nextLine();
        user.setEmail(email);

        // PODSUMOWANIE
        System.out.println("You're about to create a new user: " + user);
        save(user);
    }

    @Override
    public void save(User user) {
        adminList.add((AdminUser) user);
    }

    //    public boolean isRegistered(User user) {
//        return userList.stream().anyMatch(user1 -> user1.getLogin().equals(user.getLogin()));
//    }
}

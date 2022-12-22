package Pages;

import java.util.Scanner;

public class MainPage {

    public void displayOptions() {

        LoginPage log = new LoginPage();
        RegistrationPage reg = new RegistrationPage();

        Scanner sc = new Scanner(System.in);

        System.out.println("**********");
        System.out.println("a. Login");
        System.out.println("b. Register");
        System.out.println("c. Quit");
        System.out.println("**********");
        System.out.println("Select one of the options: ");

        while (true) {

            String selectedOption = sc.nextLine();

            if (selectedOption.equals("a")) {
                log.logIn();
                break;
            } else if (selectedOption.equals("b")) {
                reg.register();
                break;
            } else if (selectedOption.equals("c")) {
                break;
            } else {
                System.out.println("Invalid input. Try again.");
                continue;
            }

//            switch (selectedOption) {
//                case "a":
//                    log.logInUser();
//                    break;
//                case "b":
//                    reg.registerUser();
//                    break;
//                case "c":
//                    break;
//                default:
//                    System.out.println("Invalid input. Try again.");
//                    continue;
//            }
        }
    }
}

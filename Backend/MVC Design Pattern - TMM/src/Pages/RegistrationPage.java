package Pages;

import user.AdminUser;
import user.StandardUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationPage {

    private List<StandardUser> standardUserList = new ArrayList<>();
    private List<AdminUser> adminUserList = new ArrayList<>();

    public List<StandardUser> getStandardUserList() {
        return standardUserList;
    }
    public void setStandardUserList(List<StandardUser> standardUserList) {
        this.standardUserList = standardUserList;
    }

    public List<AdminUser> getAdminUserList() {
        return adminUserList;
    }
    public void setAdminUserList(List<AdminUser> adminUserList) {
        this.adminUserList = adminUserList;
    }

    public void register() {

        // todo use method from interface

        StandardUser standardUser = new StandardUser();
        AdminUser adminUser = new AdminUser();
        MainPage mainPage = new MainPage();
        LoginPage logInPage = new LoginPage();

        Scanner sc = new Scanner(System.in);
        System.out.println("*************************************");
        System.out.println("You want to register a standard user.");
        System.out.println("Please provide the required details.");
        System.out.println("*************************************");

        //List<String> standardList = standardUser.setStandard();

        // TODO - najlepiej zrobic w petli

        System.out.print("a. Login: ");
        standardUser.setLogin(sc.nextLine());

        System.out.print("b. Password: ");
        standardUser.setPassword(sc.nextLine());

        System.out.print("c. First Name: ");
        standardUser.setFirstName(sc.nextLine());

        System.out.print("d. Last Name: ");
        standardUser.setLastName(sc.nextLine());

        System.out.print("e. Email: ");
        standardUser.setEmail(sc.nextLine());

        System.out.println("Printing standard list:");


//            if (isRegistered() == true) {
//                System.out.println("The user already exists.");
//                mainPage.displayOptions();
//
//            } else {
//        System.out.println("Thank you. New user has been registered.");
//        registrable.registerUser();
//        System.out.println("Now log in using your credentials.");
//        logInPage.logIn();
//    }

}

    boolean checkReg() {
        return false;
    }
}

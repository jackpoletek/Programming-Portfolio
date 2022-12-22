import registerStrategy.RegisterUser;
import user.AdminUser;
import user.User;

public class MainApp {

    public static void main(String[] args) {

        User admin = new AdminUser();
//        Keyboard.createUserObject(admin);
//        System.out.println(admin);
        RegisterUser.registerUser(admin);
        System.out.println(admin);
    }
}

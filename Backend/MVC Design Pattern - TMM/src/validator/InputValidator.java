package validator;

import java.util.HashMap;
import java.util.regex.Pattern;

public class InputValidator {

    private final String logRegEx = "^[A-Za-z0-9+_.-].{4,10}$";
    private final String passRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!?*.@#$%^&+=])(?=\\S+$).{8,15}$";
    private final String nameRegEx = "^[A-Z][a-z]+( [A-Z][a-z]+)?$";
    private final String emRegEx = "^[A-Za-z0-9+_.-]+@(.+)$";

    private HashMap<String, String> regEx = new HashMap<>();
    public HashMap<String, String> getRegEx() {
        return regEx;
    }
    public InputValidator() {
        addRegExOptions();
    }

    public void addRegExOptions() {
        regEx.put("logRegEx", logRegEx);
        regEx.put("passRegEx", passRegEx);
        regEx.put("nameRegEx", nameRegEx);
        regEx.put("emRegEx", emRegEx);
    }
    public boolean isValidLog(String login) {

        if (login == null || !login.matches(logRegEx)) {
            System.out.println("Wrong login. Try again.");
            return false;
        }
        return Pattern.matches(logRegEx, login);
    }

    public boolean isValidPass(String password) {

        if (password == null || !password.matches(passRegEx)) {
            System.out.println("Wrong password. Try again.");
            return false;
        }
        return Pattern.matches(passRegEx, password);
    }

    public boolean isValidName(String name) {

        if (name == null || !name.matches(nameRegEx)) {
            System.out.println("Wrong name. Try again.");
            return false;
        }
        return Pattern.matches(nameRegEx, name);
    }

    public boolean isValidEm(String email) {

        if (email == null || !email.matches(emRegEx)) {
            System.out.println("Wrong email. Try again.");
            return false;
        }
        return Pattern.matches(emRegEx, email);
    }
}

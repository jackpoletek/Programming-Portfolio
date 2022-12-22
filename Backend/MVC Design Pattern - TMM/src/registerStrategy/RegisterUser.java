package registerStrategy;

import user.AdminUser;
import user.User;
import validator.InputValidator;

public class RegisterUser {

    public static void registerUser(User user) {
        if (user instanceof AdminUser) {
            new RegisterAdmin().register(user);

        } else new RegisterStand().register(user);
    }

    public void saveUser(User user) {
        if (user instanceof AdminUser) {
            new RegisterAdmin().save(user);

        } else new RegisterStand().save(user);
    }

    private boolean validateInput(User user) {
        InputValidator inputValidator = new InputValidator();
        return inputValidator.isValidLog(user.getLogin()) && inputValidator.isValidPass(user.getPassword()) && inputValidator.isValidName(user.getFirstName())
                && inputValidator.isValidName(user.getLastName()) && inputValidator.isValidEm(user.getEmail());
    }
}

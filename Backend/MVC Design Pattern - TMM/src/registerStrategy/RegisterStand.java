package registerStrategy;

import user.StandardUser;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class RegisterStand implements RegisterStrategy {

    private List<StandardUser> standardList = new ArrayList<>();

    // BEFORE REGISTERING A NEW USER: SUMMARY
    @Override
    public void register(User user) {

//        if (login == null || password == null) {
//            return null;
//        } else {
//            User user = new StandardUser();
//            user.setLogin(login);
//            user.setPassword(password);
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setEmail(email);

        // todo + store the user:
//            UserStorage.getInstance().setUsers(user);

        save(user);
    }

    @Override
    public void save(User user) {
        standardList.add((StandardUser) user);
    }

    //    public boolean isRegistered(User user) {
//        return userList.stream().anyMatch(user1 -> user1.getLogin().equals(user.getLogin()));
//    }
}

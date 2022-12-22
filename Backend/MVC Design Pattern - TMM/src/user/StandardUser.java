package user;

import registerStrategy.RegisterStand;

import java.util.ArrayList;
import java.util.List;

public class StandardUser extends User {

    private List<User> standardList = new ArrayList<>();

    public List<User> getStandardList() {
        return standardList;
    }
    public void setStandardList(List<User> standardList) {
        this.standardList = standardList;
    }

    public StandardUser() {
        registerStrategy = new RegisterStand();
    }

    @Override
    public String toString() {
        return "StandardUser{} " +
                super.toString();
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

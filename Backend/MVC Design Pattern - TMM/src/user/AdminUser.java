package user;

import registerStrategy.RegisterAdmin;

import java.util.ArrayList;
import java.util.List;

public class AdminUser extends User {

    private List<User> adminList = new ArrayList<>();

    public List<User> getAdminList() {
        return adminList;
    }
    public void setAdminList(List<User> adminList) {
        this.adminList = adminList;
    }

    public AdminUser() {
        registerStrategy = new RegisterAdmin();
    }

    @Override
    public String toString() {
        return "AdminUser{} " +
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

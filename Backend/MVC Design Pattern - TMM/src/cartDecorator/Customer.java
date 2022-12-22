package cartDecorator;

import java.util.Objects;

public class Customer extends Product {

    private int custId;
    private String name;
    private String login;

    public Customer(int custId, String name, String login) {
        super();
        this.custId = custId;
        this.name = name;
        this.login = login;
    }
    public Customer(){}

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return custId == customer.custId && name.equals(customer.name) && login.equals(customer.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, name, login);
    }
}

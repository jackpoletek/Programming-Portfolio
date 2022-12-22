package shoppingCart;

import java.util.Objects;

public class Cart {

    private int custId;
    private int prodId;
    private double price;
    private int quantity;

    public Cart(int custId, int prodId, double price, int quantity) {
        super();
        this.custId = custId;
        this.prodId = prodId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Double.compare(cart.price, price) == 0 && quantity == cart.quantity && custId == cart.custId && prodId == cart.prodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, prodId, price, quantity);
    }
}

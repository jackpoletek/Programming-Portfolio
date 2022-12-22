package shoppingCart;

import java.util.Objects;

public class Product {

    private int prodId;
    private String prodDescription;
    private String category;
    private double price;
    private int stock; // qoh -> quantity on hand

    public Product(int prodId, String prodDescription, String category, double price, int stock) {
        super();
        this.prodId = prodId;
        this.prodDescription = prodDescription;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public Product(){}

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && prodId == product.prodId && prodDescription.equals(product.prodDescription) && category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, prodDescription, category, price, stock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + prodId + '\'' +
                ", name='" + prodDescription + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

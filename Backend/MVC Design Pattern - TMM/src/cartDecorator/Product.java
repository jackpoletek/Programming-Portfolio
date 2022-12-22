package cartDecorator;

import java.util.Objects;

public class Product implements Cart {

    private int prodId;
    private String description;
    private String category;
    private double price;
    private int stock;

    @Override
    public String getProductDescription(int id) {
        String description = "";
        for (Product product : ProductUtility.productList) {
            if (product.getProdId() == id) {
                description = getDescription();
                break;
            }
        }
        return description;
    }

    @Override
    public double getTotalCost() {
        double total = 0;
        for (Product product : ProductUtility.productList) {
            total += product.getPrice();
        }
        return total;
    }

    public Product(int prodId, String description, String category, double price, int stock) {
        super();
        this.prodId = prodId;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && prodId == product.prodId && description.equals(product.description) && category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, description, category, price, stock);
    }
}

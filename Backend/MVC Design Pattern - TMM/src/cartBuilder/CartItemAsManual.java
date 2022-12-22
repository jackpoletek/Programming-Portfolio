package cartBuilder;

import productBuilder.ProductCategory;

public class CartItemAsManual {
    private ProductCategory productCategory;
    private String brand;
    private String description;
    private int quantity;
    private double price;

    public CartItemAsManual(ProductCategory productCategory, String brand, String description, int quantity, double price) {
        this.productCategory = productCategory;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItemAsManual{" +
                "productCategory=" + productCategory +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

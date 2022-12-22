package productBuilder;

public class Product {

    private final ProductCategory productCategory;
    private final String brand;
    private final String description;
    private final int quantity;
    private final double price;

    public Product(ProductCategory productCategory, String brand, String description, int quantity, double price) {
        this.productCategory = productCategory;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productCategory=" + productCategory +
//                ", brand='" + brand + '\'' +
//                ", description='" + description + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }
}

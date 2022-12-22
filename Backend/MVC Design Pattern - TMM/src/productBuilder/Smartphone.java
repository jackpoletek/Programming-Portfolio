package productBuilder;

public class Smartphone extends Product {
    private String operatingSystem;

    public Smartphone(ProductCategory productCategory, String brand, String description, int quantity, double price, String operatingSystem) {
        super(ProductCategory.SMARTPHONE, brand, description, quantity, price);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = "Android";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Smartphone{" +
                "operatingSystem='" + operatingSystem + '\'' +
                "} ";
    }
}

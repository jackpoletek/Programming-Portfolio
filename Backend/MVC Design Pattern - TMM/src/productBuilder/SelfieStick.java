package productBuilder;

public class SelfieStick extends Product {
    private String length;

    public SelfieStick(ProductCategory productCategory, String brand, String description, int quantity, double price, String length) {
        super(productCategory, brand, description, quantity, price);
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = "2m";
    }

    @Override
    public String toString() {
        return super.toString() +
                "SelfieStick{" +
                "length='" + length + '\'' +
                "} ";
    }
}

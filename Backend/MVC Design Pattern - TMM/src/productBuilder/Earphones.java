package productBuilder;

public class Earphones extends Product {
    private String extraFeature;

    public Earphones(ProductCategory productCategory, String brand, String description, int quantity, double price, String extraFeature) {
        super(ProductCategory.EARPHONES, brand, description, quantity, price);
        this.extraFeature = extraFeature;
    }

    public String getExtraFeature() {
        return extraFeature;
    }

    public void setExtraFeature(String extraFeature) {
        this.extraFeature = "Bluetooth";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Earphones{" +
                "extraFeature='" + extraFeature + '\'' +
                "} ";
    }
}

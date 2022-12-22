package productBuilder;

public enum ProductCategory {
    EARPHONES("Earphones"),
    SELFIE_STICK("Selfie Stick"),
    SMARTPHONE("Smartphone");

    public final String productName;

    ProductCategory(String productName) {
        this.productName = productName;
    }

    public String toString() {
        return this.productName;
    }
}

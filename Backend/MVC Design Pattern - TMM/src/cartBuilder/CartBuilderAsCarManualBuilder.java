package cartBuilder;

import productBuilder.*;

public class CartBuilderAsCarManualBuilder implements Builder {
    private ProductCategory productCategory;
    private String brand;
    private String description;
    private int quantity;
    private double price;
//    private Earphones earphones;
//    private SelfieStick selfieStick;
//    private Smartphone smartphone;

    @Override
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public CartItemAsManual addNewProduct() {
        return new CartItemAsManual(productCategory, brand, description, quantity, price);
    }
}

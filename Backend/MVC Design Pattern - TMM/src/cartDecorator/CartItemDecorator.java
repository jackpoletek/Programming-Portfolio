package cartDecorator;

public abstract class CartItemDecorator implements Cart {

    protected Cart cart;
    protected Product product;

    public CartItemDecorator(Cart cart) {
        this.cart = cart;
    }

    public String getProductDescription() {
        return cart.getProductDescription(product.getProdId());
    }

    public double getTotalCost() {
        return cart.getTotalCost();
    }
}

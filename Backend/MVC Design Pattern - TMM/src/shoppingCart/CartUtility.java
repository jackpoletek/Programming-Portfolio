package shoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartUtility {
    
    private static List<Cart> cartList = new ArrayList<>();

    public static List<Cart> getCartList() {
        return cartList;
    }

    public static void setCartList(List<Cart> cartList) {
        CartUtility.cartList = cartList;
    }

    // todo ADD new Product to Cart or update Cart
    public static void addProductToCart(Cart cart) {

        int index = -1;
        Cart temp = null;

        // Check for a matching object
        for (Cart c : cartList) {
            index++;
            if(Objects.equals(c.getCustId(), cart.getCustId()) && c.getProdId() == cart.getProdId()) {
                temp = c;
                break;
            }
        }
        // If there is no matching object, add it to the cartList
        if (temp == null) {
            // Summary before adding a product
            System.out.println("You're about to add the following products to cart: ");
            cartList.add(cart);

        } else {
            // Update the quantity/stock:
            // temp.getQuantity() -> the quantity of existing cart object
            temp.setQuantity(temp.getQuantity() + cart.getQuantity());

            // otherwise, replace the existing object
            cartList.set(index, temp);
            System.out.println("Cart updated");
        }
        // We need to find Product object from product list based on prodId added to cart
        Product p = ProductUtility.findProduct(cart.getProdId());

        // Now we need to decrease the stock for prodId added to cart
        int stockLeft = p.getStock() - cart.getQuantity(); // todo HERE throws NullPointerException
        p.setStock(stockLeft);
    }
}

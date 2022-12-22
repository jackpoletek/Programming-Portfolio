package shoppingCart;

public class CartHandler {

    public static void viewCartItem() {
        System.out.println("Product Name---Price---Quantity---Total");
        // fetch cartList from CartUtility
        for (Cart cart : CartUtility.getCartList()) {
            // print Product id, quantity,price, total -> price*quantity
            double price = ProductUtility.getProductPrice(cart.getProdId());
            String prodName = ProductUtility.getProductName(cart.getProdId());
            double total = cart.getPrice()*cart.getQuantity();
            System.out.println(prodName+ "-" + cart.getQuantity() + "-" + cart.getPrice() + "-" + "Total: " + total);
        }
        System.out.println();
    }

    public static void deleteCart(Customer customer) {
        Cart temp = null;
        for (Cart cart : CartUtility.getCartList()) {
            if (cart.getCustId() == customer.getCustId()) {
                temp = cart;
                break;
            }
        } CartUtility.getCartList().remove(temp);
        System.out.println("Cart removed.");
    }

    public static void createCartAndAddToList(Customer customer, Product product) {
        Cart cart = new Cart(customer.getCustId(), product.getProdId(), product.getPrice(), product.getStock());
        CartUtility.addProductToCart(cart);
    }
}

package shoppingCart;

public class ShowProducts {

    public static void showProducts() {

        for (Product product : ProductUtility.getProductList()) {
            System.out.println(product);
        }
    }
}

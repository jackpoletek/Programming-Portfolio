package shoppingCart;

import java.util.ArrayList;
import java.util.List;

// contains useful methods
public class ProductUtility {

    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
    }

    // static block
    static {
        productList.add(new Product(1, "Acer-L8-202", "laptop", 299.99, 20));
        productList.add(new Product(2, "S8-Galaxy-202", "smartphone", 198, 2));
        productList.add(new Product(3, "Selfie-S77/333", "selfie stick", 100.99, 55));
        productList.add(new Product(4, "64GB-100M", "memory", 29.97, 100));
    }

    public static String getProductName(int id) {

        String name = "";

        for (Product product : productList) {
            if (product.getProdId() == id) {
                name = product.getProdDescription();
                break;
            }
        }
        return name;
    }

    public static double getProductPrice(int id) {

        double price = 0;

        for (Product product : productList) {
            if (product.getProdId() == id) {
                price = product.getPrice();
                break;
            }
        }
        return price;
    }

    public static Product findProduct(int id) {

        Product temp = null;

        for (Product product : productList) {
            if (product.getProdId() == id) {
                temp = product;
                break;
            }
        }
        return temp;
    }
}

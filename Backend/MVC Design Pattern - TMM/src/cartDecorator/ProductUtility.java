package cartDecorator;

import java.util.ArrayList;
import java.util.List;

public class ProductUtility {

    public static List<Product> productList = new ArrayList<>();

    // static block
    static {
        productList.add(new Product(1, "Laptop Acer-L8-202", "laptop", 395.99, 20));
        productList.add(new Product(2, "Samsung Phone S8-Galaxy-202", "smartphone", 198, 2));
        productList.add(new Product(3, "Selfie Stick S77/333", "selfie stick", 100.99, 12));
        productList.add(new Product(4, "Pendrive Gula-64GB-100M", "memory", 29.97, 10));
    }

    public static void showProducts() {

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static String getProductName(int id) {
        String name = "";

        for (Product product : productList) {
            if (product.getProdId() == id) {
                name = product.getDescription();
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

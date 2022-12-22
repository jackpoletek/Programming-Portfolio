package shoppingCart;

import java.util.Scanner;

public class Keyboard {

    private static Customer customer = null;
    private static Product product = new Product();
    private static Scanner sc = new Scanner(System.in);

    public static void readProductDetails() {
        int productId = product.getProdId();
        int quantity = product.getStock();

        System.out.println("Enter the product id:");
        productId = sc.nextInt();
        System.out.println("How many products do you need?");
        quantity = sc.nextInt();
    }

    public static void readCustomerDetails() {
        System.out.println("Enter customer id: ");
        int id = sc.nextInt();
        System.out.println("Enter customer name: ");
        String name = sc.next();
        System.out.println("Enter customer login: ");
        String login = sc.next();

        customer = new Customer(id, name, login);
    }

    public static void enterChoice() {

        int choice = 0;

        do {
            ShowProducts.showProducts();
            System.out.println("1. Add Product To Cart");
            System.out.println("2. View Cart Items");
            System.out.println("3. Delete Cart");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (customer == null) {
                        readCustomerDetails();
                    }
                    ShowProducts.showProducts();
                    readProductDetails();
                    CartHandler.createCartAndAddToList(customer, product);
                    break;
                case 2:
                    CartHandler.viewCartItem();
                    break;
                case 3:
                    CartHandler.deleteCart(customer);
                    break;
                default:
                    System.out.println("Thanks!");
                    break;
            }

        } while (choice < 4);
    }
}

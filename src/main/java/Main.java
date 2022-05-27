import Product.Product;
import Product.ProductController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Product milk = new Product();
//        Product sugar = new Product(001, "Sugar", 12, 100, "Sweetened Sugar");

        ProductController productController = new ProductController();
//        productController.createTable(); // creating table
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the supermarket.");

        String input = "";

        do{
            System.out.println("""
                    What would you like to do?
                    1. add product
                    2. list products
                    3. update product
                    4. find product by name
                    5. find by product id
                    6. delete by id
                    """);

            input = scanner.nextLine();

            switch (input){
                case "quit":
                    System.out.println("Closing application");
                    break;
                case "1":
                    productController.createProduct();
                    break;
                case "2":
                    productController.listProduct();
                    break;
                case "3":
                    productController.updateProduct();
                    break;
                case "4":
                    productController.findProductsByName();
                    break;
                case "5":
                    productController.findProductByID();
                    break;
                case "6":
                    productController.deleteById();
                default:
                    System.out.println("Please enter a valid value.");
                    break;
            }
        }while(!input.equalsIgnoreCase("quit"));
    }
}

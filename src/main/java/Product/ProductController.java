package Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    ProductRepository productRepository = new ProductRepository();
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    public void createTable(){
        try{
            productRepository.createTable();
            System.out.println("Product table created successfully.");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Product creation failed.");
        }
    }

    public void createProduct(){
        try {
            System.out.println("Add product to supermarket");

            System.out.print("Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Product price: ");
            double price = intScanner.nextDouble();

            System.out.print("Quantity: ");
            int quantity = intScanner.nextInt();

            System.out.print("Description: ");
            String description = scanner.nextLine();

            Product product = new Product(name, price, quantity, description);

            productRepository.create(product);
            System.out.println(name + " added to the supermarket.");

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to add product to supermarket.");
        }
    }

    public void listProduct(){
        try{
            System.out.println(productRepository.getAll());
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot receive products from database at the moment");
        }
    }

    public void updateProduct(){
        try{
            System.out.println("Update product in supermarket");
            System.out.println("Enter product ID to update");
            int id = intScanner.nextInt();

            // find product from the database with ID provide by USer
            Product product = productRepository.findById(id);

            // read new product name frm user and set new name to product
            System.out.println("Name: (" + product.name + "): ");
            product.name = scanner.nextLine();

            System.out.println("Price (" + product.price + "): ");
            product.price = intScanner.nextDouble();

            System.out.println("Description (" + product.description + "): ");
            product.description = scanner.nextLine();

            productRepository.update(product);
            System.out.println(product.name + " updated successfully.");


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update product.");
        }
    }

    public void findProductsByName(){
        try {
            System.out.println("Find products by Name");

            String name = scanner.nextLine();
            ArrayList<Product> products = productRepository.getProductByName(name);
            System.out.println(products);
        } catch (SQLException e) {
            e.printStackTrace(); // prints information about the error
            System.out.println("Error finding product.");
        }
    }

    public void findProductByID(){
        try{
            System.out.println("Find product by Id");
            int id = intScanner.nextInt(); // read product id from user
            Product products = productRepository.findById(id); //call method that interacts with DB to find by ID
            System.out.println(products); // print product
        } catch (SQLException e) {
            e.printStackTrace(); // prints the information about error
            System.out.println("Error finding product.");
        }
    }

    public void deleteById(){
        System.out.print("Delete product by id.");

        System.out.println("Input product id.");
        int id = intScanner.nextInt();

        try{
            productRepository.delete(id);
            System.out.println("Product deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot delete product by this id: " + id);
        }
    }

//    public String createProduct(Product product){
//        try {
//            // add product in database
//            return "Product added successfully";
//        } catch (SQLException e){
//            e.printStackTrace();
//            return "Error Creating a Product.";
//        }
//    }
}

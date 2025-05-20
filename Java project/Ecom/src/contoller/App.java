package contoller;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import dao.DaoProduct;
import dao.DaoProductImpl;
import model.Product;
import model.Purchase;
import dao.DaopurchaseImpl;

import dao.DaoPurchase;

public class App {
    public static void main(String[] args) {
    	
            Scanner sc = new Scanner(System.in);
            DaoProduct service = new DaoProductImpl();
            DaoPurchase service1 = new DaopurchaseImpl();

            System.out.println("1. Insert Product");
            System.out.println("2. Get Products by Category");
            System.out.println("3. Insert Purchase");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Category ID: ");
                    int catId = sc.nextInt();
                    service.insertProduct(new Product(0, name, price, catId));
                    
                    break;
                case 2:
                    System.out.print("Enter Category ID: ");
                    int cid = sc.nextInt();
                    List<Product> list =service.getProductsByCategoryId(cid);
                    list.forEach(p -> System.out.println(p.getProductId() + " " + p.getName() + " " + p.getPrice()));
                    break;
                case 3:
                    System.out.print("Customer ID: ");
                    int custId = sc.nextInt();
                    System.out.print("Product ID: ");
                    int prodId = sc.nextInt();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    service1.insertPurchase(new Purchase(0, custId, prodId, qty, LocalDate.now()));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            sc.close();
            
        }
    
    }


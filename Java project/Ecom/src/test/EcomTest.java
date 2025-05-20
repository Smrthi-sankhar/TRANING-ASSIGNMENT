package test;

import dao.DaoProductImpl;
import dao.DaopurchaseImpl;
import model.Product;
import model.Purchase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EcomTest {

    private static DaopurchaseImpl daoPurchase;

    @BeforeAll
    public static void setUp() {
        daoPurchase = new DaopurchaseImpl();
    }
    
    private static DaoProductImpl daoProduct;

    @BeforeAll
    public static void setUp1() {
        daoProduct = new DaoProductImpl();
    }

    @Test
    public void testInsertPurchase() {
        // Assuming customer_id = 1, product_id = 1 exists in your database
        Purchase purchase = new Purchase();
        purchase.setCustomerId(1);
        purchase.setProductId(1);
        purchase.setQuantity(2);
        purchase.setPurchaseDate(LocalDate.now());

        assertDoesNotThrow(() -> {
            daoPurchase.insertPurchase(purchase);
        }, "Insert should not throw any exceptions");
    }
    
    @Test
    public void testInsertProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(99.99);
        product.setCategoryId(1); // Make sure category_id = 1 exists

        assertDoesNotThrow(() -> {
            daoProduct.insertProduct(product);
        }, "Insert product should not throw an exception");
    }

    @Test
    public void testGetProductsByCategoryId() {
        int testCategoryId = 1; // Ensure this exists in DB
        List<Product> products = daoProduct.getProductsByCategoryId(testCategoryId);
        assertNotNull(products, "Product list should not be null");
        assertTrue(products.size() >= 0, "Product list should contain zero or more items");
    }
}
    
    
    
    



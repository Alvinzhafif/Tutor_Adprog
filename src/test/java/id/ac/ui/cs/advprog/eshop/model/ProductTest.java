package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    Product product;

    @BeforeEach
    void setup() {
        this.product = new Product();
        this.product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }

    @Test
    void testGetProductId() {
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.product.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("Sampo Cap Bambang", this.product.getProductName());
    }

    @Test
    void testGetProductQuantity() {
        assertEquals(100, this.product.getProductQuantity());
    }

    // Additional test cases to improve coverage

    @Test
    void testSetProductId() {
        String newProductId = "new-product-id";
        this.product.setProductId(newProductId);
        assertEquals(newProductId, this.product.getProductId());
    }

    @Test
    void testSetProductName() {
        String newProductName = "New Product Name";
        this.product.setProductName(newProductName);
        assertEquals(newProductName, this.product.getProductName());
    }

    @Test
    void testSetProductQuantity() {
        int newQuantity = 50;
        this.product.setProductQuantity(newQuantity);
        assertEquals(newQuantity, this.product.getProductQuantity());
    }
}


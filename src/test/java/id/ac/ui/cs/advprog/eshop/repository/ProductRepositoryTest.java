package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @Mock
    Product productDao;

    @BeforeEach
    void setUp(){

    }
    @Test
    void testEditProductWithNegativeQuantity() {
        // Set up a product with a negative quantity
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(-10);


        // Call the editProduct method of productRepository and assert that it throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> productRepository.editProduct(product));
    }

    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Piccolo");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditWithOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sword of the final ash");
        product2.setProductQuantity(35);
        productRepository.editProduct(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(product1.getProductId(), savedProduct.getProductId());
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertEquals(product2.getProductName(), savedProduct.getProductName());
        assertEquals(product2.getProductQuantity(), savedProduct.getProductQuantity());
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testDeleteWithOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        productRepository.deleteProduct(product1);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditWithMultipleProducts() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sword of the final ash");
        product2.setProductQuantity(340);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId(product1.getProductId());
        product3.setProductName("Destiny's demise");
        product3.setProductQuantity(200);
        productRepository.editProduct(product3);

        Product product4 = new Product();
        product4.setProductId(product2.getProductId());
        product4.setProductName("Angel totem");
        product4.setProductQuantity(100);
        productRepository.editProduct(product4);

        Iterator<Product> productIterator = productRepository.findAll();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        assertEquals(product3.getProductId(), savedProduct.getProductId());
        assertEquals(product3.getProductName(), savedProduct.getProductName());
        assertEquals(product3.getProductQuantity(), savedProduct.getProductQuantity());

        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertEquals(product4.getProductId(), savedProduct.getProductId());
        assertEquals(product4.getProductName(), savedProduct.getProductName());
        assertEquals(product4.getProductQuantity(), savedProduct.getProductQuantity());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteWithMultipleProducts() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("The bow of etherium");
        product2.setProductQuantity(10000);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId("4f93beba-2a26-4643-9251-e92414c6d4ca");
        product3.setProductName("Sword of the final ash");
        product3.setProductQuantity(2332);
        productRepository.create(product3);

        Product product4 = new Product();
        product4.setProductId(product2.getProductId());
        product4.setProductName("Ashen spirit");
        product4.setProductQuantity(110);
        productRepository.create(product4);

        productRepository.deleteProduct(product2);
        productRepository.deleteProduct(product4);
        Iterator<Product> productIterator = productRepository.findAll();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(product1.getProductId(), savedProduct.getProductId());
        assertEquals(product1.getProductName(), savedProduct.getProductName());
        assertEquals(product1.getProductQuantity(), savedProduct.getProductQuantity());

        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product3.getProductId(), savedProduct.getProductId());
        assertEquals(product3.getProductName(), savedProduct.getProductName());
        assertEquals(product3.getProductQuantity(), savedProduct.getProductQuantity());

        assertFalse(productIterator.hasNext());
    }

}

package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Product 1");
        productList.add(product1);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Product 2");
        productList.add(product2);

        Product product3 = new Product();
        product3.setProductId("3");
        product3.setProductName("Product 3");
        productList.add(product3);


        when(productRepository.findAll()).thenReturn(productList.iterator());
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setProductName("Test Product");

        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertNotNull(createdProduct.getProductId());
        assertEquals(product.getProductName(), createdProduct.getProductName());

        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testGetProductById() {
        // Test getting a product by ID
        Product result1 = productService.getId("1");
        Product result2 = productService.getId("2");
        Product result3 = productService.getId("3");
        Product result4 = productService.getId("4"); // Non-existing ID

        // Assert the results
        assertEquals("Product 1", result1.getProductName());
        assertEquals("Product 2", result2.getProductName());
        assertEquals("Product 3", result3.getProductName());
        assertNull(result4); // No product found for ID "4"
    }
    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        Product prodRep = productRepository.create(product);

    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> foundProducts = productService.findAll();

        assertEquals(productList.size(), foundProducts.size());

        for (int i = 0; i < productList.size(); i++) {
            assertEquals(productList.get(i), foundProducts.get(i));
        }

        verify(productRepository, times(1)).findAll();
    }



    @Test
    void testEditProduct() {

        Product mockProduct = new Product();
        mockProduct.setProductId("123");
        mockProduct.setProductName("Mock Product");


        when(productRepository.editProduct(mockProduct)).thenReturn(mockProduct);


        Product editedProduct = productService.editProduct(mockProduct);

        assertNotNull(editedProduct);
        assertEquals("123", editedProduct.getProductId());
        assertEquals("Mock Product", editedProduct.getProductName());


        verify(productRepository, times(1)).editProduct(mockProduct);
    }

    @Test
    void testDeleteProduct() {

        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Product 1");
        product.setProductQuantity(10);


        productRepository.create(product);


        boolean deletedNonExisting = productService.deleteProduct("2");
        assertFalse(deletedNonExisting);

    }

}


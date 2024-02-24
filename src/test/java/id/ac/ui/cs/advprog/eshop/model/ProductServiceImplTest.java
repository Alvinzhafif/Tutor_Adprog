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
        Product product1 = new ConcreteProduct();
        product1.setId("1");
        product1.setName("Product 1");
        productList.add(product1);

        Product product2 = new ConcreteProduct();
        product2.setId("2");
        product2.setName("Product 2");
        productList.add(product2);

        Product product3 = new ConcreteProduct();
        product3.setId("3");
        product3.setName("Product 3");
        productList.add(product3);


        when(productRepository.findAll()).thenReturn(productList.iterator());
    }

    @Test
    void testCreate() {
        ConcreteProduct product = new ConcreteProduct();
        product.setProductName("Test Product");

        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertNotNull(createdProduct.getId());
        assertEquals(product.getProductName(), createdProduct.getName());

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
        assertEquals("Product 1", result1.getName());
        assertEquals("Product 2", result2.getName());
        assertEquals("Product 3", result3.getName());
        assertNull(result4); // No product found for ID "4"
    }
    @Test
    void testCreateAndFind(){
        Product product = new ConcreteProduct();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Sampo Cap Bambang");
        Product prodRep = productRepository.create(product);

    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new ConcreteProduct());
        productList.add(new ConcreteProduct());

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

        ConcreteProduct mockProduct = new ConcreteProduct();
        mockProduct.setId("123");
        mockProduct.setName("Mock Product");


        when(productRepository.editProduct(mockProduct)).thenReturn(mockProduct);


        Product editedProduct = productService.editProduct(mockProduct);

        assertNotNull(editedProduct);
        assertEquals("123", editedProduct.getId());
        assertEquals("Mock Product", editedProduct.getName());


        verify(productRepository, times(1)).editProduct(mockProduct);
    }

    @Test
    void testDeleteProduct() {

        Product product = new ConcreteProduct();
        product.setId("1");
        product.setName("Product 1");
        product.setQuantity(10);


        productRepository.create(product);


        boolean deletedNonExisting = productService.deleteProduct("2");
        assertFalse(deletedNonExisting);

    }

}


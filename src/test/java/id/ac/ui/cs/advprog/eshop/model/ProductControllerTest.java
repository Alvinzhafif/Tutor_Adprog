package id.ac.ui.cs.advprog.eshop.model;


import id.ac.ui.cs.advprog.eshop.controller.ProductController;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService service;

    @Mock
    private Model model;

    @MockBean
    private ProductServiceImpl productService;

    @Nested
    @DisplayName("GET Requests")
    class GetRequests {
        @Test
        void testCreateProductPage() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/product/create"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("createProduct"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("product"));
        }

        @Test
        void testProductListPage() throws Exception {
            List<Product> products = new ArrayList<>();
            when(productService.findAll()).thenReturn(products);

            mockMvc.perform(MockMvcRequestBuilders.get("/product/list"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("productList"))
                    .andExpect(MockMvcResultMatchers.model().attribute("products", products));
        }

        @Test
        void testEditPage() throws Exception {
            Product product = new Product();
            product.setProductId("123");
            when(productService.getId("123")).thenReturn(product);

            mockMvc.perform(MockMvcRequestBuilders.get("/product/edit/123"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("EditProduct"))
                    .andExpect(MockMvcResultMatchers.model().attribute("product", product));
        }
        @Test
        void testCreateProductPost() {
            // Create a sample product
            Product product = new Product();
            product.setProductId("123");
            product.setProductName("Test Product");
            product.setProductQuantity(10);

            // Mock the service method
            when(service.create(product)).thenReturn(product);

            // Call the method under test
            String redirectUrl = productController.createProductPost(product, model);

            // Verify that the service method was called with the correct product
            verify(service).create(product);

            // Verify that the method returns the correct redirect URL
            assertEquals("redirect:list", redirectUrl);
        }
        @Test
        void testEdit() {
            // Create a sample product
            Product product = new Product();
            product.setProductId("123");
            product.setProductName("Edited Product");
            product.setProductQuantity(20);

            // Call the method under test
            String redirectUrl = productController.edit(product);

            // Verify that the service method was called with the correct product
            verify(service).editProduct(product);

            // Verify that the method returns the correct redirect URL
            assertEquals("redirect:list", redirectUrl);
        }
    }

    @Nested
    @DisplayName("POST Requests")
    class PostRequests {
        @Test
        void testDeleteProduct() throws Exception {
            // Assuming you have multiple products to delete
            List<String> productIdsToDelete = List.of("123", "456", "789");

            // Mock the deletion of each product
            for (String productId : productIdsToDelete) {
                mockMvc.perform(MockMvcRequestBuilders.get("/product/delete/" + productId))
                        .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                        .andExpect(MockMvcResultMatchers.redirectedUrl("/product/list"));
            }
        }
    }
}



package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.ConcreteProduct;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepositoryRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(ConcreteProduct product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productRepository.create(product);
        return product;
    }



    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product getId(String id) {
        Product product = null;
        Iterator<Product> productIterator = productRepository.findAll();

        while(productIterator.hasNext()) {
            Product product1 = productIterator.next();

            if (product1.getId().equals(id)) {
                product = product1;
                break;
            }
        }
        return product;
    }

    @Override
    public boolean deleteProduct(String productId) {
        Product id = getId(productId);

        return id != null && productRepository.deleteProduct(id);
    }

    @Override
    public Product editProduct(ConcreteProduct product) {
        productRepository.editProduct(product);
        return product;
    }
}
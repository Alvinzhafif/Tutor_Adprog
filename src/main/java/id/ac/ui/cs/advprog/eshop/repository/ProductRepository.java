package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

@Repository
public class ProductRepository {

        ProductRepositoryRead repository = new ProductRepositoryRead();



        public Product create(Product product){
            repository.productData.add(product);
            return product;
        }


        public Iterator<Product> findAll () {
            return repository.productData.iterator();
        }

        public boolean deleteProduct (Product product){
            return repository.productData.remove(product);
        }

        public Product editProduct (Product product){
            if (product.getQuantity() < 0) {
                throw new IllegalArgumentException("Product quantity cannot be negative");
            }

            for (int i = 0; i < repository.productData.size(); i++) {
                Product item = repository.productData.get(i);
                if (item.getId().equals(product.getId())) {
                    return repository.productData.set(i, product);
                }
            }

            return product;
        }
    }

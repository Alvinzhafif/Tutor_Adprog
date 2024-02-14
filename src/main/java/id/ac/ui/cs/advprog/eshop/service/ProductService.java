package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface ProductService {
     Product create(Product product);
     List<Product> findAll();
     Product getId(String id);
     Product editProduct(Product product);
     boolean deleteProduct(String id);

}
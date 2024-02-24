package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.ConcreteProduct;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface ProductService {

     Product create(ConcreteProduct product);

     List<Product> findAll();
     Product getId(String id);
     Product editProduct(ConcreteProduct product);
     boolean deleteProduct(String id);

}
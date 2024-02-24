    package id.ac.ui.cs.advprog.eshop.repository;

    import id.ac.ui.cs.advprog.eshop.model.Product;
    import org.springframework.stereotype.Repository;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;

    @Repository
    public class ProductRepositoryRead {

        List<Product> productData = new ArrayList<>();

        public Iterator<Product> findAll() {
            return productData.iterator();
        }
    }

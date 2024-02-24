package id.ac.ui.cs.advprog.eshop.model;

// Define a Product interface
public interface Product {
    String getId();
    void setId(String productId);

    String getName();
    void setName(String productName);

    int getQuantity();
    void setQuantity(int productQuantity);
}


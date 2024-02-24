package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

// Modify the Product class to implement the Product interface
@Getter
@Setter
public class ConcreteProduct implements Product {
    private String productId;
    private String productName;
    private int productQuantity;

    // Constructors
    public ConcreteProduct() {
    }

    public ConcreteProduct(String productId, String productName, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    // Implement methods from Product interface
    @Override
    public String getId() {
        return this.getProductId();
    }

    @Override
    public void setId(String productId) {
        this.setProductId(productId);
    }

    @Override
    public String getName() {
        return this.getProductName();
    }

    @Override
    public void setName(String productName) {
        this.setProductName(productName);
    }

    @Override
    public int getQuantity() {
        return this.getProductQuantity();
    }

    @Override
    public void setQuantity(int productQuantity) {
        this.setProductQuantity(productQuantity);
    }
}

package id.ac.ui.cs.advprog.eshop.model;

import lombok.Setter;

import java.util.Map;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    @Setter
    private String paymentStatus;
    private Map<String, String> paymentData;


    public Payment(String id, String method, Map<String, String> paymentData, String status) {
        this.paymentId = id;
        this.paymentMethod = method;
        this.paymentData = paymentData;
        this.paymentStatus = status;
    }

    public String getId() {
        return paymentId;
    }

    public String getMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return paymentStatus;
    }

    public Map<String, String> getPaymentData() {
        return paymentData;
    }


}

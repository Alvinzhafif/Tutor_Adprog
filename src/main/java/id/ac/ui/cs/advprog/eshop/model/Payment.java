package id.ac.ui.cs.advprog.eshop.model;

import lombok.Setter;

import java.util.Map;

public class Payment {
    private String id;
    private String method;
    @Setter
    private String status;
    private Map<String, String> paymentData;


    public Payment(String id, String method, Map<String, String> paymentData, String status) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getPaymentData() {
        return paymentData;
    }


}

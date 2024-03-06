package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentRepository {
    private final Map<String, Payment> paymentMap;

    public PaymentRepository() {
        this.paymentMap = new HashMap<>();
    }

    public Payment savePayment(Payment payment) {
        paymentMap.put(payment.getId(), payment);
        return payment;
    }

    public Payment findPaymentById(String id) {
        return paymentMap.get(id);
    }

    public List<Payment> findAllPayments() {
        return new ArrayList<>(paymentMap.values());
    }
}


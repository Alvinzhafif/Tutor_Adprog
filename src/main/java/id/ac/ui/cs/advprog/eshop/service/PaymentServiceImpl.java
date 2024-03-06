package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        if (paymentRepository.findById(payment.getId()) == null) {
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public void updateStatus(String paymentId, String status) {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }

        Payment payment = paymentRepository.findById(paymentId);
        if (payment != null) {
            payment.setPaymentStatus(status);
            paymentRepository.save(payment);
        } else {
            throw new IllegalArgumentException("Payment not found with id: " + paymentId);
        }
    }

    private boolean isValidStatus(String status) {
        return status != null && (status.equals("SUCCESS") || status.equals("REJECTED"));
    }

    @Override
    public Payment findById(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public String validateVoucherCode(String voucherCode) {
        if (isValidVoucherCode(voucherCode)) {
            return "SUCCESS";
        } else {
            return "REJECTED";
        }
    }

    private boolean isValidVoucherCode(String voucherCode) {
        if (voucherCode == null || voucherCode.length() != 16 || !voucherCode.startsWith("ESHOP")) {
            return false;
        }

        int digitCount = 0;
        for (int i = 5; i < voucherCode.length(); i++) {
            if (Character.isDigit(voucherCode.charAt(i))) {
                digitCount++;
            }
        }

        return digitCount >= 8;
    }

    public boolean isBankTransferPaymentValid(Map<String, String> paymentData) {
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("referenceCode");

        return bankName != null && !bankName.isEmpty() &&
                referenceCode != null && !referenceCode.isEmpty();
    }




}

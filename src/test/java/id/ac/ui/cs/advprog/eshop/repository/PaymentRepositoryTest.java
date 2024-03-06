package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PaymentRepositoryTest {

    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();

        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        payments = new ArrayList<>();
        Payment payment = new Payment("1", "voucherCode", paymentData, "SUCCESS");
        Payment payment2 = new Payment("2", "voucherCode", paymentData, "SUCCESS");
        Payment payment3 = new Payment("3", "voucherCode", paymentData, "SUCCESS");
        payments.add(payment);
        payments.add(payment2);
        payments.add(payment3);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.savePayment(payment);

        Payment findResult = paymentRepository.findPaymentById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
    }

    @Test
    void testSaveUpdate() {
        Payment payment = payments.get(1);
        paymentRepository.savePayment(payment);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getPaymentData(), payment.getStatus());
        Payment result = paymentRepository.savePayment(newPayment);

        Payment findResult = paymentRepository.findPaymentById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
        assertEquals(payment.getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdFound() {
        for(Payment payment: payments){
            paymentRepository.savePayment(payment);
        }

        Payment findResult = paymentRepository.findPaymentById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getPaymentData(), findResult.getPaymentData());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for(Payment payment: payments){
            paymentRepository.savePayment(payment);
        }

        Payment findResult = paymentRepository.findPaymentById("MEOW");
        assertNull(findResult);


    }

    @Test
    void testFindAll() {
        for(Payment payment: payments){
            paymentRepository.savePayment(payment);
        }

        List<Payment> paymentList = paymentRepository.findAllPayments();
        assertEquals(3, paymentList.size());
    }
}

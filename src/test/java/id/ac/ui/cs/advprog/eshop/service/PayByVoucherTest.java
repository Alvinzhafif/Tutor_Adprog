package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import id.ac.ui.cs.advprog.eshop.service.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PayByVoucherTest{

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    @Test
    void testValidateVoucherCodeWithValidCode() {
        String voucherCode = "ESHOP1234ABC5678";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", voucherCode);
        Payment payment = new Payment("1", "voucherCode", paymentData, "SUCCESS");

        String status = paymentService.validatePaymentVoucherCode(payment.getPaymentData().get("voucherCode"));

        assertEquals("SUCCESS", status);
    }

    @Test
    void testValidateVoucherCodeWithInvalidCode() {

        String voucherCode = "INVALID";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", voucherCode);
        Payment payment = new Payment("2", "voucherCode", paymentData, "SUCCESS");

        String status = paymentService.validatePaymentVoucherCode(payment.getPaymentData().get("voucherCode"));

        assertEquals("REJECTED", status);
    }

    @Test
    void testValidateVoucherCodeWithInvalidNumberCode() {
        String voucherCode = "ESHOP123KOABC578";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", voucherCode);
        Payment payment = new Payment("1", "voucherCode", paymentData, "SUCCESS");

        String status = paymentService.validatePaymentVoucherCode(payment.getPaymentData().get("voucherCode"));

        assertEquals("REJECTED", status);
    }
}

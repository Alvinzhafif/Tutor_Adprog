package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import id.ac.ui.cs.advprog.eshop.service.PaymentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PayByBankTest {

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    @Test
    void testIsBankTransferPaymentValidWithValidData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        paymentData.put("referenceCode", "123456");

        boolean isValid = paymentService.isBankTransferPaymentValid(paymentData);

        assertEquals(true, isValid);
    }

    @Test
    void testIsBankTransferPaymentValidWithMissingBankName() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("referenceCode", "123456");

        boolean isValid = paymentService.isBankTransferPaymentValid(paymentData);

        assertEquals(false, isValid);
    }

    @Test
    void testIsBankTransferPaymentValidWithMissingReferenceCode() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");

        boolean isValid = paymentService.isBankTransferPaymentValid(paymentData);

        assertEquals(false, isValid);
    }

    @Test
    void testIsBankTransferPaymentValidWithEmptyBankNameAndReferenceCode() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "");
        paymentData.put("referenceCode", "");

        boolean isValid = paymentService.isBankTransferPaymentValid(paymentData);

        assertEquals(false, isValid);
    }
}

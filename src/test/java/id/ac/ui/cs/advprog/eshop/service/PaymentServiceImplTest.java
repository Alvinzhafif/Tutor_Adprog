package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    List<Payment> payments;

    @BeforeEach
    void setUp() {
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
    void testCreatePayment() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).savePayment(payment);

        Payment result = paymentService.createPayment(payment);
        verify(paymentRepository, times(1)).savePayment(payment);
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testCreatePaymentIfAlreadyExist() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findPaymentById(payment.getId());

        assertNull(paymentService.createPayment(payment));
        verify(paymentRepository, times(0)).savePayment(payment);
    }

    @Test
    void testUpdateStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> paymentService.updateStatus("paymentId", "MEOW"));

        verify(paymentRepository, never()).savePayment(any(Payment.class));
    }


    @Test
    void testUpdateStatusInvalidPaymentId() {
        doReturn(null).when(paymentRepository).findPaymentById("zczc");

        assertThrows(IllegalArgumentException.class,
                () -> paymentService.updateStatus("zczc", "SUCCESS"));
    }

    @Test
    void testUpdateStatusWhenPaymentExists() {

        String paymentId = "1";
        String status = "SUCCESS";
        Payment payment = new Payment(paymentId, "voucherCode", null, null);
        doReturn(payment).when(paymentRepository).findPaymentById(paymentId);


        paymentService.updateStatus(paymentId, status);


        assertEquals(status, payment.getStatus());
        verify(paymentRepository, times(1)).savePayment(payment);
    }

    @Test
    void testUpdateStatusWhenPaymentNotFound() {

        String paymentId = "1";
        String status = "SUCCESS";
        doReturn(null).when(paymentRepository).findPaymentById(paymentId);


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            paymentService.updateStatus(paymentId, status);
        });

        assertEquals("Payment not found with id: " + paymentId, exception.getMessage());
        verify(paymentRepository, never()).savePayment(any());
    }

    @Test
    void testFindByIdIfIdFound() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findPaymentById(payment.getId());

        Payment result = paymentService.findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        doReturn(null).when(paymentRepository).findPaymentById("zczc");
        assertNull(paymentService.findById("zczc"));
    }

    @Test
    void testFindAll() {

        List<Payment> results = paymentService.findAll();
        assertTrue(results.isEmpty());
    }
}

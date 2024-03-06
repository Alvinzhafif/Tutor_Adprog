package id.ac.ui.cs.advprog.eshop.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PaymentTest{

    private Map<String, String> voucherData;
    @BeforeEach
    void setUp() {
        voucherData = new HashMap<>();
        voucherData.put("voucherCode", "ESHOP1234ABC5678");

    }

    @Test
    void testCreatePaymentVoucher() {
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "voucherCode", voucherData, "SUCCESS");
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals(voucherData, payment.getPaymentData());
    }

    @Test
    void testCreatePaymentSuccess() {
        Map<String, String> newData = new HashMap<>();
        newData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "voucherCode", newData, "SUCCESS");
        payment.setPaymentStatus("SUCCESS");
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", payment.getId());
        assertEquals("ESHOP1234ABC5678", voucherData.get("voucherCode"));
        assertEquals("voucherCode", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentFail() {
        Map<String, String> newData = new HashMap<>();
        newData.put("voucherCode", "MEOW");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "voucherCode", newData, "REJECTED");
        payment.setPaymentStatus("REJECTED");
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", payment.getId());
        assertNotEquals("ESHOP1234ABC5678", newData.get("voucherCode"));
        assertEquals("voucherCode", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
    }
}



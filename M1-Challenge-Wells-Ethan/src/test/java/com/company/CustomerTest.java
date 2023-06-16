package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
        customer.setId(1);
        customer.setName("Ethan");
        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setCharge(10);
        accountRecord.setChargeDate("01-29-2001");
        customer.getCharges().add(accountRecord);
    }

    @Test
    void getBalance() {
        assertEquals(10, customer.getBalance());
    }

    @Test
    void testToString() {
        assertEquals("1 Ethan 10", customer.toString());
    }

}
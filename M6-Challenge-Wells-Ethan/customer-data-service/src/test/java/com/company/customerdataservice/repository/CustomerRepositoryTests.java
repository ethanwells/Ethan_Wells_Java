package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTests {
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldAddCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ethan");
        customer.setLastName("Wells");
        customer.setAddress1("788 Spring Street");
        customer.setAddress2("100 Grey Street");
        customer.setCity("Daytona");
        customer.setState("Florida");
        customer.setPostalCode("12345");
        customer.setCountry("USA");
        customer.setPhone("404-123-1432");
        customer.setEmail("testemail@gmail.com");
        customer.setCompany("Netflix");

        // Act
        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        // Assert
        assertEquals(customer, customer1.get()); // Compare customers
    }

    @Test
    public void shouldGetCustomerById() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setFirstName("Ethan");
        customer1.setLastName("Wells");
        customer1.setAddress1("788 Spring Street");
        customer1.setAddress2("100 Grey Street");
        customer1.setCity("Daytona");
        customer1.setState("Florida");
        customer1.setPostalCode("12345");
        customer1.setCountry("USA");
        customer1.setPhone("404-123-1432");
        customer1.setEmail("testemail@gmail.com");
        customer1.setCompany("Netflix");

        Customer customer2 = new Customer();
        customer2.setFirstName("James");
        customer2.setLastName("Brown");
        customer2.setAddress1("123 James Street");
        customer2.setAddress2("455 Brown Street");
        customer2.setCity("Miami");
        customer2.setState("Florida");
        customer2.setPostalCode("99876");
        customer2.setCountry("USA");
        customer2.setPhone("470-123-4567");
        customer2.setEmail("jamesbrown@gmail.com");
        customer2.setCompany("Google");

        // Act
        customer1 = customerRepository.save(customer1);
        customer2 = customerRepository.save(customer2);
        Optional<Customer> foundCustomer = customerRepository.findById(customer1.getId());

        // Assert
        assertEquals(foundCustomer.get(), customer1);
    }

    @Test
    public void shouldGetCustomersBySate() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setFirstName("Ethan");
        customer1.setLastName("Wells");
        customer1.setAddress1("788 Spring Street");
        customer1.setAddress2("100 Grey Street");
        customer1.setCity("Daytona");
        customer1.setState("Florida");
        customer1.setPostalCode("12345");
        customer1.setCountry("USA");
        customer1.setPhone("404-123-1432");
        customer1.setEmail("testemail@gmail.com");
        customer1.setCompany("Netflix");

        customer1 = customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("James");
        customer2.setLastName("Brown");
        customer2.setAddress1("123 James Street");
        customer2.setAddress2("455 Brown Street");
        customer2.setCity("Miami");
        customer2.setState("Florida");
        customer2.setPostalCode("99876");
        customer2.setCountry("USA");
        customer2.setPhone("470-123-4567");
        customer2.setEmail("jamesbrown@gmail.com");
        customer2.setCompany("Google");

        customer2 = customerRepository.save(customer2);


        // Act
        List<Customer> customerList = customerRepository.findByState("Florida");

        // Assert
        assertEquals(2, customerList.size());
        List<Integer> customerIdList = customerList.stream().map(Customer::getId).collect(Collectors.toList());
        assertTrue(customerIdList.contains(customer1.getId()));
        assertTrue(customerIdList.contains(customer2.getId()));
    }

    @Test
    public void shouldUpdateCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ethan");
        customer.setLastName("Wells");
        customer.setAddress1("788 Spring Street");
        customer.setAddress2("100 Grey Street");
        customer.setCity("Daytona");
        customer.setState("Florida");
        customer.setPostalCode("12345");
        customer.setCountry("USA");
        customer.setPhone("404-123-1432");
        customer.setEmail("testemail@gmail.com");
        customer.setCompany("Netflix");

        customer = customerRepository.save(customer);

        customer.setFirstName("James");
        customer.setLastName("Brown");
        customer.setAddress1("123 James Street");
        customer.setAddress2("455 Brown Street");
        customer.setCity("Miami");
        customer.setState("Florida");
        customer.setPostalCode("99876");
        customer.setCountry("USA");
        customer.setPhone("470-123-4567");
        customer.setEmail("jamesbrown@gmail.com");
        customer.setCompany("Google");

        customer = customerRepository.save(customer);

        // Act
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        // Assert
        assertEquals(customer1.get(), customer);

    }

    @Test
    public void shouldDeleteCustomerById() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Ethan");
        customer.setLastName("Wells");
        customer.setAddress1("788 Spring Street");
        customer.setAddress2("100 Grey Street");
        customer.setCity("Daytona");
        customer.setState("Florida");
        customer.setPostalCode("12345");
        customer.setCountry("USA");
        customer.setPhone("404-123-1432");
        customer.setEmail("testemail@gmail.com");
        customer.setCompany("Netflix");

        customer = customerRepository.save(customer);

        // Assert
        Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());
        assertTrue(foundCustomer.isPresent());
        assertEquals(foundCustomer.get(), customer);

        // Act
        customerRepository.deleteById(customer.getId());

        foundCustomer = customerRepository.findById(customer.getId());

        // Assert
        assertFalse(foundCustomer.isPresent());
    }
}
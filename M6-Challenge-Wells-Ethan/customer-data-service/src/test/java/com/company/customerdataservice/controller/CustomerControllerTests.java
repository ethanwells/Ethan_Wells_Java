package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests {

    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private MockMvc mockMvc;

    // Test: GET | /customer/{state}
    @Test
    public void testGetCustomersByState() throws Exception {
        // ARRANGE
        mockMvc.perform(
                        get("/customer/state/Georgia")  // Perform the GET request
                                .contentType(MediaType.APPLICATION_JSON))  // Tell the server it's in JSON format
                .andDo(print())  // Print results to console
                .andExpect(status().isOk());
    }

    // Test: GET | /customer/{id}
    @Test
    public void testGetCustomerById() throws Exception {
        // ACT
        mockMvc.perform(
                        get("/customer/1")  // Perform the GET request
                                .contentType(MediaType.APPLICATION_JSON))  // Tell the server it's in JSON format
                .andDo(print())  // Print results to console
                .andExpect(status().isOk());
    }

    // Test: POST | /customer
    @Test
    public void testCreateCustomer() throws Exception {
        //ARRANGE
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

        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
                .thenReturn(customer);

        ObjectMapper objectMapper = new ObjectMapper();

        // ACT
        mockMvc.perform(
                        post("/customer")  // Perform the POST request
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(customer)))  // Request payload as JSON
                .andDo(print())  // Print results to console
                .andExpect(status().isCreated());  // 201 code
    }

    // Test: PUT | /customer
    @Test
    public void updateCustomerTest() throws Exception {
        //ARRANGE
        Customer customer = new Customer();
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

        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
                .thenReturn(customer);

        ObjectMapper objectMapper = new ObjectMapper();

        // ACT
        mockMvc.perform(
                        put("/customer", customer.getId())  // Perform the PUT request
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(customer)))
                .andDo(print())  // Print results to console
                .andExpect(status().isNoContent());  // ASSERT (status code is 204)
    }

    // Test: DELETE /customer/{id}
    @Test
    public void deleteCustomerTest() throws Exception {
        // ACT
        mockMvc.perform(
                        delete("/customer/1"))  // Perform the delete request
                .andDo(print())  // Print results to console
                .andExpect(status().isNoContent());  // ASSERT (status code is 204)
    }

}
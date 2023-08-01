package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // POST /customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (foundCustomer.isPresent()) {
            return foundCustomer.get();
        } else {
            return null;
        }
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
//        if (!customerRepository.existsById(id)) {
//            throw new RuntimeException("Customer not found with id: " + id);
//        }
        customerRepository.deleteById(id);
    }


    @GetMapping("/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return customerRepository.findByState(state);
    }
}

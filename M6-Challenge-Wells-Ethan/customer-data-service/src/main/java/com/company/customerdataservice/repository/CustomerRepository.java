package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Create a new customer record
    // -> customerRepository.save(newCustomer)

    // Update an existing customer record
    // -> customerRepository.save(existingCustomer)

    // Delete an existing customer record
    // -> customerRepository.deleteById(id)

    // Find a customer record by id
    // -> customerRepository.findById(id)

    // Find customer records by state
    List<Customer> findByState(String state);
}

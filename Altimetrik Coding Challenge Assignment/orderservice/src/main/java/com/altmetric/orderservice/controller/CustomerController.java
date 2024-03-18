package com.altmetric.orderservice.controller;

import com.altmetric.orderservice.domain.Customer;
import com.altmetric.orderservice.exception.CustomerNotFoundException;
import com.altmetric.orderservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers () {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Customer> getCustomerById ( @PathVariable String id ) {
        return customerService.getUserByIdAsync(id);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer ( @RequestBody Customer customer ) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer ( @PathVariable String id , @RequestBody Customer customer ) {
        Customer updatedCustomer = customerService.updateCustomer(id , customer);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer ( @PathVariable String id ) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Exception handler
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException ( CustomerNotFoundException ex ) {
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);
    }
}

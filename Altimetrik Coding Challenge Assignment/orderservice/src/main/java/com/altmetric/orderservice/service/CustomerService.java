package com.altmetric.orderservice.service;

import com.altmetric.orderservice.domain.Customer;
import com.altmetric.orderservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Executor executor; // Inject Executor bean

    public List<Customer> getAllCustomers () {
        return customerRepository.findAll();
    }

    public CompletableFuture<Customer> getUserByIdAsync( String userId) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate some processing delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Assuming getUserById method retrieves user from database
            return getCustomerById(userId);
        }, executor);
    }

    public Customer getCustomerById ( String id ) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer ( Customer customer ) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer ( String id , Customer customer ) {
        if (customerRepository.existsById(id)) {
//            customer.setId(id);
            return customerRepository.save(customer);
        } else {
            return null; // Handle error
        }
    }

    public void deleteCustomer ( String id ) {
        customerRepository.deleteById(id);
    }

//    private static final String BASE_URL = "https://api.example.com/users";
//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public UserService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public User getUserById(Long userId) {
//        String url = BASE_URL + "/" + userId;
//        return restTemplate.getForObject(url, User.class);
//    }
}

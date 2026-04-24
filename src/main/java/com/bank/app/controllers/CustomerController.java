package com.bank.app.controllers;

import com.bank.app.models.Customer;
import com.bank.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        String status = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {

        Customer customer = customerService.findCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    @PutMapping("/customers/{id}")

    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer updated = customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/customers/{id}")

    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
        String status = customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}

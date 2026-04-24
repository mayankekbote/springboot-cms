package com.bank.app.services;

import com.bank.app.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    String addCustomer(Customer customer);

    Customer findCustomerById(int id);

    Customer updateCustomer(int id, Customer updatedCustomer);

    String deleteCustomer(int id);
}

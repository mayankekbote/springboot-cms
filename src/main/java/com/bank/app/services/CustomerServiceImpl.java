package com.bank.app.services;

import com.bank.app.models.Customer;
import com.bank.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer added successfully";
    }

    @Override
    public Customer findCustomerById(int id) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Customer not found with id: " + id));
       return customer;

    }

    @Override
    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Customer existingCust = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Customer not found with id: " + id));


        existingCust.setFirstName(updatedCustomer.getFirstName());
        existingCust.setLastName(updatedCustomer.getLastName());
        existingCust.setEmail(updatedCustomer.getEmail());
        existingCust.setPhoneNumber(updatedCustomer.getPhoneNumber());

        return customerRepository.save(existingCust);
    }

    @Override
    public String deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Customer not found with id: " + id));

        customerRepository.delete(customer);
        return "Customer deleted with id: "+id;
    }


}

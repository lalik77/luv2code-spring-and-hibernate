package com.mami.luv2codes.springdemo.service;

import com.mami.luv2codes.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);
}

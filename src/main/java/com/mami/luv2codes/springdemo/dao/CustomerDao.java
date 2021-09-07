package com.mami.luv2codes.springdemo.dao;

import com.mami.luv2codes.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers();


    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int theId);
}

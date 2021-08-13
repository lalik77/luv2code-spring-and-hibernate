package com.mami.luv2codes.springdemo.service;

import com.mami.luv2codes.springdemo.dao.CustomerDao;
import com.mami.luv2codes.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getCustomers() {

        return customerDao.getCustomers();


    }
}

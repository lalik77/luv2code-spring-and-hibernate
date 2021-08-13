package com.mami.luv2codes.springdemo.controller;

import com.mami.luv2codes.springdemo.dao.CustomerDao;
import com.mami.luv2codes.springdemo.entity.Customer;
import com.mami.luv2codes.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    //need to inject the customer dao

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers (Model model) {

        //get customers from dao

        List<Customer> theCustomers = customerService.getCustomers();

        //add the customer to the model

        model.addAttribute("customers",theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormAdd")
    public String showForm(Model theModel){

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }
}

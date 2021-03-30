package com.mami.luv2codes.controller;

import com.mami.luv2codes.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);


    }

    @RequestMapping("/showform")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }


    @RequestMapping("/processform")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult) {

        if(theBindingResult.hasErrors()) {

            System.out.println("There is errors :" + theBindingResult.hasErrors());

            System.out.println("First name :" + theCustomer.getFirstName());
            System.out.println("Last name :" + theCustomer.getLastName());

            return "customer-form";
        }
        else {

            System.out.println("There is erors :" + theBindingResult.hasErrors());
            System.out.println("First name :" + " " + theCustomer.getFirstName());
            System.out.println("Last name :" + " " + theCustomer.getLastName());


            return "customer-confirmation";
        }
    }
}

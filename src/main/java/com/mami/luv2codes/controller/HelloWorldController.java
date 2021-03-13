package com.mami.luv2codes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showform")
    public String showForm() {

        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String process() {

        return "helloworld";
    }


    @RequestMapping("/processFormV2")
    public String letShoutDude(HttpServletRequest request, Model model) {

        String studentName = request.getParameter("studentName");

        studentName = studentName.toUpperCase();

        String result = "Yo! " + studentName;

        model.addAttribute("message",result);


        return "helloworld";
    }
}

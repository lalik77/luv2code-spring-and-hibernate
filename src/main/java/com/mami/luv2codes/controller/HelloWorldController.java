package com.mami.luv2codes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/processFormV3")
    public String processFormVersionThree(  @RequestParam("studentName") String studentName ,
                                            Model model) {

       studentName = studentName.toUpperCase();

        String result = "Hey my friend ! " + studentName;

        model.addAttribute("message",result);


        return "helloworld";
    }
}

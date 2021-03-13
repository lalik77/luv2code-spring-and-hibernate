package com.mami.luv2codes.controller;

import com.mami.luv2codes.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @RequestMapping("/showform")
    public String showForm(Model model) {

        model.addAttribute("student",new Student());

        return "student-form";
    }

    @RequestMapping("/processform")
    public String processForm(@ModelAttribute("student") Student student) {


        System.out.println("Student  " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";


    }

}

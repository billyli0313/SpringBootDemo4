package com.example.springbootdemo4.controller;

import com.example.springbootdemo4.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    private SignUpService signupService ;
    /*Sign up connection*/
    @PostMapping(value = "/signup")
    public String signupTeacherAndStudent(@RequestParam(value = "studentId")String studentId,
                                        @RequestParam(value = "teacherId")String teacherId){

        return signupService.signupTeacherAndStudent(studentId,teacherId);
    }
    /*Delete connection*/
    @DeleteMapping(value = "delete/signup")
    public String deleteSignup(@RequestParam(value = "studentId")String studentId){

        return signupService.deleteSignup(studentId);
    }

}

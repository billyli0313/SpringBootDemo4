package com.example.springbootdemo4.config;

import com.example.springbootdemo4.service.SignUpService;
import com.example.springbootdemo4.service.StudentService;
import com.example.springbootdemo4.service.TeacherService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
/*Inversion of Control*/
public class Configuration {
    @Bean
    public StudentService buildStudentService(){
        return new StudentService();
    }
    @Bean
    public TeacherService buildTeacherService(){
        return new TeacherService();
    }
    @Bean
    public SignUpService buildSignupService(){
        return new SignUpService();
    }


}

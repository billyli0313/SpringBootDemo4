package com.example.springbootdemo4.controller;

import com.example.springbootdemo4.entity.Teacher;
import com.example.springbootdemo4.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
@RestControllerAdvice
@RestController
public class TeacherController {
/*Dependency Injection*/
    @Autowired
    private TeacherService service ;
    /*Show all the teachers*/
    @GetMapping(value = "/teachers")
    public List<Teacher> listAllTeachers(){
        return  service.listAllTeachers();
    }
    /*Create a new teacher*/
    @PostMapping(value = "/create/teacher")
    public void createTeacher(@RequestBody Teacher teacher){
        service.saveTeacher(teacher);
    }
    /*Show the teacher by ID*/
    @GetMapping(value = "/teacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam(value = "id")String id)throws HttpClientErrorException {
        if(id.length()<2){
            throw new HttpClientErrorException(HttpStatusCode.valueOf(400),"parameter id is invalid!");
        }
        return service.getTeacherById(id);
    }
    @ExceptionHandler(HttpClientErrorException.class)
    public String handleHttpClientErrorException(HttpClientErrorException e){
//        System.err.println(e.getStatusCode().value());
        switch (e.getStatusCode().value()){
            case 400:return "Bad request. Error message: " + e.getMessage();
        }
        return "Sorry, there is an issue!";
    }
    @ExceptionHandler
    public String handleExceptions(Exception e){
//        System.err.println(e.getMessage());
        return "Sorry, there is an issue: " + e.getMessage();
    }

}

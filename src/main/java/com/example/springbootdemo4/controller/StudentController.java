package com.example.springbootdemo4.controller;

import com.example.springbootdemo4.entity.Student;
import com.example.springbootdemo4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/head")
public class StudentController  {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String start(){
        return "Welcome to Student Profile System!";
    }
/*Dependency Injection*/
    @Autowired
    private StudentService service;
/*Show all the students*/
    @GetMapping(value = "/students")
    public List<Student> listAllStudents(){
        return  service.listAllStudents();
    }
/*Show the student by ID*/
    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable(value = "id")String id){
        return service.getStudentById(id);
    }
/*Create a new student using parameter*/
    @PostMapping(value = "/create/student")
    public void createStudent(@RequestParam(value = "id")String id,
                              @RequestParam(value = "name")String name,
                              @RequestParam(value = "address")String address){
        Student student = new Student(id,name);
        student.setAddress(address);
        service.saveStudent(student);
    }
    /*Create a new student using @RequestBody*/
    @PostMapping(value = "create/new/student")
    public void createNewStudent(@RequestBody Student student){
        service.saveStudent(student);
    }
    /*Show the student by ID using @ResponseBody*/
    @GetMapping(value = "student/new/{id}")
    @ResponseBody
    public Student getNewStudent(@PathVariable(value = "id")String id){
        return service.getStudentById(id);
    }
/*Delete the student's information*/
    @DeleteMapping(value = "/delete/student")
    public void deleteStudent(@RequestParam(value = "id")String id){
        Student student = service.getStudentById(id);
        service.deleteStudent(student);
    }


///*Show the student by name & pagination*/
//    @GetMapping(value = "/studentlist")
//    public List<Student>  getStudentByName(@RequestParam(value = "name")String name,
//                                           @RequestParam(value = "page")int page,
//                                           @RequestParam(value = "sizePerPage")int sizePerPage){
//        return service.findStudentByName(name,page,sizePerPage);
//    }
}

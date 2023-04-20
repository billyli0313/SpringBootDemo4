package com.example.springbootdemo4.service;

import com.example.springbootdemo4.entity.Student;
import com.example.springbootdemo4.repository.JPAStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

public class StudentService {
/*Dependency Injection*/
    @Autowired
    private JPAStudentRepository jpaStudentRepository;
/*Show all the students*/
    public List<Student> listAllStudents(){
        return jpaStudentRepository.findAll();
    }

/*Get the student by ID*/
    @Cacheable(cacheNames = "student")
    public Student getStudentById(String id){
        Optional<Student> loadStudent = jpaStudentRepository.findById(id);
        if(loadStudent.isPresent()){
            return loadStudent.get();
        }
        return null ;
    }
/*Save a new student*/
    public void saveStudent(Student student){
        jpaStudentRepository.save(student);
    }
/*Update a student*/
    @CachePut(cacheNames = "student", key = "#student.id")
    public void updateStudent(Student student) {
        jpaStudentRepository.save(student);
    }
/*Delete the student*/
    @CacheEvict(cacheNames = "student",key = "#student.id")
    public void deleteStudent(Student student){
        jpaStudentRepository.delete(student);
    }
    /*Get the student by name & Pagination*/
//    public List<Student> findStudentByName(String name,int page, int sizePerPage){
//
//        Pageable pageable =  PageRequest.of(page,sizePerPage, Sort.by("id"));
//        return jpaStudentRepository.findlistByName(name,pageable);
//
//    }
}

package com.example.springbootdemo4.service;

import com.example.springbootdemo4.entity.Teacher;
import com.example.springbootdemo4.repository.JPATeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TeacherService {
    /*Dependency Injection*/
    @Autowired
    private JPATeacherRepository jpaTeacherRepository;
    /*Show all the teachers*/
    public List<Teacher> listAllTeachers(){
        return jpaTeacherRepository.findAll();
    }
/*Get the teacher by ID*/
    public Teacher getTeacherById(String id){
        Optional<Teacher> loadTeacher = jpaTeacherRepository.findById(id);
        if(loadTeacher.isPresent()){
            return loadTeacher.get();
        }
        return null;
    }
/*Save the teacher information*/
    public void saveTeacher(Teacher teacher){
        jpaTeacherRepository.save(teacher);
    }

}

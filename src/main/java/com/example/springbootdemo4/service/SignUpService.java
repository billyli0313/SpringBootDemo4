package com.example.springbootdemo4.service;

import com.example.springbootdemo4.entity.Student;
import com.example.springbootdemo4.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class SignUpService {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
/*Sign up */
    public String signupTeacherAndStudent(String studentId,String teacherId){
        Student student = studentService.getStudentById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if(student != null && teacher != null){
            Set<Teacher> teachers = student.getTeachers();
            teachers.add(teacher);
            student.setTeachers(teachers);
            studentService.saveStudent(student);
            return "Sign up Successfully！";
        }else if(student == null){
            return "Student not found!";
        }else{
            return "Teacher not found!";
        }
    }
    /*Delete signup*/
    public String deleteSignup(String studentId){
        Student student = studentService.getStudentById(studentId);
        if(student != null){
            studentService.deleteStudent(student);
            return "Delete successfully!";
        }
        return "Student not found, can not delete!";
    }
}

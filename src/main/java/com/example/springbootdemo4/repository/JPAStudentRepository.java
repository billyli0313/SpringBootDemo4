package com.example.springbootdemo4.repository;

import com.example.springbootdemo4.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAStudentRepository extends JpaRepository <Student,String>{

//    List<Student> findStudentByName(String name,Pageable page);

//    @Query(value = "SELECT s from Student s where s.name = ?1")
//    List<Student> findByName(String name,Pageable page);
//
//    @Query(value = "SELECT s.* from Student s where s.name = :name", nativeQuery = true)
//    List<Student> findlistByName(@Param("name")String name, Pageable page);
}

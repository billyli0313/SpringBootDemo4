package com.example.springbootdemo4.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    /*Define the owning side*/
    /*Build connection among student Table,teacher Table,and student_teacher Table*/
    @ManyToMany(cascade = { CascadeType.PERSIST,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.DETACH },fetch = FetchType.LAZY)
    @JoinTable(name = "student_teacher",
            joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")})
    private Set<Teacher> teachers;

    public Student() {}
    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public Set<Teacher> getTeachers() {
        return teachers;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
    public String toString(){
        return "Student id: " + this.id + "; " +
                "Student name: " + this.name + "; " +
                "Student address: " + this.address ;
    }

}

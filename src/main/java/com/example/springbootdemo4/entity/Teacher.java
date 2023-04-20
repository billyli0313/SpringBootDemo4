package com.example.springbootdemo4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

/*Define the referencing side*/
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "teachers")
    private Set<Student> students;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<Student> getStudents() {
        return students;
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

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String toString(){
        return "Teacher id: " + this.id + "; " +
                "Teacher name: " + this.name + "; " +
                "Teacher address: " + this.address ;
    }
}

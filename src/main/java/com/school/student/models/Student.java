package com.school.student.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_students")
public class Student implements Serializable {
    private static final long serialVersionUID=1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Student() {
    }

    public Student(Long id, String name, String email, String password, Course course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

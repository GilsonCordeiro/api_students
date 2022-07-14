package com.school.student.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_courses")
public class Course implements Serializable {
    private static final long serialVersionUDI=1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course;
    private Double monthly;

    @ManyToOne
    @JoinColumn(name = "id_instituion")
    private Institution institution;

    public Course() {
    }

    public Course(Long id, String course, Double monthly, Institution institution) {
        this.id = id;
        this.course = course;
        this.monthly = monthly;
        this.institution = institution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getMonthly() {
        return monthly;
    }

    public void setMonthly(Double monthly) {
        this.monthly = monthly;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}

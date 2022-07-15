package com.school.student.DTOS;

import com.school.student.models.Course;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CourseDTO implements Serializable{

    private Long id;
    private String course;
    private Double monthly;

    @NotBlank
    private String institution;

    public CourseDTO() {}
    public CourseDTO(Long id, String course, Double monthly, String institution) {
        this.id = id;
        this.course = course;
        this.monthly = monthly;
        this.institution = institution;
    }


    public CourseDTO(Course entity) {
        this.id = entity.getId();
        this.course = entity.getCourse();
        this.monthly = entity.getMonthly();
        this.institution = entity.getInstitution();
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
    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }




}

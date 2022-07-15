package com.school.student.services;

import com.school.student.DTOS.CourseDTO;
import com.school.student.models.Course;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    Course findById(Long id);

    Course save(CourseDTO courseDTO);

    void deleteById(Long id);

    Course update(Long id, Course course);


}

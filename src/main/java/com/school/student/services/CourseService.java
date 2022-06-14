package com.school.student.services;

import com.school.student.models.Course;
import com.school.student.respositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }
    public List<Course> findAll(){
        List<Course> result = repository.findAll();
        return result;
    }
    public Course findById(Long id){
        Optional<Course> obj = repository.findById(id);
        return obj.get();
    }
    public Course save(Course course){
        Course result = repository.save(course);
        return result;
    }
}

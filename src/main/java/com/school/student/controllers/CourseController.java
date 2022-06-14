package com.school.student.controllers;

import com.school.student.models.Course;
import com.school.student.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        List<Course> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        Course obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course){
        Course result = service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}

package com.school.student.controllers;

import com.school.student.models.Course;
import com.school.student.services.CourseService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "List courses")
    public ResponseEntity<List<Course>> findAll(){
        List<Course> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "List course por id")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        Course obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    @ApiOperation(value = "Create course")
    public ResponseEntity<Course> save(@RequestBody Course course){
        Course result = service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update course")
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        course = (Course) service.update(id, course);
        return ResponseEntity.ok().body(course);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete course")
    public ResponseEntity<Course> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

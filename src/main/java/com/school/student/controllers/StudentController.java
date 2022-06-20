package com.school.student.controllers;


import com.school.student.models.Student;
import com.school.student.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
       Student result = service.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        student = service.update(id, student);
        return ResponseEntity.ok().body(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

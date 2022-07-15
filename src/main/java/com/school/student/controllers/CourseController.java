package com.school.student.controllers;

import com.school.student.DTOS.CourseDTO;
import com.school.student.models.Course;
import com.school.student.services.CourseServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    final CourseServiceImpl service;
    public CourseController(CourseServiceImpl service) {
        this.service = service;
    }


    @PostMapping
    @ApiOperation(value = "Create course")
    public ResponseEntity <? extends Object>  save(@RequestBody @Valid CourseDTO courseDTO){

        //if (service.existsByCourse(courseDTO.getCourse())){
          //  var resp = ResponseEntity.status(HttpStatus.CONFLICT).body("Curso já cadastrado!");
           // return resp;
        //}
        Course result = service.save(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CourseDTO(result));
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


    @PutMapping("/{id}")
    @ApiOperation(value = "Update course")
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        course = (Course) service.update(id, course);
        return ResponseEntity.ok().body(course);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete course")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.deleteById(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.OK).body("Deltado com Sucesso");
    }
}

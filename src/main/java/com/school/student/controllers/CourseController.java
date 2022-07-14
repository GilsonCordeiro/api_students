package com.school.student.controllers;

import com.school.student.models.Course;
import com.school.student.services.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
   public ResponseEntity<Object> findById(@PathVariable Long id){
//        Course obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);

        // **** Outra forma de tratar quando é solicitado um id não existente
        Optional<Course> objOptional = Optional.ofNullable(service.findById(id));
        if (!objOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(objOptional.get());


    }
    @PostMapping
    @ApiOperation(value = "Create course")
    public ResponseEntity<?> save(@RequestBody Course course){
        if (service.existsByCourse(course.getCourse())){
            var resp = ResponseEntity.status(HttpStatus.CONFLICT).body("Curso já cadastrado!");
            return resp;
        }
        Course result = service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update course")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        course = (Course) service.update(id, course);
        return ResponseEntity.ok().body(course);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete course")
    public ResponseEntity<?> delete(@PathVariable Long id){
    service.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");

}
}

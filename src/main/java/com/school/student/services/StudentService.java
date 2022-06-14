package com.school.student.services;

import com.school.student.models.Student;
import com.school.student.respositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public List<Student> findAll(){
        List<Student> result = repository.findAll();
        return result;
    }
    public Student findById(@PathVariable Long id){
        Optional<Student> obj = repository.findById(id);
        return obj.get();
    }
    public Student save(Student student){
        Student result = repository.save(student);
        return result;
    }
}

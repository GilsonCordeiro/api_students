package com.school.student.services;

import com.school.student.exception.DataException;
import com.school.student.exception.NotFoundException;
import com.school.student.models.Student;
import com.school.student.respositories.StudentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
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

    public Student update(Long id, Student student) {
        try {
            Student result = repository.getById(id);
            result.setName(student.getName());
            result.setEmail(student.getEmail());
            result.setPassword(student.getPassword());
            result.setCourse(student.getCourse());
            result = repository.save(result);
            return result;
        }
        catch (EntityNotFoundException e){
            throw new NotFoundException("Id not found: " +id);
        }
    }

    public void deleteById(@PathVariable Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new NotFoundException("Id not found: " +id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataException("Integrity violation");
        }
    }
}

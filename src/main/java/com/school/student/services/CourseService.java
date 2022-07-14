package com.school.student.services;


import com.school.student.exception.DataException;
import com.school.student.exception.NotFoundException;
import com.school.student.models.Course;
import com.school.student.respositories.CourseRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
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
        Course result = obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado!"));

        return result;
    }
    public Course save(Course course){
        Course result = repository.save(course);
        return result;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Course update(Long id, Course course) {
        try {
            Course result = repository.getById(id);
            result.setCourse(course.getCourse());
            result.setInstitution(course.getInstitution());
            result.setMonthly(course.getMonthly());
            result = repository.save(result);
            return result;
        }
        catch (EntityNotFoundException e){
            throw new NotFoundException("Id not found: " +id);
        }

    }
    public void delete(@PathVariable Course id){
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

    public boolean existsByCourse(String course) {
        return repository.existsByCourse(course);
    }
}

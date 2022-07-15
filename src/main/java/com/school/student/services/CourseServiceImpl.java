package com.school.student.services;


import com.school.student.DTOS.CourseDTO;
import com.school.student.exception.ConflitException;
import com.school.student.exception.DataException;
import com.school.student.exception.NotFoundException;
import com.school.student.models.Course;
import com.school.student.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    CourseRepository repository;




    @Override
    public List<Course> findAll(){
        List<Course> result = repository.findAll();
        return result;
    }
    @Override
    public Course findById(Long id){
        Optional<Course> obj = repository.findById(id);
        Course result = obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado!"));

        return result;
    }


    public boolean existsByCourse(String course) {
        return repository.existsByCourse(course);
    }

    public void Validarcourse(CourseDTO courseDTO) {

        if (existsByCourse(courseDTO.getCourse())) {

            throw new ConflitException("Course duplicado");
        }
    }




    @Override
    public Course save(CourseDTO courseDTO){

        Validarcourse(courseDTO);

        var courseNew = new Course();
        courseNew.setCourse(courseDTO.getCourse());
        courseNew.setMonthly(courseDTO.getMonthly());
        courseNew.setInstitution(courseDTO.getInstitution());

        Course result = repository.save(courseNew);
        return result;

    }



    @Override
    public void deleteById(Long id) {
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

    @Override
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



}

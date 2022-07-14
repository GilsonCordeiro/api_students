package com.school.student.services;

import com.school.student.exception.DataException;
import com.school.student.exception.NotFoundException;
import com.school.student.models.Institution;
import com.school.student.respositories.InstitutionRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {
    final InstitutionRepository repository;

    public InstitutionService(InstitutionRepository repository) {
        this.repository = repository;
    }
    public List<Institution> findAll(){
        List<Institution> result = repository.findAll();
        return result;
    }
    public Optional<Institution> findById(Long id){
        Optional<Institution> obj = repository.findById(id);
        return Optional.ofNullable(obj.orElseThrow(() -> new NotFoundException("Id not found! " + id)));
    }
    public Institution save(Institution institution){
        Institution result = repository.save(institution);
        return result;
    }
    public Institution update(Long id, Institution institution){
        try {
            Institution result = repository.getById(id);
            result.setName(institution.getName());
            result.setTelephone(institution.getTelephone());
            result = repository.save(result);
            return result;
        }
        catch (EntityNotFoundException e){
            throw new NotFoundException("Id not found: " +id);
        }
    }
    public void delete(Long id){
       try {
           repository.deleteById(id);
       }
       catch (NotFoundException e){
           throw new NotFoundException("Id not found " +id);
       }
       catch (DataIntegrityViolationException e){
           throw new DataException("Integrity Violation!");
       }
    }

    public boolean existsByTelephone(String telephone) {
        return repository.existsByTelephone(telephone);
    }
}

package com.school.student.controllers;

import com.school.student.models.Institution;
import com.school.student.services.InstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/institution")
public class InstitutionController {
    final InstitutionService service;

    public InstitutionController(InstitutionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Institution>> findAll() {
        List<Institution> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Institution>> findById(@PathVariable Long id) {
        Optional<Institution> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Institution institution) {
        if (service.existsByTelephone(institution.getTelephone())){
            var resp = ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: Telefone já estar cadastrado!");
            return resp;
        }
        Institution result = service.save(institution);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Institution> update(@PathVariable Long id, @RequestBody Institution institution){
        Institution result = service.update(id, institution);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Institution> deleteById(Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

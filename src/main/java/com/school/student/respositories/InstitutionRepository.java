package com.school.student.respositories;

import com.school.student.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    boolean existsByTelephone(String telephone);
}

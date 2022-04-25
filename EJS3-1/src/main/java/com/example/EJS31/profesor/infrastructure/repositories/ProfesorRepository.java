package com.example.EJS31.profesor.infrastructure.repositories;

import com.example.EJS31.profesor.domain.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    @Query(value= "select * from Profesor where person_id = ?1", nativeQuery = true)
    Optional<Profesor> findByPersonId(String person);
}

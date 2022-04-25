package com.example.Ej31.profesor.infrastructure.repositories;

import com.example.Ej31.profesor.domain.models.Profesor;
import com.example.Ej31.profesor.infrastructure.dto.OutputProfesorDto;
import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.student.infrastructure.dto.OutputStudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    @Query(value= "select * from Profesor where person_id = ?1", nativeQuery = true)
    Optional<Profesor> findByPersonId(String person);
}

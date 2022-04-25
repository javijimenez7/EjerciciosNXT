package com.example.EJS31.profesor.domain.services;

import com.example.EJS31.profesor.domain.models.Profesor;
import com.example.EJS31.profesor.infrastructure.dto.InputProfesorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProfesorI {
    ResponseEntity<?> addProfesor(InputProfesorDto profesorDto) throws Exception;

    Optional<Profesor> findById(String id) throws Exception;

    List<Profesor> findAll();

    String deletedById(String id) throws Exception;
}

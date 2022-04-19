package com.example.BS9.profesor.domain.services;

import com.example.BS9.profesor.domain.models.Profesor;
import com.example.BS9.profesor.infrastructure.dto.InputProfesorDto;
import com.example.BS9.profesor.infrastructure.dto.OutputProfesorDto;

import java.util.List;

public interface ProfesorI {
    OutputProfesorDto addProfesor(InputProfesorDto profesorDto) throws Exception;

    OutputProfesorDto findById(String id) throws Exception;

    List<Profesor> findAll();

    String deletedById(String id) throws Exception;
}

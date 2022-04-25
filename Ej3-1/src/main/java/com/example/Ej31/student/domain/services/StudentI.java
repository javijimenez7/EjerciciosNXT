package com.example.Ej31.student.domain.services;

import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.student.infrastructure.dto.InputStudentDto;
import com.example.Ej31.student.infrastructure.dto.OutputStudentDto;
import com.example.Ej31.student.infrastructure.dto.OutputStudentFullDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentI {
    public ResponseEntity<?> addStudent(InputStudentDto studentDto) throws Exception;

    OutputStudentDto findById(String id) throws Exception;

    OutputStudentFullDto findFById(String id) throws Exception;

    List<Student> findAll();

    String deletedById(String id) throws Exception;

    ResponseEntity addAsignaturas(String idStudent, List<String> ids);

    ResponseEntity removeAsignaturas(String idStudent, List<String> ids);
}

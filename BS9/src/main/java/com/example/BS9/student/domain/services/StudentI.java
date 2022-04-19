package com.example.BS9.student.domain.services;

import com.example.BS9.student.domain.models.Student;
import com.example.BS9.student.infrastructure.dto.InputStudentDto;
import com.example.BS9.student.infrastructure.dto.OutputStudentDto;
import com.example.BS9.student.infrastructure.dto.OutputStudentFullDto;

import java.util.List;

public interface StudentI {
    public OutputStudentDto addStudent(InputStudentDto studentDto);

    OutputStudentDto findById(String id) throws Exception;

    OutputStudentFullDto findFById(String id) throws Exception;

    List<Student> findAll();

    String deletedById(String id) throws Exception;
}

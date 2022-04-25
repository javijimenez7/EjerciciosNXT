package com.example.Ej31.subject.domain.services;

import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.student.infrastructure.dto.InputStudentDto;
import com.example.Ej31.student.infrastructure.dto.OutputStudentDto;
import com.example.Ej31.subject.domain.models.Subject;
import com.example.Ej31.subject.infrastructure.dto.InputSubjectDto;
import com.example.Ej31.subject.infrastructure.dto.OutputSubjectDto;

import java.util.List;
import java.util.Optional;

public interface SubjectI {

    public OutputSubjectDto addSubject(InputSubjectDto subjectDto) throws Exception;

    OutputSubjectDto findById(String id) throws Exception;

    List<Subject> findAll();

    String deletedById(String id) throws Exception;

    List<Subject> findByIdStudent(String idStudent);
}

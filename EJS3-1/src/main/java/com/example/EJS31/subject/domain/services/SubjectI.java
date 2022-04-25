package com.example.EJS31.subject.domain.services;

import com.example.EJS31.subject.domain.models.Subject;
import com.example.EJS31.subject.infrastructure.dto.InputSubjectDto;
import com.example.EJS31.subject.infrastructure.dto.OutputSubjectDto;

import java.util.List;

public interface SubjectI {

    public OutputSubjectDto addSubject(InputSubjectDto subjectDto) throws Exception;

    OutputSubjectDto findById(String id) throws Exception;

    List<Subject> findAll();

    String deletedById(String id) throws Exception;

    List<Subject> findByIdStudent(String idStudent);
}

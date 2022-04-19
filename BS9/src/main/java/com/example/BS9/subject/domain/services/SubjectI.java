package com.example.BS9.subject.domain.services;

import com.example.BS9.subject.domain.models.Subject;
import com.example.BS9.subject.infrastructure.dto.InputSubjectDto;
import com.example.BS9.subject.infrastructure.dto.OutputSubjectDto;

import java.util.List;

public interface SubjectI {

    public OutputSubjectDto addSubject(InputSubjectDto subjectDto) throws Exception;

    OutputSubjectDto findById(String id) throws Exception;

    List<Subject> findAll();

    String deletedById(String id) throws Exception;

    List<Subject> findByIdStudent(String idStudent);
}

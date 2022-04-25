package com.example.EJS31.subject.infrastructure.dto;

import com.example.EJS31.student.domain.models.Student;
import com.example.EJS31.subject.domain.models.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OutputSubjectDto {

    private String id_subject;
    private List<Student> students;
    private String subject_name;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public OutputSubjectDto(Subject subject){
        setId_subject(subject.getId_subject());
        setStudents(subject.getStudents());
        setSubject_name(subject.getSubject_name());
        setComents(subject.getComents());
        setInitial_date(subject.getInitial_date());
        setFinish_date(subject.getFinish_date());
    }

    public OutputSubjectDto(){

    }
}

package com.example.Ej31.subject.infrastructure.dto;

import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.subject.domain.models.Subject;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class InputSubjectDto {

    private String id_subject;
    private List<Student> students;
    private String subject_name;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public InputSubjectDto(Subject subject){
        setId_subject(subject.getId_subject());
        setStudents(subject.getStudents());
        setSubject_name(subject.getSubject_name());
        setComents(subject.getComents());
        setInitial_date(subject.getInitial_date());
        setFinish_date(subject.getFinish_date());
    }

    public InputSubjectDto(){

    }
}

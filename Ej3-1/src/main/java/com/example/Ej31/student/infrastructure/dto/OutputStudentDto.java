package com.example.Ej31.student.infrastructure.dto;


import com.example.Ej31.person.domain.models.Person;
import com.example.Ej31.profesor.domain.models.Profesor;
import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.subject.domain.models.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OutputStudentDto {

    private String branch;
    private String coments;
    private String id_student;
    private List<Subject> subjects;
    private String person;
    private String profesor;
    private Integer num_hours_week;

    public OutputStudentDto(Student student){
        setId_student(student.getId_student());
        setBranch(student.getBranch());
        setComents(student.getComents());
        setProfesor(student.getProfesor().getId_profesor());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
    }

    public OutputStudentDto(){

    }

}

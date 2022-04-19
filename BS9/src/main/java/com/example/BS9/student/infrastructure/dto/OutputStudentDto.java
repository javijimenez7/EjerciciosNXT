package com.example.BS9.student.infrastructure.dto;


import com.example.BS9.person.domain.models.Person;
import com.example.BS9.profesor.domain.models.Profesor;
import com.example.BS9.student.domain.models.Student;
import com.example.BS9.subject.domain.models.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OutputStudentDto {

    private String branch;
    private String coments;
    private String id_student;
    private List<Subject> subjects;
    private Person person;
    private Profesor profesor;
    private Integer num_hours_week;

    public OutputStudentDto(Student student){
        setId_student(student.getId_student());
        setBranch(student.getBranch());
        setComents(student.getComents());
        setProfesor(student.getProfesor());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
    }

    public OutputStudentDto(){

    }

}

package com.example.EJS31.student.infrastructure.dto;


import com.example.EJS31.student.domain.models.Student;
import com.example.EJS31.subject.domain.models.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InputStudentDto {

    private String branch;
    private String coments;
    private String id_student;
    private List<Subject> subjects;
    private String person;
    private String profesor;
    private Integer num_hours_week;

    public InputStudentDto(Student student) {
        setId_student(student.getId_student());
        setBranch(student.getBranch());
        setComents(student.getComents());
        setPerson(student.getPerson().getPerson_id());
        setProfesor(student.getProfesor().getId_profesor());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
    }

    public InputStudentDto() {
    }

}

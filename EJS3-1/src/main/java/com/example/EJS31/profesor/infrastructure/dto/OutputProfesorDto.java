package com.example.EJS31.profesor.infrastructure.dto;

import com.example.EJS31.profesor.domain.models.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OutputProfesorDto {
    private String profesor_id;
    private String branch;
    private String coments;
    private List<com.example.EJS31.student.domain.models.Student> students;
    private String person;

    public OutputProfesorDto(Profesor profesor){
        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
        setStudents(profesor.getStudents());
        setProfesor_id(profesor.getId_profesor());
        setPerson(profesor.getPerson().getPerson_id());
    }

    public OutputProfesorDto(){

    }
}

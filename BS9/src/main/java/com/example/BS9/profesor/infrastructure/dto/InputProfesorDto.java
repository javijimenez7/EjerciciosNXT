package com.example.BS9.profesor.infrastructure.dto;

import com.example.BS9.person.domain.models.Person;
import com.example.BS9.profesor.domain.models.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class InputProfesorDto {

    private String profesor_id;
    private String branch;
    private String coments;
    private List<com.example.BS9.student.domain.models.Student> students;
    private Person person;

    public InputProfesorDto(Profesor profesor) {


        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
        setStudents(profesor.getStudents());
        setProfesor_id(profesor.getId_profesor());
        setPerson(profesor.getPerson());
    }

    public InputProfesorDto(){

    }

}

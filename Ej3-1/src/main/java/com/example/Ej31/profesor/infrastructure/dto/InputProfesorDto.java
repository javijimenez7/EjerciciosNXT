package com.example.Ej31.profesor.infrastructure.dto;

import com.example.Ej31.person.domain.models.Person;
import com.example.Ej31.profesor.domain.models.Profesor;
import com.example.Ej31.student.domain.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class InputProfesorDto {

    private String profesor_id;
    private String branch;
    private String coments;
    private List<Student> students;
    private String person;

    public InputProfesorDto(Profesor profesor) {


        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
        setStudents(profesor.getStudents());
        setProfesor_id(profesor.getId_profesor());
        setPerson(profesor.getPerson().getPerson_id());
    }

    public InputProfesorDto(){

    }

}

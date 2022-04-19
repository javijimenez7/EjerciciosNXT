package com.example.BS9.student.infrastructure.dto;

import com.example.BS9.person.domain.models.Person;
import com.example.BS9.profesor.domain.models.Profesor;
import com.example.BS9.student.domain.models.Student;
import com.example.BS9.subject.domain.models.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OutputStudentFullDto {
    private String branch;
    private String coments;
    private String id_student;
    private List<Subject> subjects;
    private Person person;
    private Profesor profesor;
    private Integer num_hours_week;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date create_date;
    private String imagen_url;
    private Date termination_date;

    public OutputStudentFullDto(Student student){
        setId_student(student.getId_student());
        setBranch(student.getBranch());
        setComents(student.getComents());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
        setUser(student.getPerson().getUser());
        setPassword(student.getPerson().getPassword());
        setName(student.getPerson().getName());
        setSurname(student.getPerson().getSurname());
        setCompany_email(student.getPerson().getCompany_email());
        setPersonal_email(student.getPerson().getPersonal_email());
        setCity(student.getPerson().getCity());
        setActive(student.getPerson().getActive());
        setCreate_date(student.getPerson().getCreate_date());
        setImagen_url(student.getPerson().getImagen_url());
        setTermination_date(student.getPerson().getTermination_date());
    }

    public OutputStudentFullDto(){

    }
}

package com.example.DB1Ej2.person.domain.models;

import com.example.DB1Ej2.person.infraestructure.dto.PersonInputDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue

    private Integer personId;

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

    public Person(PersonInputDTO personDTO){
        setPersonId(personDTO.getPersonId());
        setActive(personDTO.getActive());
        setCity(personDTO.getCity());
        setCompany_email(personDTO.getCompany_email());
        setImagen_url(personDTO.getImagen_url());
        setName(personDTO.getName());
        setSurname(personDTO.getSurname());
        setPassword(personDTO.getPassword());
        setPersonal_email(personDTO.getPersonal_email());
        setUser(personDTO.getUser());
        setTermination_date(personDTO.getTermination_date());
    }

    public Person(){

    }

}

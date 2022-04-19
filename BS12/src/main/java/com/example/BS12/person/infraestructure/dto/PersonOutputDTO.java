package com.example.BS12.person.infraestructure.dto;


import com.example.BS12.person.domain.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class PersonOutputDTO {
    private String person_id;

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

    public PersonOutputDTO(Person person){
        setPerson_id(person.getPerson_id());
        setActive(person.getActive());
        setCity(person.getCity());
        setCompany_email(person.getCompany_email());
        setImagen_url(person.getImagen_url());
        setName(person.getName());
        setSurname(person.getSurname());
        setPassword(person.getPassword());
        setPersonal_email(person.getPersonal_email());
        setUser(person.getUser());
        setTermination_date(person.getTermination_date());

    }

    public PersonOutputDTO(){

    }

}

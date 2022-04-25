package com.example.EJS31.person.domain.models;


import com.example.EJS31.StringPrefixedSequenceIdGenerator;
import com.example.EJS31.person.infraestructure.dto.PersonInputDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @GenericGenerator(
            name = "seq",
            strategy = "com.example.EJS31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PER"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String person_id;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean admin;
    private Date create_date;
    private String imagen_url;
    private Date termination_date;

    public Person(PersonInputDTO personDTO){
        setPerson_id(personDTO.getPerson_id());
        setAdmin(personDTO.getAdmin());
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

package com.example.DBA2.person.domain;


import com.example.DBA2.person.infraestructure.dto.PersonInputDTO;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.Date;

@Document(collection = "person")

@Data
public class Person {

    @Id
    @MongoId
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

    public Person(PersonInputDTO personDTO){
        setPerson_id(personDTO.getPerson_id());
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

    public Person(Person personDTO){
        setPerson_id(personDTO.getPerson_id());
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
}

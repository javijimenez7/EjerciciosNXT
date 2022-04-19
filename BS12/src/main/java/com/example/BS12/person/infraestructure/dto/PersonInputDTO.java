package com.example.BS12.person.infraestructure.dto;


import com.example.BS12.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInputDTO {
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

}

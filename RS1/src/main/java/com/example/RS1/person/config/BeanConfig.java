package com.example.RS1.person.config;

import com.example.RS1.person.domain.model.Person;
import com.example.RS1.person.domain.service.PersonService;
import com.example.RS1.person.domain.service.PersonServiceImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("persona")
    public Person getPerson(){
        PersonService personService = new PersonServiceImplement();
        return personService.getPerson();
    }
}

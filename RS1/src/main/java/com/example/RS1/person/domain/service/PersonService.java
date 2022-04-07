package com.example.RS1.person.domain.service;

import com.example.RS1.person.domain.model.Person;

import java.util.List;

public interface PersonService {

    Person getPerson();
    void setPerson(Person person);
    List<Person> getPeople();
    void addPerson(Person person);
    void setId(Integer id);
    void setName(String name);
    void setPopulation(String population);
    void setAge(Integer age);
    String getName();
    String getPopulation();
    Integer getAge();
    Integer getId();
    Person findById(Integer Id);
    Person findByName(String name);
}

package com.example.RS1.person.domain.service;

import com.example.RS1.person.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImplement implements PersonService {

    Person person = new Person();
    List<Person> people = new ArrayList<>();

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

    public List<Person>getPeople(){
        return this.people;
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public String getName(){
        return person.getName();
    }

    public String getPopulation(){
        return person.getPopulation();
    }

    public Integer getAge(){
        return person.getAge();
    }

    public Integer getId(){
        return this.getId();
    }

    public void setAge(Integer age){
        person.setAge(age);
    }

    public void setPopulation(String population) {
        person.setPopulation(population);
    }

    public void setName(String name){
       person.setName(name);
    }

    public void setId(Integer id){
        person.setId(id);
    }

    public Person findById(Integer id){
        Person pe = this.people.stream().filter(person -> Objects.equals(person.getId(), id)).toList().get(0);
        return pe;
    }

    public Person findByName(String name){
        Person pe = this.people.stream().filter(person -> Objects.equals(person.getName(), name)).toList().get(0);
        return pe;
    }


}

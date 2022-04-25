package com.example.DBA2.person.infraestructure.repositories;

import com.example.DBA2.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRepositoryMongo implements PersonRepository{
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonRepositoryMongo(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Person savePerson(Person person){
        mongoTemplate.save(person);
        return person;
    }

    @Override
    public List<Person> getAll(){
        return mongoTemplate.findAll(Person.class);
    }

    @Override
    public Person findOneById(String id) {
        return mongoTemplate.findById(id, Person.class);
    }

    @Override
    public void deleteById(String id) {

        Person personToRemove = mongoTemplate.findById(id, Person.class);
        if(personToRemove != null){
            mongoTemplate.remove(personToRemove);
        }
    }

    @Override
    public void updatePerson(Person person, String id) {
        Person p = mongoTemplate.findById(id,Person.class);

        p = person;

        mongoTemplate.save(p);

    }
}

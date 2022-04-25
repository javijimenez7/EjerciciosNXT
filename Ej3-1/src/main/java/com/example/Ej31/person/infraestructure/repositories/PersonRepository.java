package com.example.Ej31.person.infraestructure.repositories;


import com.example.Ej31.person.domain.models.Person;
import com.example.Ej31.person.infraestructure.dto.PersonOutputDTO;
import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.student.infrastructure.dto.OutputStudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<PersonOutputDTO> findByUser(String user);


}

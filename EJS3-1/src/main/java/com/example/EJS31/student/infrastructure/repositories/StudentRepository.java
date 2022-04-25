package com.example.EJS31.student.infrastructure.repositories;

import com.example.EJS31.student.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value= "select * from Student where person_id = ?1", nativeQuery = true)
    public Optional<Student> findByPersonId(String person);
}

package com.example.BS9.student.domain.repositories;

import com.example.BS9.student.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}

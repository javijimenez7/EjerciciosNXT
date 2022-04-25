package com.example.Ej31.subject.infrastructure.repositories;

import com.example.Ej31.subject.domain.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}

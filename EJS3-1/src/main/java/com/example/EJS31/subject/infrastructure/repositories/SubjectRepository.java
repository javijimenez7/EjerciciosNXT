package com.example.EJS31.subject.infrastructure.repositories;

import com.example.EJS31.subject.domain.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}

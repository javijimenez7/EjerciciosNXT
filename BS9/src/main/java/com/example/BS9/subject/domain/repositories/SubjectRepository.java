package com.example.BS9.subject.domain.repositories;

import com.example.BS9.subject.domain.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}

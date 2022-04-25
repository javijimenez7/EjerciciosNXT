package com.example.Ej31.subject.domain.services;

import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.student.infrastructure.repositories.StudentRepository;
import com.example.Ej31.subject.domain.models.Subject;
import com.example.Ej31.subject.infrastructure.repositories.SubjectRepository;
import com.example.Ej31.subject.infrastructure.dto.InputSubjectDto;
import com.example.Ej31.subject.infrastructure.dto.OutputSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements SubjectI {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public OutputSubjectDto addSubject(InputSubjectDto subjectDto) throws Exception {

        if (subjectDto.getSubject_name().length() < 0) {
            throw new Exception("El nombre de la asignatura debe ser mayor que 0");
        } else {
            Subject subject = new Subject(subjectDto);
            subjectRepository.save(subject);

            OutputSubjectDto saveOutputDTO = new OutputSubjectDto(subject);
            return saveOutputDTO;

        }
    }


    @Override
    public OutputSubjectDto findById(String id) throws Exception {

        Subject subjectById = subjectRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado"));
        return new OutputSubjectDto(subjectById);

    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public String deletedById(String id) throws Exception {
        subjectRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado la asignatura cuyo id es: " + id));
        subjectRepository.deleteById(id);
        return "La asignatura cuyo es id es " + id + " ha sido borrado";
    }

    @Override
    public List<Subject> findByIdStudent(String idStudent) {
        Optional<Student> s = studentRepository.findById(idStudent);

        return s.get().getSubjects();

    }
}

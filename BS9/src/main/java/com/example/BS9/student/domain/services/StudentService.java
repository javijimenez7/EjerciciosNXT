package com.example.BS9.student.domain.services;

import com.example.BS9.person.domain.repositories.PersonRepository;
import com.example.BS9.student.domain.models.Student;
import com.example.BS9.student.domain.repositories.StudentRepository;
import com.example.BS9.student.infrastructure.dto.InputStudentDto;
import com.example.BS9.student.infrastructure.dto.OutputStudentDto;
import com.example.BS9.student.infrastructure.dto.OutputStudentFullDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentI{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public OutputStudentDto addStudent(InputStudentDto studentDto) {

        Student student = new Student(studentDto);
        personRepository.save(student.getPerson());
        studentRepository.save(student);

        OutputStudentDto saveOutputDTO = new OutputStudentDto(student);
        return saveOutputDTO;

    }


    @Override
    public OutputStudentDto findById(String id) throws Exception{

        Student studentById = studentRepository.findById(id).orElseThrow(()-> new Exception("No se ha encontrado"));
        return new OutputStudentDto(studentById);

    }

    @Override
    public OutputStudentFullDto findFById(String id) throws Exception{

        Student studentById = studentRepository.findById(id).orElseThrow(()-> new Exception("No se ha encontrado"));
        return new OutputStudentFullDto(studentById);

    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public String deletedById(String id) throws Exception{
        studentRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado al estudiante cuyo id es: "+id));
        studentRepository.deleteById(id);
        personRepository.deleteById(Integer.parseInt(id));
        return "El estudiante cuyo es id es "+id+" ha sido borrado";
    }
}

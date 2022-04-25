package com.example.EJS31.subject.infrastructure;

import com.example.EJS31.subject.domain.models.Subject;
import com.example.EJS31.subject.domain.services.SubjectService;
import com.example.EJS31.subject.infrastructure.dto.InputSubjectDto;
import com.example.EJS31.subject.infrastructure.dto.OutputSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subject")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addSubject")
    public String addSubject(@RequestBody InputSubjectDto subject) throws Exception{

        System.out.println("En el controlador addStudent");

        subjectService.addSubject(subject);
        return "Asignatura creado correctamente";
    }

    //Request ver un estudiante
    @GetMapping(value = "/subject/{id}")
    public OutputSubjectDto getSubject(@PathVariable String id) throws Exception{

        return subjectService.findById(id);
    }


    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getSubjects")
    public List<Subject> getSubjects(){
        System.out.println("En el controlador getSubjects");
        return subjectService.findAll();
    }


    //Request para eliminar la asignatura cuyo id se para por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        subjectService.deletedById(id);
        return "El estudiante con id "+id+" ha sido eliminado de la base de datos";

    }

    @GetMapping(value = "/idStudent/{id}")
    public List<Subject> findByIdStudent(@PathVariable String id) throws Exception{
        return subjectService.findByIdStudent(id);
    }



}

package com.example.Ej31.student.infrastructure;

import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.student.infrastructure.repositories.StudentRepository;
import com.example.Ej31.student.domain.services.StudentService;
import com.example.Ej31.student.infrastructure.dto.InputStudentDto;
import com.example.Ej31.student.infrastructure.dto.OutputStudentDto;
import com.example.Ej31.student.infrastructure.dto.OutputStudentFullDto;
import com.example.Ej31.subject.domain.models.Subject;
import com.example.Ej31.subject.infrastructure.repositories.SubjectRepository;
import com.example.Ej31.subject.domain.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectService subjectService;


    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody InputStudentDto student) throws Exception{

        System.out.println("En el controlador addStudent");

        return studentService.addStudent(student);

    }

    //Request ver un estudiante
    @GetMapping(value = "/estudiante/{id}")
    public ResponseEntity getStudent(@PathVariable String id, @RequestParam(defaultValue = "simple") String outputType) throws Exception{

        System.out.println("En el controlador getStudent");
        if(outputType.equals("simple")){
            OutputStudentDto studentsimple = studentService.findById(id);
            return ResponseEntity.ok(studentsimple);
        } else {
            if(outputType.equals("full")){
                OutputStudentFullDto studentfull = studentService.findFById(id);
                return ResponseEntity.ok(studentfull);
            }
            return ResponseEntity.ok("No se ha encontrado");
        }
    }


    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getStudents")
    public List<Student> getStudents(){
        System.out.println("En el controlador getStudents");
        return studentService.findAll();
    }

    //Request para obtener la persona cuyo id se para por parámetro
    @GetMapping(value = "/getStudent/{id}")
    public OutputStudentDto getProfesorById(@PathVariable String id) throws Exception{
        return studentService.findById(id);
    }

    //Request para eliminar el estudiante cuyo id se para por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        studentService.deletedById(id);
        return "El estudiante con id "+id+" ha sido eliminado de la base de datos";

    }

    @PutMapping(value = "/addSubject/{idStudent}")
    public ResponseEntity addAsignatura(@PathVariable String idStudent, @RequestBody List<String> ids) throws Exception{

        return studentService.addAsignaturas(idStudent, ids);

    }

    @PutMapping(value = "/removeSubjects/{idStudent}")
    public ResponseEntity removeAsignatura(@PathVariable String idStudent, @RequestBody List<String> ids) throws Exception{

        return studentService.removeAsignaturas(idStudent, ids);

    }

}

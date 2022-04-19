package com.example.BS9.student.infrastructure;

import com.example.BS9.student.domain.models.Student;
import com.example.BS9.student.domain.repositories.StudentRepository;
import com.example.BS9.student.domain.services.StudentService;
import com.example.BS9.student.infrastructure.dto.InputStudentDto;
import com.example.BS9.student.infrastructure.dto.OutputStudentDto;
import com.example.BS9.student.infrastructure.dto.OutputStudentFullDto;
import com.example.BS9.subject.domain.models.Subject;
import com.example.BS9.subject.domain.repositories.SubjectRepository;
import com.example.BS9.subject.domain.services.SubjectService;
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
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectService subjectService;


    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestBody InputStudentDto student) throws Exception{

        System.out.println("En el controlador addStudent");

        studentService.addStudent(student);
        return "Estudiante creado correctamente";
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

    @PutMapping(value = "/addSubject/{idStudent}/{idSubject}")
    public ResponseEntity addAsignatura(@PathVariable String idStudent, @PathVariable String idSubject) throws Exception{
        Optional<Student> student = studentRepository.findById(idStudent);
        Optional<Subject> subject = subjectRepository.findById(idSubject);

        if(student.isEmpty()) return ResponseEntity.ok("No existe estudiante con ese id");
        if(subject.isEmpty()) return ResponseEntity.ok("No existe asignatura con ese id");

        System.out.println("Estudiante"+idStudent);
        System.out.println("Asignatura"+idSubject);

        List<Subject>subjects = student.get().getSubjects();
        List<Student>students = subject.get().getStudents();

        students.add(student.get());
        subjects.add(subject.get());


        student.get().setSubjects(subjects);
        subject.get().setStudents(students);


        studentRepository.save(student.get());

        return ResponseEntity.ok("Asignatura asignada");

    }

}

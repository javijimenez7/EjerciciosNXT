package com.example.EJS31.student.domain.services;

import com.example.EJS31.person.domain.models.Person;
import com.example.EJS31.person.domain.services.PersonService;
import com.example.EJS31.profesor.domain.models.Profesor;
import com.example.EJS31.profesor.domain.services.ProfesorService;
import com.example.EJS31.profesor.infrastructure.repositories.ProfesorRepository;
import com.example.EJS31.student.domain.models.Student;
import com.example.EJS31.student.infrastructure.dto.InputStudentDto;
import com.example.EJS31.student.infrastructure.dto.OutputStudentDto;
import com.example.EJS31.student.infrastructure.dto.OutputStudentFullDto;
import com.example.EJS31.student.infrastructure.repositories.StudentRepository;
import com.example.EJS31.subject.domain.models.Subject;
import com.example.EJS31.subject.infrastructure.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentI {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public ResponseEntity<?> addStudent(InputStudentDto studentDto) throws Exception {

        Optional<Person> person = personService.findById(studentDto.getPerson());
        Optional<Profesor> profesor = profesorService.findById(studentDto.getProfesor());


        //if para controlar si la persona asociada existe
        if (person.isPresent()) {
            Student student = new Student(studentDto);
            student.setPerson(person.get());

            //if para controlar si el profesor pasado a la hora de crear el estudiante existe
            if (profesor.isPresent()) {
                student.setProfesor(profesor.get());
            } else {
                return new ResponseEntity<>("Intentando asociar un profesor que no existe", HttpStatus.NOT_FOUND);
            }

            //if para controlar si la persona ya esta asignada a otro estudiante o a un profesor
            if (studentRepository.findByPersonId(person.get().getPerson_id()).isEmpty() && profesorRepository.findByPersonId(person.get().getPerson_id()).isEmpty()) {
                studentRepository.save(student);
                return new ResponseEntity<>("Estudiante guardado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error al insertar estudiante, la persona ya esta asociada a un estudiante o a un profesor", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public OutputStudentDto findById(String id) throws Exception {

        Student studentById = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado"));
        return new OutputStudentDto(studentById);

    }

    @Override
    public OutputStudentFullDto findFById(String id) throws Exception {

        Student studentById = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado"));
        return new OutputStudentFullDto(studentById);

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public String deletedById(String id) throws Exception {
        studentRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado al estudiante cuyo id es: " + id));
        studentRepository.deleteById(id);
        return "El estudiante cuyo es id es " + id + " ha sido borrado";
    }

    @Override
    public ResponseEntity addAsignaturas(String idStudent, List<String> ids) {

        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) return ResponseEntity.ok("No existe estudiante con ese id");
        List<Subject> subjectsFromStudent = student.get().getSubjects();

        for (String id : ids) {
            Optional<Subject> subject = subjectRepository.findById(id);
            if (subject.isPresent()) {
                subjectsFromStudent.add(subject.get());
                List<Student> studentsFromSubject = subject.get().getStudents();
                studentsFromSubject.add(student.get());

                student.get().setSubjects(subjectsFromStudent);
                subject.get().setStudents(studentsFromSubject);
            }
        }

        studentRepository.save(student.get());
        return ResponseEntity.ok("Asignatura asignada");
    }

    @Override
    public ResponseEntity removeAsignaturas(String idStudent, List<String> ids) {

        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) return ResponseEntity.ok("No existe estudiante con ese id");

        List<Subject> subjectsFromStudent = student.get().getSubjects();
        List<Subject> subjectsFromStudentToMap = new ArrayList<>(subjectsFromStudent);

        //realizo dos bucles para comprobar si algun id de asignatura coincide con los ids pasados
        for (Subject subject : subjectsFromStudentToMap) {
            for (String id : ids) {
                if (subject.getId_subject().equals(id)) {
                    Subject subjectToDelete = subjectRepository.findById(id).get();
                    subjectsFromStudent.remove(subjectToDelete);
                    subject.getStudents().remove(student.get());
                }
            }
        }
        student.get().setSubjects(subjectsFromStudent);

        studentRepository.save(student.get());
        return ResponseEntity.ok("Asignatura borrada");
    }
}

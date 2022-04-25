package com.example.EJS31.student.domain.models;

import com.example.EJS31.StringPrefixedSequenceIdGenerator;
import com.example.EJS31.person.domain.models.Person;
import com.example.EJS31.profesor.domain.models.Profesor;
import com.example.EJS31.student.infrastructure.dto.InputStudentDto;
import com.example.EJS31.subject.domain.models.Subject;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "student")
@Getter
@Setter

public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqE")
    @GenericGenerator(
            name = "seqE",
            strategy = "com.example.EJS31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STU"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id_student;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;

    @OneToOne
    @JoinColumn(name = "person_id")
    @NotNull
    Person person;

    @NotNull
    private Integer num_hours_week;

    @NotNull
    private String branch;

    private String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    public Student(InputStudentDto studentDto) throws Exception {

        setId_student(studentDto.getId_student());
        setBranch(studentDto.getBranch());
        setComents(studentDto.getComents());
        setNum_hours_week(studentDto.getNum_hours_week());
        setSubjects(studentDto.getSubjects());
    }

    public Student(){

    }
}

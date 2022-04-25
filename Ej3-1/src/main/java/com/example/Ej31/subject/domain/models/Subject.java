package com.example.Ej31.subject.domain.models;

import com.example.Ej31.StringPrefixedSequenceIdGenerator;
import com.example.Ej31.student.domain.models.Student;
import com.example.Ej31.subject.infrastructure.dto.InputSubjectDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subject")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_su")
    @GenericGenerator(
            name = "seq_su",
            strategy = "com.example.Ej31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SUB"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id_subject;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "student_subject",
            joinColumns = {@JoinColumn(name = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")}
    )
    @JsonIgnore
    private List<Student> students;

    private String subject_name;

    private String coments;

    private Date initial_date;

    private Date finish_date;


    public Subject(InputSubjectDto subjectDto){
        setId_subject(subjectDto.getId_subject());
        setComents(subjectDto.getComents());
        setStudents(subjectDto.getStudents());
        setFinish_date(subjectDto.getFinish_date());
        setInitial_date(subjectDto.getInitial_date());
        setSubject_name(subjectDto.getSubject_name());
    }

    public Subject(){}
}

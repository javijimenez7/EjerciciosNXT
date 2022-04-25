package com.example.Ej31.profesor.domain.models;

import com.example.Ej31.StringPrefixedSequenceIdGenerator;
import com.example.Ej31.person.domain.models.Person;
import com.example.Ej31.profesor.infrastructure.dto.InputProfesorDto;
import com.example.Ej31.student.domain.models.Student;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesor")
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqP")
    @GenericGenerator(
            name = "seqP",
            strategy = "com.example.Ej31.StringPrefixedSequenceIdGenerator",
            parameters = {
                @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO"),
                @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )

    private String id_profesor;

    @OneToOne
    @JoinColumn(name = "person_id")
    Person person;

    @NotNull
    private String branch;

    private String coments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_profesor")
    private List<Student> students;


    public Profesor(InputProfesorDto profesorDto){
        setId_profesor(profesorDto.getProfesor_id());
        setBranch(profesorDto.getBranch());
        setComents(profesorDto.getComents());
        setStudents(profesorDto.getStudents());
    }

    public Profesor(){

    }
}

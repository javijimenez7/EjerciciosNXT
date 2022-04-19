package com.example.BS9.profesor.domain.services;


import com.example.BS9.person.domain.repositories.PersonRepository;
import com.example.BS9.profesor.domain.models.Profesor;
import com.example.BS9.profesor.domain.repositories.ProfesorRepository;
import com.example.BS9.profesor.infrastructure.dto.InputProfesorDto;
import com.example.BS9.profesor.infrastructure.dto.OutputProfesorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService implements ProfesorI {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private PersonRepository personRepository;


    @Override
    public OutputProfesorDto addProfesor(InputProfesorDto profesorDto) throws Exception{

        if(profesorDto.getPerson().getUser().length()< 0 || profesorDto.getPerson().getUser().length()>10){
            throw new Exception("El usuario debe tener entre 0 y 10 caracteres");
        } else {
            Profesor profesor = new Profesor(profesorDto);
            personRepository.save(profesor.getPerson());
            profesorRepository.save(profesor);

            OutputProfesorDto saveOutputDTO = new OutputProfesorDto(profesor);
            return saveOutputDTO;

        }
    }


    @Override
    public OutputProfesorDto findById(String id) throws Exception{

        Profesor profesorById = profesorRepository.findById(id).orElseThrow(()-> new Exception("No se ha encontrado"));
        return new OutputProfesorDto(profesorById);

    }

    @Override
    public List<Profesor> findAll(){
        return profesorRepository.findAll();
    }

    @Override
    public String deletedById(String id) throws Exception{
        profesorRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado al profesor cuyo id es: "+id));
        profesorRepository.deleteById(id);
        personRepository.deleteById(Integer.parseInt(id));
        return "El profesor cuyo es id es "+id+" ha sido borrado";
    }
}

package com.example.BS9.profesor.infrastructure;

import com.example.BS9.profesor.domain.models.Profesor;
import com.example.BS9.profesor.domain.services.ProfesorService;
import com.example.BS9.profesor.infrastructure.dto.InputProfesorDto;
import com.example.BS9.profesor.infrastructure.dto.OutputProfesorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/profesor")
@RestController
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addProfesor")
    public String addStudent(@RequestBody InputProfesorDto profesor) throws Exception{

        System.out.println("En el controlador addProfesor");

        profesorService.addProfesor(profesor);
        return "Profesor creado correctamente";
    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getProfesores")
    public List<Profesor> getProfesores(){
        System.out.println("En el controlador getProfesores");
        return profesorService.findAll();
    }

    //Request para obtener el profesor cuyo id se para por parámetro
    @GetMapping(value = "/getProfesor/{id}")
    public OutputProfesorDto getProfesorById(@PathVariable String id) throws Exception{
        return profesorService.findById(id);
    }

    //Request para eliminar la persona cuyo id se para por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        profesorService.deletedById(id);
        return "El profesor con id "+id+" ha sido eliminada de la base de datos";

    }

}

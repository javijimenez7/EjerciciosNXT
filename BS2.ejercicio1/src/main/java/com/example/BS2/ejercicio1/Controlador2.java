package com.example.BS2.ejercicio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired
    PersonaService personaService;


    @GetMapping(value = "/controlador2", produces = "application/json" )

    public ResponseEntity<Persona> multiplicaEdad() {

        Persona persona = new Persona();

        persona.setEdad(personaService.getEdad()*2);
        persona.setNombre(personaService.getNombre());
        persona.setPoblacion(personaService.getPoblacion());


        return ResponseEntity.ok(persona);
    }
}

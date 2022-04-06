package com.example.BS2.ejercicio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;


    @PostMapping(value = "/persona", consumes = "application/json", produces = "application/json" )

    public ResponseEntity<Persona> persona(@RequestBody Persona persona) {


        personaService.setEdad(persona.getEdad());
        personaService.setNombre(persona.getNombre());
        personaService.setPoblacion(persona.getPoblacion());

        return ResponseEntity.ok(persona);
    }

}

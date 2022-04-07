package com.example.BS2.ejercicio1.persona.controller;

import com.example.BS2.ejercicio1.persona.domain.Persona;
import com.example.BS2.ejercicio1.persona.domain.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired
    private PersonaService personaService;

    @GetMapping(value = "/controlador2")
    public ResponseEntity<Persona> multiplicaEdad() {
        Persona persona = personaService.getPersona();
        persona.setEdad(persona.getEdad()*2);

        return ResponseEntity.ok(persona);
    }
}

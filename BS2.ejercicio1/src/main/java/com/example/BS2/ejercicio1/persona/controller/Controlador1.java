package com.example.BS2.ejercicio1.persona.controller;

import com.example.BS2.ejercicio1.persona.domain.Persona;
import com.example.BS2.ejercicio1.persona.domain.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired
    private PersonaService personaService;

    @PostMapping(value = "/persona")
    public ResponseEntity<Persona> persona(@RequestBody Persona persona) {
        personaService.setPersona(persona);
        return ResponseEntity.ok(persona);
    }
}

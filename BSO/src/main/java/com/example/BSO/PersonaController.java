package com.example.BSO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController

public class PersonaController {
    @GetMapping("/user/{nombre}")
    public String obtienePersona(@PathVariable String nombre) {
        return "Hola "+ nombre;

    }


    @PostMapping("/useradd")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {
        persona.setAgePlusOne();
        return ResponseEntity.ok(persona);
    }
}

package com.example.BS2.ejercicio1.persona.domain;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona persona = new Persona();

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public Persona getPersona(){
        return this.persona;
    }
}

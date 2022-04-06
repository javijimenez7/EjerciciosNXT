package com.example.BS2.ejercicio1;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    public String getPoblacion(){
        return persona.getPoblacion();
    }

    public Integer getEdad(){
        return persona.getEdad();
    }

    public void setEdad(Integer edad){
        persona.setEdad(edad);
    }

    public void setPoblacion(String poblacion){
        persona.setPoblacion(poblacion);
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }
}

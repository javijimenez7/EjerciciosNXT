package com.example.BS2.ejercicio3.Models;

public interface PersonaService {
    Integer getEdad();
    String getNombre();
    String getPoblacion();
    void setEdad(Integer edad);
    void setNombre(String nombre);
    void setPoblacion(String poblacion);
    Persona getPersona();

}

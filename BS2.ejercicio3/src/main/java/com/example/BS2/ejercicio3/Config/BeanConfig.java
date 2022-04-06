package com.example.BS2.ejercicio3.Config;

import com.example.BS2.ejercicio3.Models.Persona;
import com.example.BS2.ejercicio3.Models.PersonaService;
import com.example.BS2.ejercicio3.Models.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("bean1")
    public Persona getPersona1(){
        PersonaService personaService = new PersonaServiceImpl();
        personaService.setNombre("bean1");
        personaService.setEdad(8);
        return personaService.getPersona();
    }

    @Bean("bean2")
    public Persona getPersona2(){
        PersonaService personaService = new PersonaServiceImpl();
        personaService.setNombre("bean2");
        personaService.setEdad(74);
        return personaService.getPersona();
    }

    @Bean("bean3")
    public Persona getPersona3(){
        PersonaService personaService = new PersonaServiceImpl();
        personaService.setNombre("bean3");
        personaService.setEdad(41);
        return personaService.getPersona();
    }
}

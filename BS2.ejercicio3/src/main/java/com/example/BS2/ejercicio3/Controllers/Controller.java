package com.example.BS2.ejercicio3.Controllers;

import com.example.BS2.ejercicio3.Models.Persona;
import com.example.BS2.ejercicio3.Models.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PersonaService personaService;

    @Autowired
    @Qualifier("bean1")
    Persona persona1;

    @Autowired
    @Qualifier("bean2")
    Persona persona2;

    @Autowired
    @Qualifier("bean3")
    Persona persona3;


    @GetMapping("bean/{bean}")
    public Persona getBeanPersona(@PathVariable String bean){
        switch (bean){
            case "bean1" -> {
                return persona1;
            }

            case "bean2" -> {
                return persona2;
            }

            case "bean3" -> {
                return persona3;
            }
            default -> {
                return new Persona();
            }
        }
    }
}

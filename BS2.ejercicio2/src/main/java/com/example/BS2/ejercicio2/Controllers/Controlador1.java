package com.example.BS2.ejercicio2.Controllers;

import com.example.BS2.ejercicio2.Models.Ciudad;
import com.example.BS2.ejercicio2.Models.CiudadService;
import com.example.BS2.ejercicio2.Models.CiudadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador1 {

    @Autowired
    CiudadService ciudadService;



    @PostMapping(value = "/controlador1/addCiudad", consumes = "application/json", produces = "application/json")

    public String addCiudad(@RequestBody Ciudad ciudad) {

            ciudadService.addCiudad(ciudad);
            return "ciudad insertada";
    }
}

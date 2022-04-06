package com.example.BS2.ejercicio2.Controllers;

import com.example.BS2.ejercicio2.Models.Ciudad;
import com.example.BS2.ejercicio2.Models.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {


    @Autowired
    CiudadService ciudadService;


    @GetMapping(value = "/controlador2/getCiudad")

    public ResponseEntity<List> Ciudades() {

        return ResponseEntity.ok(ciudadService.getCiudades());
    }


}

package com.example.BS41.controllers;

import com.example.BS41.MyConfiguration;
import com.example.BS41.services.Perfil1;
import com.example.BS41.services.Perfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private MyConfiguration config;

    @Autowired
    private Perfiles perfil;

    @Value("${url}")
    private String url;

    @Value("${spring.profiles.active}")
    private String profileValue;

    @Value("${password}")
    private String password;


    @GetMapping(value = "/perfil")
    public String devuelvePerfil(){
        perfil.MyFunction();
        return profileValue;
    }

    @GetMapping(value = "/miconfiguracion")
    public String configuracion(){

        return "Valor1: "+config.getVar1()+", Valor2: "+config.getVar2();
    }

    @GetMapping(value = "/parametros")
    public String parametros(){

        return "Los valores de url son: "+ url +" y la password: "+password;
    }
}

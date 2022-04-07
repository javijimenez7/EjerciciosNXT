package com.example.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${var1}")
    private String var1;

    @Value("${var2}")
    private Integer var2;

    @Value("${var3:var3 no tiene valores}")
    private String var3;

    @GetMapping(value = "/valores")
    public String devuelveValores(){
        return "Valor de var1 es "+var1+" valor de var2 es "+var2;

    }

    @GetMapping(value = "/var")
    public String var3(){
        return "Valor de var3 es "+var3;

    }


}

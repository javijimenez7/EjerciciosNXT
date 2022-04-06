package com.example.BS2.ejercicio2.Models;

import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService{

    List<Ciudad> ciudades = new ArrayList<>();

    @Override
    public void addCiudad(Ciudad ciudad){
        ciudades.add(ciudad);
    }

    @Override
    public List<Ciudad>getCiudades(){
        return this.ciudades;
    }
}

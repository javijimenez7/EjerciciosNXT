package com.example.BSO;

import lombok.Data;


    @Data
    public class Persona {

        private String nombre;
        private String poblacion;
        private Integer edad;


        public void setAgePlusOne() {
            this.setEdad(this.getEdad()+1) ;
        }

    }
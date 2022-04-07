package com.example.BS3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Bs3Application {

    public static void main(String[] args) {
        SpringApplication.run(Bs3Application.class, args);

    }

	//Se ejecuta la función nada mas instanciarse
	@PostConstruct
	public void ejecutame () {
		System.out.println("Hola desde la clase inicial");

	}

	@Bean
	CommandLineRunner segundaClase(){
		return p->{
			System.out.println("Hola desde la clase secundaria");
		};
	}

	@Bean
	CommandLineRunner terceraClase(ApplicationArguments args){
		return p->{
			System.out.println("Soy la tercera clase");
			System.out.println("Argumentos");
			System.out.println(Arrays.toString(args.getSourceArgs()));
		};
	}

}

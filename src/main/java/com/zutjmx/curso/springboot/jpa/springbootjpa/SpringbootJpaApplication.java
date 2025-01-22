package com.zutjmx.curso.springboot.jpa.springbootjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zutjmx.curso.springboot.jpa.springbootjpa.entities.Persona;
import com.zutjmx.curso.springboot.jpa.springbootjpa.repositories.PersonaRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ejecutando el método run de la interfaz CommandLineRunner");
		List<Persona> personas = (List<Persona>) personaRepository.findAll();
		
		System.out.println("Listado de personas usando un forEach con expresión lambda");
		personas.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Busqueda de personas por lenguaje de programación");
		List<Persona> personasRank = personaRepository.findByLenguajeProgramacion("Rank");
		personasRank.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Busqueda de personas por nombre");
		List<Persona> personasNombre = personaRepository.findByNombre("Papagena");
		personasNombre.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Busqueda de personas por email");
		List<Persona> personasEmail = personaRepository.findByEmail("aitzakovitz10@goodreads.com");
		personasEmail.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Busqueda de personas por apellido paterno");
		List<Persona> personasPaterno = personaRepository.buscarPorPaterno("Jeafferson");
		personasPaterno.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Busqueda de personas por apellidos paterno y materno");
		List<Persona> personasPaternoMaterno = personaRepository.buscarPorPaternoYMaterno(
			"Hannant", 
			"Godart"
		);
		personasPaternoMaterno.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Busqueda de personas por apellidos paterno y materno usando nomenclatura de Spring Data JPA");
		List<Persona> personasPaternoMaternoSpringDataJPA = personaRepository.findByPaternoAndMaterno(
			"Raveau", 
			"Pinson"
		);
		personasPaternoMaternoSpringDataJPA.stream().forEach(persona -> System.out.println(persona));

		System.out.println("Listado de personas con nombre, lenguaje de programación y email");
		List<Object[]> datosPersonas = personaRepository.obtenerDatosPersonas();
		datosPersonas.stream().forEach(persona -> {
			System.out.println("Nombre: " + persona[0]);
			System.out.println("Lenguaje de programación: " + persona[1]);
			System.out.println("Email: " + persona[2]);
		});

	}

}

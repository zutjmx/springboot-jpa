package com.zutjmx.curso.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.zutjmx.curso.springboot.jpa.springbootjpa.entities.Persona;
import com.zutjmx.curso.springboot.jpa.springbootjpa.repositories.PersonaRepository;
import com.zutjmx.curso.springboot.jpa.springbootjpa.util.FakeData;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private FakeData fakeData;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Opciones de la aplicación:");
		System.out.println("1 .- Listado de personas");
		System.out.println("2 .- encontrarUno");
		System.out.println("3 .- encontrarUnoLamda");
		System.out.println("4 .- encontrarUnoPersonalizado");
		System.out.println("5 .- encontrarUnoPorNombre");
		System.out.println("6 .- encontrarPorNombreLike");
		System.out.println("7 .- encontrarPorNombreContaining");
		System.out.println("8 .- crear");
		System.out.println("9 .- actualizar");
		System.out.println("10 .- eliminarPorId");
		System.out.println("11 .- eliminarPorObjeto");

		Scanner	scanner = new Scanner(System.in);
		System.out.println("Selecciona una opción:");
		int opcion = scanner.nextInt();

		switch (opcion) {
			case 1:
				listado();
				break;
			case 2:
				encontrarUno();
				break;
			case 3:
				encontrarUnoLamda();
				break;
			case 4:
				encontrarUnoPersonalizado();
				break;
			case 5:
				encontrarUnoPorNombre();
				break;
			case 6:
				encontrarPorNombreLike();
				break;
			case 7:
				encontrarPorNombreContaining();
				break;
			case 8:
				crear();
				break;
			case 9:
				actualizar();
				break;
			case 10:
				eliminarPorId();
				break;
			case 11:
				eliminarPorObjeto();
				break;
			default:
				System.out.println("Opción no válida");
				break;
		}

		scanner.close();
	}

	@Transactional
	public void crear() {
		System.out.println("Ejecutando el método crear de la interfaz CommandLineRunner");
		Persona persona = fakeData.getPersona();
		persona.setNombre(persona.getNombre());
		persona.setPaterno(persona.getPaterno());
		persona.setMaterno(persona.getMaterno());
		persona.setEmail(persona.getEmail());
		persona.setLenguajeProgramacion(persona.getLenguajeProgramacion());
		Persona personaCreada = personaRepository.save(persona);
		System.out.println("Persona creada: " + personaCreada);
		personaRepository.findById(personaCreada.getId()).ifPresent(personaEncontrada -> {
			System.out.println("Persona encontrada: " + personaEncontrada);
		});
	}

	@Transactional
	public void actualizar() {
		System.out.println("Ejecutando el método actualizar de la interfaz CommandLineRunner");
		Persona personaDatosActualizados = fakeData.getPersona();
		Long id = fakeData.getLong();
		System.out.println("Id de la persona a actualizar: " + id);
		Optional<Persona> optionalPersona = personaRepository.findById(id);
		if (optionalPersona.isPresent()) {
			Persona persona = optionalPersona.get();

			System.out.println("Persona encontrada: " + persona);
			
			persona.setNombre(personaDatosActualizados.getNombre());
			persona.setPaterno(personaDatosActualizados.getPaterno());
			persona.setMaterno(personaDatosActualizados.getMaterno());
			persona.setEmail(personaDatosActualizados.getEmail());
			persona.setLenguajeProgramacion(personaDatosActualizados.getLenguajeProgramacion());
			
			Persona personaActualizada = personaRepository.save(persona);
			
			personaRepository.findById(personaActualizada.getId()).ifPresent(personaEncontrada -> {
				System.out.println("Persona actualizada: " + personaEncontrada);
			});

		} else {
			System.out.println("No se encontró la persona con id " + id);
		}
	}

	@Transactional
	public void eliminarPorId() {
		System.out.println("Ejecutando el método eliminarPorId de la interfaz CommandLineRunner");
		Long id = fakeData.getLong();
		System.out.println("Id de la persona a eliminar: " + id);
		Optional<Persona> optionalPersona = personaRepository.findById(id);
		if (optionalPersona.isPresent()) {
			Persona persona = optionalPersona.get();
			System.out.println("Persona encontrada: " + persona);
			personaRepository.deleteById(persona.getId());
			System.out.println("Persona eliminada");
		} else {
			System.out.println("No se encontró la persona con id " + id);
		}
	}

	@Transactional
	public void eliminarPorObjeto() {
		System.out.println("Ejecutando el método eliminarPorObjeto de la interfaz CommandLineRunner");
		Long id = fakeData.getLong();
		System.out.println("Id de la persona a eliminar: " + id);
		Optional<Persona> optionalPersona = personaRepository.findById(id);
		if (optionalPersona.isPresent()) {
			Persona persona = optionalPersona.get();
			System.out.println("Persona encontrada: " + persona);
			personaRepository.delete(persona);			
			System.out.println("Persona eliminada");
		} else {
			System.out.println("No se encontró la persona con id " + id);
		}
	}

	@Transactional(readOnly = true)
	public void encontrarUnoPersonalizado() {
		System.out.println("Utilizando el método encontrarUno de PersonaRepository personalizado");
		Long id = 10L;
		Optional<Persona> optionalPersona = personaRepository.encontrarUno(id);
		if (optionalPersona.isPresent()) {
			System.out.println(optionalPersona.get());
		} else {
			System.out.println("No se encontró la persona con id " + id);
		}
	}

	@Transactional(readOnly = true)
	public void encontrarUnoPorNombre() {
		System.out.println("Utilizando el método encontrarUnoPorNombre de PersonaRepository personalizado");
		String nombre = "Sonia";
		Optional<Persona> optionalPersona = personaRepository.encontrarUnoPorNombre(nombre);
		if (optionalPersona.isPresent()) {
			System.out.println(optionalPersona.get());
		} else {
			System.out.println("No se encontró la persona con nombre " + nombre);
		}
	}

	@Transactional(readOnly = true)
	public void encontrarPorNombreLike() {
		System.out.println("Utilizando el método encontrarUnoPorNombreLike de PersonaRepository personalizado");
		String nombre = "S";
		personaRepository.encontrarUnoPorNombreLike(nombre).stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void encontrarPorNombreContaining() {
		System.out.println("Utilizando el método findByNombreContainig de PersonaRepository");
		String nombre = "ra";
		personaRepository.findByNombreContaining(nombre).stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void encontrarUno() {
		System.out.println("Utilizando el método findById de CrudRepository");
		Long id = 20L;
		Persona persona = null;
		Optional <Persona> optionalPersona = personaRepository.findById(id);
		if (optionalPersona.isPresent()) {
			persona = optionalPersona.get();			
		} else {
			System.out.println("No se encontró la persona con id " + id);
		}
		System.out.println(persona);
	}

	@Transactional(readOnly = true)
	public void encontrarUnoLamda() {
		System.out.println("Utilizando el método findById de CrudRepository con expresión lambda");
		Long id = 15L;
		personaRepository.findById(id).ifPresent(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void listado() {
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

package com.zutjmx.curso.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.zutjmx.curso.springboot.jpa.springbootjpa.dto.PersonaDto;
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
		System.out.println("12 .- obtenerNombrePorId");
		System.out.println("13 .- obtenerNombreCompletoPorId");
		System.out.println("14 .- obtenerDatosPersonasCompletos");
		System.out.println("15 .- obtenerDatosPersonasCompletosPorId");
		System.out.println("16 .- obtenerListadoPersonasMix");
		System.out.println("17 .- obtenerListadoClasePersona");
		System.out.println("18 .- obtenerListadoClasePersonaDto");
		System.out.println("19 .- listarNombres");
		System.out.println("20 .- listarLenguajesDeProgramacion");
		System.out.println("21 .- conteoLenguajes");
		System.out.println("22 .- listadoNombreCompleto");
		System.out.println("23 .- listarPorRangoId");
		System.out.println("24 .- listarPorRangoNombre");
		System.out.println("25 .- listadoUsandoBetweenId");
		System.out.println("26 .- listadoUsandoBetweenNombre");
		System.out.println("27 .- encontrarPorRangoDeId");
		System.out.println("28 .- encontrarPorRangoDeNombre");
		System.out.println("29 .- Listar Personas con orden");
		System.out.println("30 .- Listar Personas con orden usando findAllByOrderByNombreAsc");

		Scanner	scanner = new Scanner(System.in);
		System.out.println("Selecciona una opción:");
		int opcion = scanner.nextInt();
		scanner.close();

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
			case 12:
				obtenerNombrePorId();
				break;
			case 13:
				obtenerNombreCompletoPorId();
				break;
			case 14:
				obtenerDatosPersonasCompletos();
				break;
			case 15:
				obtenerDatosPersonasCompletosPorId();
				break;
			case 16:
				obtenerListadoPersonasMix();
				break;
			case 17:
				obtenerListadoClasePersona();
				break;
			case 18:
				obtenerListadoClasePersonaDto();
				break;
			case 19:
				listarNombres();
				break;
			case 20:
				listarLenguajesDeProgramacion();
				break;
			case 21:
				conteoLenguajes();
				break;
			case 22:
				listadoNombreCompleto();
				break;
			case 23:
				listarPorRangoId();
				break;
			case 24:
				listarPorRangoNombre();
				break;
			case  25:
				listadoUsandoBetweenId();
				break;
			case 26:
				listadoUsandoBetweenNombre();
				break;
			case 27:
				encontrarPorRangoDeId();
				break;
			case 28:
				encontrarPorRangoDeNombre();
				break;
			case 29:
				listarPersonas();
				break;
			case 30:
				listadoPorNombreMetodoOrdenado();
				break;
			default:
				System.out.println("Opción no válida");
				break;
		}
		
	}

	@Transactional(readOnly = true)
	public void listadoPorNombreMetodoOrdenado() {
		System.out.println("Ejecutando el método findAllByOrderByNombreAsc de PersonaRepository");
		List<Persona> personas = (List<Persona>) personaRepository.findAllByOrderByNombreAsc();
		System.out.println("Listado de personas usando un forEach con expresión lambda");
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		System.out.println("Utilizando el método listarPersonas de PersonaRepository personalizado");
		List<Persona> personas = personaRepository.listarPersonasConOrden();
		personas.stream().forEach(persona -> System.out.println(persona));
		return personas;
	}

	@Transactional(readOnly = true)
	public void encontrarPorRangoDeId() {
		System.out.println("Utilizando el método encontrarPorRangoDeId de PersonaRepository personalizado");
		Long id1 = 10L;
		Long id2 = 20L;
		List<Persona> personas = personaRepository.encontrarPorRangoDeId(id1, id2);
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void encontrarPorRangoDeNombre() {
		System.out.println("Utilizando el método encontrarPorRangoDeNombre de PersonaRepository personalizado");
		String nombre1 = "A";
		String nombre2 = "D";
		List<Persona> personas = personaRepository.encontrarPorRangoDeNombre(nombre1, nombre2);
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void listadoUsandoBetweenNombre() {
		System.out.println("Utilizando el método findAll de PersonaRepository");
		String nombre1 = "F";
		String nombre2 = "K";
		List<Persona> personas = personaRepository.findByNombreBetweenOrderByNombreDesc(nombre1, nombre2);
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void listadoUsandoBetweenId() {
		System.out.println("Utilizando el método findAll de PersonaRepository");
		Long id1 = 10L;
		Long id2 = 20L;
		List<Persona> personas = personaRepository.findByIdBetweenOrderByIdAsc(id1, id2);
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void listarPorRangoNombre() {
		String nombre1 = "D";
		String nombre2 = "H";
		System.out.println("Utilizando el método findAll de PersonaRepository");
		List<Persona> personas = personaRepository.listarPorRangoNombre(nombre1, nombre2);
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void listarPorRangoId() {
		Long desde = 10L;
		Long hasta = 40L;
		System.out.println("Utilizando el método findAll de PersonaRepository");
		List<Persona> personas = personaRepository.listarPorRangoId(desde, hasta);
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void listadoNombreCompleto() {
		System.out.println("Utilizando el método findAll de PersonaRepository");
		List<String> nombres = personaRepository.listadoNombreCompleto();
		nombres.stream().forEach(nombre -> System.out.println(nombre));
	}

	@Transactional(readOnly = true)
	public void conteoLenguajes() {
		System.out.println("Utilizando el método conteoLenguajes de PersonaRepository personalizado");
		Long conteo = personaRepository.listarLenguajesDeProgramacionConteo();
		System.out.println("El conteo de lenguajes es: " + conteo);
	}

	@Transactional(readOnly = true)
	public void listarLenguajesDeProgramacion() {
		System.out.println("Utilizando el método listarLenguajesDeProgramacion de PersonaRepository personalizado");
		List<String> lenguajes = personaRepository.listarLenguajesDeProgramacion();
		lenguajes.stream().forEach(lenguaje -> System.out.println(lenguaje));
	}

	@Transactional(readOnly = true)
	public void listarNombres() {
		System.out.println("Utilizando el método listarNombres de PersonaRepository personalizado");
		List<String> nombres = personaRepository.listarNombres();
		nombres.stream().forEach(nombre -> System.out.println(nombre));
	}

	@Transactional(readOnly = true)
	private void obtenerListadoClasePersonaDto() {
		System.out.println("Utilizando el método obtenerListadoClasePersonaDto de PersonaRepository personalizado");
		List<PersonaDto> personasDto = personaRepository.obtenerListadoClasePersonaDto();
		personasDto.stream().forEach(persona -> System.out.println(persona));		
	}

	@Transactional(readOnly = true)
	public void obtenerListadoClasePersona() {
		System.out.println("Utilizando el método obtenerListadoClasePersona de PersonaRepository personalizado");
		List<Persona> personas = personaRepository.obtenerListadoClasePersona();
		personas.stream().forEach(persona -> System.out.println(persona));
	}

	@Transactional(readOnly = true)
	public void obtenerListadoPersonasMix() {
		System.out.println("Utilizando el método obtenerListadoPersonasMix de PersonaRepository personalizado");
		List<Object[]> datosPersonas = personaRepository.obtenerListadoPersonasMix();
		datosPersonas.stream().forEach(persona -> {
			System.out.println("Objeto persona: " + persona[0]);
			System.out.println("Id de la persona: " + persona[1]);
			System.out.println("Nombre: " + persona[2]);
			System.out.println("Apellido Paterno: " + persona[3]);
			System.out.println("Apellido Materno: " + persona[4]);
			System.out.println("Lenguaje de programación: " + persona[5]);
			System.out.println("Email: " + persona[6]);
		});
	}

	@Transactional(readOnly = true)
	public void obtenerDatosPersonasCompletosPorId() {
		System.out.println("Utilizando el método obtenerDatosPersonasCompletosPorId de PersonaRepository personalizado");
		Long id = fakeData.getLong();
		System.out.println("Id de la persona a buscar: " + id);
		Object[] datosPersona = (Object[]) personaRepository.obtenerDatosPersonasCompletosPorId(id);
		if (datosPersona == null) {
			System.out.println("No se encontró la persona con id " + id);
		} else {
			System.out.println("Datos de la persona con id: " + datosPersona[0]);
			System.out.println("Nombre: " + datosPersona[1]);
			System.out.println("Apellido Paterno: " + datosPersona[2]);
			System.out.println("Apellido Materno: " + datosPersona[3]);
			System.out.println("Lenguaje de programación: " + datosPersona[4]);
			System.out.println("Email: " + datosPersona[5]);
		}
	}

	@Transactional(readOnly = true)
	public void obtenerDatosPersonasCompletos() {
		System.out.println("Utilizando el método obtenerDatosPersonasCompletos de PersonaRepository personalizado");
		List<Object[]> datosPersonas = personaRepository.obtenerDatosPersonasCompletos();
		datosPersonas.stream().forEach(persona -> {
			System.out.println("Datos de la persona con id: " + persona[0]);
			System.out.println("Nombre: " + persona[1]);
			System.out.println("Apellido Paterno: " + persona[2]);
			System.out.println("Apellido Materno: " + persona[3]);
			System.out.println("Lenguaje de programación: " + persona[4]);
			System.out.println("Email: " + persona[5]);
		});
	}

	@Transactional(readOnly = true)
	public void obtenerNombreCompletoPorId() {
		System.out.println("Utilizando el método obtenerNombreCompletoPorId de PersonaRepository personalizado");
		Long id = fakeData.getLong();
		System.out.println("Id de la persona a buscar: " + id);
		String nombreCompleto = personaRepository.obtenerNombreCompletoPorId(id);
		if (nombreCompleto == null) {
			System.out.println("No se encontró la persona con id " + id);
		} else {
			System.out.println("Nombre completo de la persona con id " + id + ": " + nombreCompleto);
		}
	}

	@Transactional(readOnly = true)
	public void obtenerNombrePorId() {
		System.out.println("Utilizando el método obtenerNombrePorId de PersonaRepository personalizado");
		Long id = fakeData.getLong();
		System.out.println("Id de la persona a buscar: " + id);
		String nombre = personaRepository.obtenerNombrePorId(id);
		if (nombre == null) {
			System.out.println("No se encontró la persona con id " + id);
		} else {
			System.out.println("Nombre de la persona con id " + id + ": " + nombre);
		}
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

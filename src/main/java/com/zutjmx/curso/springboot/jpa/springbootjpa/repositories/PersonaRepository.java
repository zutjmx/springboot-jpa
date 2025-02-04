package com.zutjmx.curso.springboot.jpa.springbootjpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.springbootjpa.dto.PersonaDto;
import com.zutjmx.curso.springboot.jpa.springbootjpa.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

    @Query("SELECT p.nombre FROM Persona p WHERE p.id = ?1")
    String obtenerNombrePorId(Long id);

    @Query("SELECT concat(p.nombre, ' ', p.paterno, ' ', p.materno) FROM Persona p WHERE p.id = ?1")
    String obtenerNombreCompletoPorId(Long id);

    @Query("SELECT p FROM Persona p WHERE p.id = ?1")
    Optional<Persona> encontrarUno(Long id);

    @Query("SELECT p FROM Persona p WHERE p.nombre = ?1")
    Optional<Persona> encontrarUnoPorNombre(String nombre);

    @Query("SELECT p FROM Persona p WHERE p.nombre like %?1%")
    List<Persona> encontrarUnoPorNombreLike(String nombre);

    List<Persona> findByNombre(String nombre);
    List<Persona> findByNombreContaining(String nombre);

    List<Persona> findByEmail(String email);
    List<Persona> findByLenguajeProgramacion(String lenguajeProgramacion);

    @Query("SELECT p FROM Persona p WHERE p.paterno = ?1")
    List<Persona> buscarPorPaterno(String paterno);

    @Query("SELECT p FROM Persona p WHERE p.paterno = ?1 and p.materno = ?2")
    List<Persona> buscarPorPaternoYMaterno(String paterno, String materno);

    List<Persona> findByPaternoAndMaterno(String paterno, String materno);

    @Query(
        "SELECT p.nombre, p.lenguajeProgramacion, p.email FROM Persona p"
    )
    List<Object[]> obtenerDatosPersonas();

    @Query(
        "SELECT p.id, p.nombre, p.paterno, p.materno, p.lenguajeProgramacion, p.email FROM Persona p"
    )
    List<Object[]> obtenerDatosPersonasCompletos();

    @Query(
        "SELECT p.id, p.nombre, p.paterno, p.materno, p.lenguajeProgramacion, p.email FROM Persona p where p.id = ?1"
    )
    Object obtenerDatosPersonasCompletosPorId(Long id);

    @Query(
        "SELECT p, p.id, p.nombre, p.paterno, p.materno, p.lenguajeProgramacion, p.email FROM Persona p"
    )
    List<Object[]> obtenerListadoPersonasMix();

    @Query(
        "SELECT new Persona(p.nombre, p.paterno, p.materno) FROM Persona p"
    )
    List<Persona> obtenerListadoClasePersona();

    @Query(
        "SELECT new com.zutjmx.curso.springboot.jpa.springbootjpa.dto.PersonaDto(p.nombre, p.paterno, p.materno, p.email, p.lenguajeProgramacion) FROM Persona p"
    )
    List<PersonaDto> obtenerListadoClasePersonaDto();

    @Query(
        "SELECT DISTINCT(p.nombre) FROM Persona p"
    )
    List<String> listarNombres();
    
}

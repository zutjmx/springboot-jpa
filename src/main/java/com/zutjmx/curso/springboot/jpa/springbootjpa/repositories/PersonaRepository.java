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

    /**
     * Retrieves a list of PersonaDto objects that represent Persona entities.
     * The PersonaDto objects are created by projecting the Persona entity properties
     * (nombre, paterno, materno, email, lenguajeProgramacion) into a DTO.
     *
     * @return a list of PersonaDto objects
     */
    @Query(
        "SELECT new com.zutjmx.curso.springboot.jpa.springbootjpa.dto.PersonaDto(p.nombre, p.paterno, p.materno, p.email, p.lenguajeProgramacion) FROM Persona p"
    )
    List<PersonaDto> obtenerListadoClasePersonaDto();

    /**
     * Retrieves a list of distinct names of Persona entities.
     *
     * @return a list of distinct names of Persona entities
     */
    @Query(
        "SELECT DISTINCT(p.nombre) FROM Persona p"
    )
    List<String> listarNombres();

    @Query(
        "SELECT DISTINCT(p.lenguajeProgramacion) FROM Persona p"
    )
    List<String> listarLenguajesDeProgramacion();

    @Query(
        "SELECT COUNT(DISTINCT(p.lenguajeProgramacion)) FROM Persona p"
    )
    Long listarLenguajesDeProgramacionConteo();

    //@Query("SELECT concat(p.nombre, ' ', p.paterno, ' ', p.materno) FROM Persona p")
    //@Query("SELECT p.nombre || ' ' || p.paterno || ' ' || p.materno FROM Persona p")
    //@Query("SELECT upper(p.nombre || ' ' || p.paterno || ' ' || p.materno) FROM Persona p")
    @Query("SELECT lower(p.nombre || ' ' || p.paterno || ' ' || p.materno) FROM Persona p")
    List<String> listadoNombreCompleto();

    @Query("SELECT p FROM Persona p WHERE p.id between ?1 and ?2")
    List<Persona> listarPorRangoId(Long id1, Long id2);

    @Query("SELECT p FROM Persona p WHERE p.nombre between ?1 and ?2")
    List<Persona> listarPorRangoNombre(String nombre1, String nombre2);

    List<Persona> findByIdBetween(Long id1, Long id2);
    List<Persona> findByNombreBetween(String nombre1, String nombre2);
    
}

package com.zutjmx.curso.springboot.jpa.springbootjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.springbootjpa.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

    List<Persona> findByNombre(String nombre);
    List<Persona> findByEmail(String email);
    List<Persona> findByLenguajeProgramacion(String lenguajeProgramacion);

    @Query("SELECT p FROM Persona p WHERE p.paterno = ?1")
    List<Persona> buscarPorPaterno(String paterno);

    @Query("SELECT p FROM Persona p WHERE p.paterno = ?1 and p.materno = ?2")
    List<Persona> buscarPorPaternoYMaterno(String paterno, String materno);

    List<Persona> findByPaternoAndMaterno(String paterno, String materno);
}

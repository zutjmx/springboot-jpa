package com.zutjmx.curso.springboot.jpa.springbootjpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.springbootjpa.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}

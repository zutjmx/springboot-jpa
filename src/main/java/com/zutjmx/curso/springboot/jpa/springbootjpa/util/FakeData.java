package com.zutjmx.curso.springboot.jpa.springbootjpa.util;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.zutjmx.curso.springboot.jpa.springbootjpa.entities.Persona;

@Component
public class FakeData {

    private Faker faker = new Faker();

    public Persona getPersona() {
        Persona persona = new Persona();
        persona.setNombre(faker.name().firstName());
        persona.setPaterno(faker.name().lastName());
        persona.setMaterno(faker.name().lastName());        
        persona.setEmail(faker.internet().emailAddress());
        persona.setLenguajeProgramacion(faker.programmingLanguage().name());
        return persona;
    }

    public Long getLong() {
        return faker.number().numberBetween(1L, 100L);
    }

}

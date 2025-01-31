package com.zutjmx.curso.springboot.jpa.springbootjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String paterno;
    private String materno;
    private String email;

    @Column(name = "lenguaje_programacion")
    private String lenguajeProgramacion;

    public Persona() {
    }

    public Persona(String nombre, String paterno, String materno) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    public Persona(
        Long id, 
        String nombre, 
        String paterno, 
        String materno, 
        String email,
        String lenguajeProgramacion
    ) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String apellido) {
        this.paterno = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", email="
                + email + ", lenguajeProgramacion=" + lenguajeProgramacion + "]";
    }
}

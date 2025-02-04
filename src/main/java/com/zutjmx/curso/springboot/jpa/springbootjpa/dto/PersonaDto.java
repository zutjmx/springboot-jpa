package com.zutjmx.curso.springboot.jpa.springbootjpa.dto;

public class PersonaDto {
    private String nombre;
    private String paterno;
    private String materno;
    private String email;
    private String lenguajeProgramacion;

    public PersonaDto(String nombre, String paterno, String materno, String email, String lenguajeProgramacion) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
        this.lenguajeProgramacion = lenguajeProgramacion;
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
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public void setMaterno(String materno) {
        this.materno = materno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }
    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    @Override
    public String toString() {
        return "PersonaDto [nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", email=" + email
                + ", lenguajeProgramacion=" + lenguajeProgramacion + "]";
    }
}

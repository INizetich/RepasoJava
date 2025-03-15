package org.example.Models;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private String sexo;

    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.sexo = "";
    }

    public Persona(String nombre, int edad, String dni, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return
                "Nombre: '" + nombre + '\n' +
                        "Edad: " + edad + '\n' +
                        "DNI: " +  dni + '\n' +
                        "SEXO: " + sexo + '\n';
    }
}
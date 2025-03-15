package org.example.Models;

import org.example.Exc.ListaPersonaException;
import org.example.Models.Persona;
import java.util.List;

public class Curso {
    private String nombreCurso;
    private String codigo;
    private List<Persona> listaPersonas;

    public Curso(String nombreCurso, String codigo, List<Persona> listaPersonas) {
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.listaPersonas = listaPersonas;
    }

    public void agregarPersona(Persona persona) throws ListaPersonaException {
        if(listaPersonas.contains(persona)){
            throw new ListaPersonaException("La persona ya existe en la lista.\n");
        }
        else{
            this.listaPersonas.add(persona);
        }
    }

    public void  eliminarPersona(Persona persona) throws ListaPersonaException{
        if(listaPersonas.contains(persona)){
            listaPersonas.remove(persona);
        }
        else{
            throw new ListaPersonaException("La persona no existe en la lista.\n");
        }
    }



    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombreCurso='" + nombreCurso + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaPersonas=" + listaPersonas +
                '}';
    }
}
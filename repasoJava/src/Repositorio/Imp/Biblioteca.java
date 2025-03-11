package Repositorio.Imp;

import Exc.FechaLanzamientoException;
import Exc.GeneroInexistenteException;
import Exc.IdentificadorDuplicadoException;
import Exc.VersionJuegoException;
import Modelo.Clases.Expansion;
import Modelo.Clases.Item;
import Modelo.Clases.Juego;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca<T extends Item> {
    private Map<String,T> biblioteca;

    public Biblioteca(){
        this.biblioteca = new HashMap<>();
    }


    public Map<String ,T> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Map<String,T> biblioteca) {
        this.biblioteca = biblioteca;
    }


    public boolean agregarItem(T elemento) throws IdentificadorDuplicadoException, VersionJuegoException, FechaLanzamientoException {
        if(!biblioteca.containsKey(elemento.getIdentificacionUnica())){
            if(elemento instanceof Juego){
                if(((Juego)elemento).getNumeroVersion() <= 0){
                    throw new VersionJuegoException("La versión del juego debe ser mayor a 0.");
                }
            }
            if(elemento instanceof Expansion){
                if(((Expansion) elemento).getPublicacion() == null || ((Expansion) elemento).getPublicacion().isEmpty() ){
                    throw new FechaLanzamientoException("La fecha de lanzamiento no puede estar vacía.");
                }
            }
            biblioteca.put(elemento.getIdentificacionUnica() ,elemento);
            return true;

        }else {
            throw new IdentificadorDuplicadoException("identificador unico encontrado dentro de la biblioteca");
        }
    }


    public void mostrarBiblioteca(){

    for (T elemento : biblioteca.values()) {
        System.out.println(elemento.toString());

    }


    }


    public void filtrarBiblioteca(String genero) throws GeneroInexistenteException {

        /*otra alternativa a este codigo seria:
        * for (T elemento : biblioteca.values()){
        * if(elemento.getGenero().equals(genero){
        *      usamos la logica de abajo del stream de la filteredLibrary
        * break;
        * }else {
        *  throw new GeneroInexistenteException("el genero no se encuentra en la biblioteca");
        * }
        *}
        *
        *
        * */

        /* sirve para iterar en los valores del map con un stream y buscar una coincidencia en los generos con el genero pasado
        por parametro(devuelve true si encuentra un match o false en caso contrario)*/
        if(biblioteca.values().stream().anyMatch(elemento -> elemento.getGenero().equals(genero))){
            Map<String,T> filteredLibrary = biblioteca.entrySet().stream()
                    .filter(entry ->entry.getValue().getGenero().equals(genero))
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
            this.biblioteca = filteredLibrary;
        }else {
            throw new GeneroInexistenteException("el genero no se encuentra en la biblioteca");
        }
    }



    @Override
    public String toString() {
        return "Collection{" +
                "biblioteca=" + biblioteca +
                '}';
    }
}

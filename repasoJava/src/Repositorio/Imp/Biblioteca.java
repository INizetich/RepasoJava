package Repositorio.Imp;

import Exc.FechaLanzamientoException;
import Exc.IdentificadorDuplicadoException;
import Exc.VersionJuegoException;
import Modelo.Clases.Expansion;
import Modelo.Clases.Item;
import Modelo.Clases.Juego;

import java.util.HashMap;
import java.util.Map;

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



    @Override
    public String toString() {
        return "Collection{" +
                "biblioteca=" + biblioteca +
                '}';
    }
}

package Repositorio;

import Exc.*;
import Modelo.Clases.Expansion;
import Modelo.Clases.Item;
import Modelo.Clases.Juego;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.Thread;
public class Biblioteca<T extends Item>  {
    private Map<String,T> biblioteca;
        private static Scanner scanner = new Scanner(System.in);
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
            /// GUARDO EN UNA LISTA LOS JUEGOS Y EXPANSIONES
        List<Object> valores = new ArrayList<>(biblioteca.values());

        /// CREO UN COMPARATOR PARA COMPRARA LOS TITULOS
        Comparator<Object> comparadorPorTitulo = (o1,o2) -> {
            String titulo1 = "";
            String titulo2 = "";

            if(o1 instanceof Juego){
                titulo1 = ((Juego)o1).getNombre();
            }else if (o1 instanceof Expansion){
                titulo1 = ((Expansion)o1).getNombre();
            }

            if(o2 instanceof Juego){
                titulo2 = ((Juego)o2).getNombre();
            }else if (o2 instanceof Expansion){
                titulo2 = ((Expansion)o2).getNombre();
            }
            return titulo1.compareTo(titulo2);
        };
        /// AL SER VALORES UNA LIST PUEDO USAR EL SORT DONDE VOY A GUARDAR LO QUE ORDENE EL ALGORITMO QUE VA A HACER EL COMPARATOR
        valores.sort(comparadorPorTitulo);

        /// ACA MUESTRO LA LISTA DE VALORES
        System.out.println("BIBLIOTECA DE ITEMS:");
        for (Object valor : valores) {
            System.out.println(valor);
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

        System.out.println("Biblioteca filtrada con exito");
        mostrarBiblioteca();
    }


    public void modificarItem(String id) throws VersionJuegoException, FechaLanzamientoException {
        if (biblioteca.get(id) instanceof Juego) {
            System.out.println("Ingrese la nueva versión del juego:");

            // Bucle para solicitar la versión hasta que sea válida
            while (true) {
                try {
                    ((Juego)biblioteca.get(id)).setNumeroVersion(scanner.nextDouble()); // Lee la versión
                    if (((Juego)biblioteca.get(id)).getNumeroVersion() <= 0) {
                        throw new VersionJuegoException("La versión del juego debe ser mayor a 0.");
                    }
                    break; // Sale del bucle si la versión es válida
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número válido (por ejemplo, 1.5). Intente nuevamente.");
                    scanner.nextLine(); // Limpiar el buffer del Scanner
                }
            }
        }

        if (biblioteca.get(id) instanceof Expansion) {
            System.out.println("Ingrese la fecha de lanzamiento de la expansión:");
            ((Expansion)biblioteca.get(id)).setPublicacion(scanner.nextLine());

            if (((Expansion)biblioteca.get(id)).getPublicacion() == null || ((Expansion)biblioteca.get(id)).getPublicacion().isEmpty()) {
                throw new FechaLanzamientoException("La fecha de lanzamiento no puede estar vacia");

            }

        }
    }


    public void buscarPorID(String id) throws IdentificadorInexistenteException, InterruptedException {

        if(biblioteca.values().stream().anyMatch(elemento -> elemento.getIdentificacionUnica().equals(id))){
            if(biblioteca.get(id) instanceof Juego){
                System.out.println("Juego encontrado, cargando datos...");
                Thread.sleep(700);
                System.out.println(biblioteca.get(id).toString());
            }else if (biblioteca.get(id) instanceof Expansion){
                System.out.println("Expansion encontrada, cargando datos...");
                Thread.sleep(700);
                System.out.println(biblioteca.get(id).toString());
            }

        }else {
            throw new IdentificadorInexistenteException("el id no existe");
        }

    }


    public void eliminarItem(String id) throws IdentificadorInexistenteException{
        char eleccion = 's';

        if(biblioteca.values().stream().anyMatch(elemento -> elemento.getIdentificacionUnica().equals(id))){
            System.out.println("ID ENCONTRADO EN LA BIBLIOTECA...");
            System.out.println(biblioteca.get(id).toString());

            while(eleccion == 's'){
                System.out.println("desea eliminar de forma permanente el item? s/n");
                  eleccion = scanner.next().charAt(0);

                  if(eleccion == 's'){
                      biblioteca.remove(id);
                      System.out.println("Item removido correctamente!");
                      break;
                  }else {
                      break;
                  }
            }



        }else {
            throw new IdentificadorInexistenteException("el id no existe");
        }




    }
    @Override
    public String toString() {
        return "Collection{" +
                "biblioteca=" + biblioteca +
                '}';
    }

}




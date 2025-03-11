package Modelo.Clases;

import java.util.Objects;
import java.util.UUID;

public abstract class Item implements Comparable<Item> {

    private  String  identificacionUnica;
    private String nombre;
    private final double precio;
    private String genero;

    private String creador;

    private String clasificacion;


    public Item(){
        this.nombre = "";
        this.precio = 0.0;
        this.clasificacion = "";
        this.creador = "";
        this.genero = "";



    }


    public Item(String nombre, double precio, String clasificacion,String creador, String genero) {
        this.identificacionUnica = UUID.randomUUID().toString().substring(0,6);
        this.nombre = nombre;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.creador = creador;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        precio = precio;
    }

    public void setIdentificacionUnica(String identificacionUnica){
        this.identificacionUnica = identificacionUnica;
    }
    public String getClasificacion() {
        return clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getIdentificacionUnica() {
        return identificacionUnica;
    }


    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return
                "NOMBRE: " + nombre + '\n' +
                "ID: " + identificacionUnica + '\n' +
                "PRECIO: " + precio + '\n' +
                "GÉNERO: " + genero + '\n' +
                "CREADOR: " + creador + '\n' +
                "CLASIFICACIÓN: " + clasificacion + '\n';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(identificacionUnica, item.identificacionUnica);
    }



    @Override
    public int compareTo(Item o) {
        return this.identificacionUnica.compareTo(o.getIdentificacionUnica());
    }
}

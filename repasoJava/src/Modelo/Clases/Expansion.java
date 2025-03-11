package Modelo.Clases;

public class Expansion extends Item{
    private String publicacion;

    public Expansion(String publicacion) {
        this.publicacion = publicacion;
    }

    public Expansion(String nombre, double precio, String clasificacion, String creador, String publicacion,String genero) {
        super(nombre, precio, clasificacion, creador,genero);
        this.publicacion = publicacion;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "PUBLICACIÓN: " + publicacion + '\n';
    }
}

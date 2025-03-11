package Modelo.Clases;

public class Juego extends Item {
    private double numeroVersion;

    public Juego(){
        super();
        this.numeroVersion = 0.0;
    }

    public Juego(String nombre, double precio, String clasificacion,String creador, double numeroVersion,String genero){
        super(nombre, precio,  clasificacion,creador,genero);
        this.numeroVersion = numeroVersion;
    }


    public double getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(double numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    @Override
    public String toString() {
        return super.toString() +
                "VERSIÓN: " + numeroVersion + '\n';
    }
}

import Exc.*;
import Modelo.Clases.Expansion;
import Modelo.Clases.Juego;
import Repositorio.Imp.Biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        Juego juego = new Juego("fortnite",250, "pegi 18","epic games", 0.1,"battle royale");
        Juego juego2 = new Juego("free fire",250, "pegi 18","garena", 1.25,"battle royale");
        Expansion expansion = new Expansion("dlc", 50, "R", "Epic", "r" ,"wasa");




        Biblioteca biblioteca = new Biblioteca();

       try{
           biblioteca.agregarItem(juego);
           biblioteca.agregarItem(juego2);
           biblioteca.agregarItem(expansion);
       }catch (IdentificadorDuplicadoException e){
           e.printStackTrace();
           System.out.println(e.getMessage());
       }catch (VersionJuegoException a){
           a.printStackTrace();
           System.out.println(a.getMessage());
       }catch (FechaLanzamientoException e) {
           e.printStackTrace();
           System.out.println(e.getMessage());
       }finally {
           biblioteca.mostrarBiblioteca();
       }







try{
    System.out.println("ingrese el id del juego o expansion a buscar");
    String identificador = scanner.nextLine();
    biblioteca.buscarPorID(identificador);
}catch (IdentificadorInexistenteException e){
    e.printStackTrace();
}catch (InterruptedException e){
    e.printStackTrace();
}

try{
    System.out.println("ingrese el id del juego o expansion a borrar");
    String identificador = scanner.nextLine();
    biblioteca.eliminarItem(identificador);
}catch (IdentificadorInexistenteException e){
    e.printStackTrace();
}finally {
    biblioteca.mostrarBiblioteca();
}

    }
}
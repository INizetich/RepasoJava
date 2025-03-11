import Exc.FechaLanzamientoException;
import Exc.IdentificadorDuplicadoException;
import Exc.VersionJuegoException;
import Modelo.Clases.Expansion;
import Modelo.Clases.Juego;
import Repositorio.Imp.Biblioteca;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        Juego juego = new Juego("fortnite",250, "pegi 18","epic games", 0.1,"battle royale");
        Expansion expansion = new Expansion("dlc", 50, "R", "Epic", "r" ,"wasa");

        System.out.println(juego.toString());
        System.out.println(expansion.toString());


        Biblioteca biblioteca = new Biblioteca();

       try{
           biblioteca.agregarItem(juego);
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
       }


    }
}
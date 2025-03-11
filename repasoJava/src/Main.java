import Exc.FechaLanzamientoException;
import Exc.GeneroInexistenteException;
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
           System.out.println("biblioteca cargada con exito");
           biblioteca.mostrarBiblioteca();
       }



try{
    System.out.println("ingrese un genero a filtrar");
    String genero = scanner.nextLine();
    biblioteca.filtrarBiblioteca(genero);
}catch (GeneroInexistenteException e){
    e.printStackTrace();

}



    }
}
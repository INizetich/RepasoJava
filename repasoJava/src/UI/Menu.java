package UI;
import Exc.*;
import Modelo.Clases.Expansion;
import Modelo.Clases.Juego;
import Repositorio.Biblioteca;
import java.util.Scanner;
public class Menu {

 public static void MostrarMenu(){
     Scanner scanner = new Scanner(System.in);
     boolean continuar = true;
     Biblioteca biblioteca = new Biblioteca();
     int opc = 0;
     while (continuar){
         System.out.println("BIENVENIDO AL MENU DE USUARIOS");
         System.out.println("1.Agregar un juego o expansion");
         System.out.println("2.Eliminar un juego o expansion");
         System.out.println("3.Mostrar la biblioteca de items");
         System.out.println("4.Filtrar la biblioteca de items por genero");
         System.out.println("5.Modificar un item");
         System.out.println("6.Buscar un item por ID");
         System.out.println("7.Salir");
         System.out.println("Por favor, elija una opcion...");
         opc = scanner.nextInt();
         scanner.nextLine();

         switch (opc){
             case 1:
                 int opcionAgregar = 0;
                 System.out.println("desea agregar un juego o una expansion?");
                 System.out.println("1.Juego");
                 System.out.println("2.Expansion");
                 opcionAgregar = scanner.nextInt();
                 scanner.nextLine();
                 switch (opcionAgregar){
                     case 1:
                         char opcJuego;
                         do{
                             System.out.println("ingrese el nombre del juego");
                             String nombreJuego = scanner.nextLine();
                             System.out.println("ingrese el precio del juego");
                             double precioJuego = scanner.nextDouble();
                             scanner.nextLine();
                             System.out.println("ingrese el clasificacion del juego");
                             String clasificacionJuego = scanner.nextLine();
                             System.out.println("ingrese el creador del juego");
                             String creadorJuego = scanner.nextLine();
                             System.out.println("ingrese el numero version del juego");
                             double numeroVersionJuego = scanner.nextDouble();
                             scanner.nextLine();
                             System.out.println("ingrese el genero del juego");
                             String generoJuego = scanner.nextLine();
                             try{
                                 biblioteca.agregarItem(new Juego(nombreJuego,precioJuego,clasificacionJuego,creadorJuego,numeroVersionJuego,generoJuego));
                             }catch (IdentificadorDuplicadoException e){
                                 e.printStackTrace();
                             }catch (VersionJuegoException e){
                                 e.printStackTrace();
                             }catch (Exception e){
                                 e.printStackTrace();
                             }finally{
                                 System.out.printf("Juego agregado con exito, desea agregar otro juego? s/n");
                              opcJuego  = scanner.next().charAt(0);
                              scanner.nextLine();
                             }
                         }while (opcJuego == 's');

                         break;

                     case 2:
                         char opcExpansion;
                         do{
                             System.out.println("ingrese el nombre de la expansion");
                             String nombreExpansion = scanner.nextLine();
                             System.out.println("ingrese el precio de la expansion");
                             double precioExpansion = scanner.nextDouble();
                             scanner.nextLine();
                             System.out.println("ingrese el clasificacion de la expansion");
                             String clasificacionExpansion = scanner.nextLine();
                             System.out.println("ingrese el creador de la expansion");
                             String creadorExpansion = scanner.nextLine();
                             System.out.println("ingrese la fecha de lanzamiento de la expansion");
                             String fechaExpansion = scanner.nextLine();
                             System.out.println("ingrese el genero de la expansion");
                             String generoExpansion = scanner.nextLine();
                             try{
                                 biblioteca.agregarItem(new Expansion(nombreExpansion,precioExpansion,clasificacionExpansion,creadorExpansion,fechaExpansion,generoExpansion));
                             }catch (IdentificadorDuplicadoException e){
                                 e.printStackTrace();
                             }catch (FechaLanzamientoException e){
                                 e.printStackTrace();
                             }catch (Exception e){
                                 e.printStackTrace();
                             }finally{
                                 System.out.println("expansion agregada con exito, desea agregar otra expansion? s/n");
                                 opcExpansion = scanner.next().charAt(0);
                             }

                         }while (opcExpansion == 's');
                         break;



                 }

                 break;

             case 2:
                 char opcionBorrar;
                 System.out.println("desea ver la biblioteca de items? s/n");
                 opcionBorrar = scanner.next().charAt(0);
                 scanner.nextLine();

                 if(opcionBorrar == 's'){
                     biblioteca.mostrarBiblioteca();
                     try{
                         System.out.println("ingrese el ID del item a borrar");
                         String idUnico = scanner.nextLine();
                         biblioteca.eliminarItem(idUnico);
                     }catch (IdentificadorInexistenteException e){
                         e.printStackTrace();
                     }


                 }else if(opcionBorrar == 'n') {
                     break;
                 }



                 break;

             case 3:
                 biblioteca.mostrarBiblioteca();
                 break;

             case 4:
                 System.out.println("ingrese el genero a filtrar");
                 String generoAfiltrar = scanner.nextLine();
                 try{
                     biblioteca.filtrarBiblioteca(generoAfiltrar);

                 }catch (GeneroInexistenteException e){
                     e.printStackTrace();
                 }


                 break;

             case 5:
                 biblioteca.mostrarBiblioteca();
                 System.out.println("ingrese el ID del item a modificar");
                 String idItemAmodificar = scanner.nextLine();
                 try{
                     biblioteca.modificarItem(idItemAmodificar);
                 }catch (VersionJuegoException e){
                     e.printStackTrace();
                 }catch (FechaLanzamientoException e){
                     e.printStackTrace();
                 }

                 break;

             case 6:
                 System.out.println("ingrese el ID del item a buscar");
                 String idItemBuscar = scanner.nextLine();
                 try{
                     biblioteca.buscarPorID(idItemBuscar);
                 }catch (IdentificadorInexistenteException e){
                     e.printStackTrace();
                 }catch (InterruptedException e){
                     e.printStackTrace();
                 }

                 break;

             case 7:
                 System.out.println("gracias por usar nuestro sistema...");
              System.exit(0);
              continuar = false;

                 break;
         }
     }





 }



}

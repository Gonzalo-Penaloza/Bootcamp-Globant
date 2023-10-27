package EX02;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CantanteFamosoService {
    private List<CantanteFamoso> cantanteFamosos = new ArrayList<>();
    private List<String> changelog = new ArrayList<>();

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private boolean isActive = true;

    public void menu() {
        while (isActive) {
            System.out.println("---------APP CANTANTES---------");
            System.out.println("Ingrese la operacion a realizar");
            System.out.println("1. Registrar cantante");
            System.out.println("2. Eliminar cantante");
            System.out.println("3. Mostrar disco de mayor ventas de determinado cantante");
            System.out.println("4. Mostrar todos los cantantes registrados");
            System.out.println("5. Salir");
            int choice = leer.nextInt();
            switch (choice) {
                case 1:
                    registrarCantante();
                    break;
                case 2:
                    eliminarCantante();
                    break;
                case 3:
                    obtenerDisco();
                    break;
                case 4:
                    mostrarListaCantantes();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema... Hasta la proxima!");
                    isActive = false;
                    mostrarChangelog();
                    break;
            }
        }
    }

    private void registrarCantante(){
        System.out.println("Ingrese el nombre del cantante:");
        String nombre = leer.next();
        System.out.println("Ingrese su disco de mayor venta:");
        String disco = leer.next();

        if(nombre.equals("") || disco.equals("")){
            System.out.println("El campo nombre o disco se encuentra vacio!   ...Volviendo al menu principal");
        } else {
            cantanteFamosos.add(new CantanteFamoso(nombre,disco));
            System.out.println("Cantante registrado...!");
            changelog.add("Cantante " + nombre + " registrado..." );
        }
    }

    private void eliminarCantante(){
        CantanteFamoso c = obtenerCantante();

        if(c != null ) {
            System.out.println("Se ha eliminado el cantante {"+ c.getNombre() +"} con exito!");
            changelog.add("Cantante " + c.getNombre() + " eliminado..." );
        }
    }

    private void obtenerDisco(){
        CantanteFamoso c = obtenerCantante();

        if(c != null) System.out.println("Cantante {"+c.getNombre()+"} -> Disco de mayor ventas: " + c.getDiscoConMasVentas());
    }

    private void mostrarListaCantantes(){
        int cont = 1;

        System.out.println("Lista de cantantes registrados");
        for(CantanteFamoso c : cantanteFamosos){
            System.out.println(cont + ". " + c.getNombre());
            cont++;
        }
    }

    private void mostrarChangelog(){
        for (String s: changelog) {
            System.out.println(s);
        }
    }


    private CantanteFamoso obtenerCantante(){
        System.out.println("Ingrese el nombre del cantante:");
        String answer = leer.next();

        for(CantanteFamoso c : cantanteFamosos){
            if(c.getNombre().equals(answer)) {
                return c;
            }
        }
        System.out.println("El cantando {"+answer+"} no se encuentra registrado!");
        return null;
    }
}

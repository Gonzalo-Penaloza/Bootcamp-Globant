package EJ04;

import EJ03.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PeliculaService {
    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public void registrarPelicula(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while(true){
            System.out.println("Ingrese el titulo de la pelicula:");
            String titulo = leer.next();
            System.out.println("Ingrese el director:");
            String director = leer.next();
            System.out.println("Ingrese la duracion:");
            int duracion = leer.nextInt();

            peliculas.add(new Pelicula(titulo,director,duracion));
            System.out.println("Pelicula registrada con exito!");

            System.out.println("Desea registrar otra pelicula? S/N");
            String answer = leer.next();

            if(answer.equalsIgnoreCase("N")) return;
        }
    }

    public void mostrarPeliculas(){
        System.out.println("Lista de Peliculas:");
        for (Pelicula p : peliculas){
            System.out.println(p);
        }
    }

    public void mostrarMayorQue(int duracion){
        System.out.println("Lista de peliculas mayores a "+duracion+" horas:");
        for (Pelicula p : peliculas){
            if(p.getDuracion()>duracion) {
                System.out.println(p);
            }
        }
    }

    public void ordenarPorDuracionAsc() {
        Comparator<Pelicula> comparadorPorDuracion = new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                // Comparar por el atributo duracion de menor a mayor
                return Integer.compare(p1.getDuracion(), p2.getDuracion());
            }
        };

        peliculas.sort(comparadorPorDuracion);

        System.out.println("Lista de peliculas ordenadas por duracion(menor-mayor):");
        for (Pelicula p : peliculas){
                System.out.println(p);
        }
    }

    public void ordenarPorDuracionDesc() {
        Comparator<Pelicula> comparadorPorDuracion = new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                // Comparar por el atributo duracion de menor a mayor
                return Integer.compare(p2.getDuracion(), p1.getDuracion());
            }
        };

        peliculas.sort(comparadorPorDuracion);

        System.out.println("Lista de peliculas ordenadas por duracion(mayor-menor):");
        for (Pelicula p : peliculas){
            System.out.println(p);
        }
    }

    public void ordenarTitulosAlfab() {
        Comparator<Pelicula> comparadorPorAlfabeto = new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                // Comparar por el atributo duracion de menor a mayor
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        };

        peliculas.sort(comparadorPorAlfabeto);

        System.out.println("Lista de peliculas ordenadas alfabeticamente por titulo:");
        for (Pelicula p : peliculas){
            System.out.println(p);
        }
    }



    public void ordenarDirectorAlfab() {
        Comparator<Pelicula> comparadorPorAlfabeto = new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                // Comparar por el atributo duracion de menor a mayor
                return p1.getDirector().compareTo(p2.getDirector());
            }
        };

        peliculas.sort(comparadorPorAlfabeto);

        System.out.println("Lista de peliculas ordenadas alfabeticamente por director:");
        for (Pelicula p : peliculas){
            System.out.println(p);
        }
    }
}



package EJ03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnoService {
    ArrayList<Alumno> alumnos = new ArrayList<>();

    public void registrarAlumnos(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while(true){
            System.out.println("Ingrese el nombre del alumno:");
            String nombre = leer.next();
            System.out.println("Ingrese la nota N°1:");
            int n1 = leer.nextInt();
            System.out.println("Ingrese la nota N°2:");
            int n2 = leer.nextInt();
            System.out.println("Ingrese la nota N°3:");
            int n3 = leer.nextInt();

            alumnos.add(new Alumno(nombre,n1,n2,n3));
            System.out.println("Alumno registrado con exito!");

            System.out.println("Desea registrar otro alumno? S/N");
            String answer = leer.next();

            if(answer.equalsIgnoreCase("N")) return;
        }

    }

    public void notaFinal(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del alumno para obtener su nota final:");
        String nombre = leer.next();

        for (Alumno a : alumnos){
            if(a.getNombre().equals(nombre)){
                System.out.println("El promedio final del alumno {"+a.getNombre()+"} es de: " + a.calcularPromedio());
                return;
            }
        }

        System.out.println("No se ha encontrado registro del alumno: {"+nombre+"}.");
    }
}

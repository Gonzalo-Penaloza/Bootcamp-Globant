package EJ01;

import java.util.ArrayList;
import java.util.Scanner;

//      1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
//        programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
//        después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
//        salir, se mostrará todos los perros guardados en el ArrayList.
public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<String> razas = new ArrayList<>();
        String answer;
        boolean isActive = true;

        while(isActive) {
            System.out.println("Ingresa una raza de perro:");
            answer = leer.next();
            razas.add(answer);
            System.out.println("Deseas ingresar otra raza? S/N");
            answer = leer.next();
            if(answer.equalsIgnoreCase("N")){
                isActive = false;
            }
        }

        System.out.println("Razas de perro agregados:");
        for (String s : razas) {
            System.out.println(s);
        }
    }

}

package EJ02;

//      2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
//        un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
//        está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
//        ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
//        la lista ordenada.

import java.util.*;

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

        System.out.println();
        System.out.println("Razas de perro agregados sin ordenar:");
        for (String s : razas) {
            System.out.println(s);
        }



        System.out.println("Ingrese el nombre de una raza para eliminar de lista:");
        answer = leer.next();

        Iterator<String> it = razas.iterator();

        while(it.hasNext()){
            if(it.next().equals(answer)){
                System.out.println("Se ha eliminado la raza {"+answer+"} de la lista!");
                razas.remove(answer);
            }
        }

        Collections.sort(razas);

        System.out.println();
        System.out.println("Lista de razas ordenadas:");
        for (String s : razas) {
            System.out.println(s);
        }
    }
}

package EJ05;

import java.util.*;

//      5.Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
//        usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
//        conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
//        si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
//        los servicios en la clase correspondiente)
//        Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
//        cómo se ordena un conjunto.
//        Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
//        buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
//        usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
//        al usuario.
public class PaisesService {
    private TreeSet<String> paises = new TreeSet<>();

    public void guardarPais(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while(true){
            System.out.println("Ingrese el nombre de pais a guardar:");
            String pais = leer.next();

            paises.add(pais);
            System.out.println("Pais guardado con exito!");

            if(!continuar()) {
                mostrarPaises();
                return;
            }
        }
    }

    public void eliminarPaisDeLista(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el pais a eliminar:");
        String pais = leer.next();

        Iterator<String> it = paises.iterator();

        while(it.hasNext()){
            if(it.next().equals(pais)){
                it.remove();
                System.out.println("Se ha eliminado el pais de la lista!");
                mostrarPaises();
                return;
            }
        }

        System.out.println("El pais ingresado no se encuentra en la lista!");
    }



    public boolean continuar(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("¿Desea guardar otro país? (S/N)");
            String answer = leer.next();

            if (answer.equalsIgnoreCase("S")) {
                return true; // El usuario desea guardar otro país.
            } else if (answer.equalsIgnoreCase("N")) {
                return false; // El usuario no desea guardar otro país.
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese 'S' o 'N'.");
            }
        }
    }

    public void mostrarPaises(){
        int cont = 1;

        System.out.println("Lista de paises:");

        for (String s : paises){
            System.out.println("Pais N°"+cont+": "+ s);
            cont++;
        }
    }

}

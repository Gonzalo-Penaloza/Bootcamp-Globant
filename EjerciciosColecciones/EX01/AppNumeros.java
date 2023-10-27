package EX01;

//       1. Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado y
//        los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
//        introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
//        programa mostrará por pantalla el número de valores que se han leído, su suma y su
//        media (promedio).


import java.util.ArrayList;
import java.util.Scanner;

public class AppNumeros {
    private ArrayList<Integer> listaNumeros = new ArrayList<>();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private static int cantidadTotal = 0;
    private boolean isActive = true;

    public void menu() {
        while (isActive) {
            System.out.println("---------APP NUMEROS---------");
            System.out.println("Ingrese la operacion a realizar");
            System.out.println("1. Introducir numeros");
            System.out.println("2. Mostrar cantidad de numeros ingresados");
            System.out.println("3. Sumar todos los numeros");
            System.out.println("4. Calcular promedio");
            System.out.println("5. Salir");
            int choice = leer.nextInt();
            switch (choice) {
                case 1:
                    ingresarNumeros();
                    break;
                case 2:
                    System.out.println("Cantidad de numeros ingresados: " + cantidadTotal);
                    break;
                case 3:
                    System.out.println("La suma de todos los numeros es: " + sumarNumeros());
                    break;
                case 4:
                    calcularPromedio();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema... Hasta la proxima!");
                    isActive = false;
                    break;
            }
        }
    }

    private void ingresarNumeros(){
        System.out.println("Ingrese un numero! para terminar de ingresar digite -99");
        while(true){
            int numIngresado = leer.nextInt();

            if(numIngresado == -99){
                System.out.println("Volviendo al menu principal...");
                return;
            }
            listaNumeros.add(numIngresado);
            cantidadTotal++;
        }
    }

    private int sumarNumeros(){
        int total = 0;

        for (Integer i : listaNumeros) {
            total+= i;
        }

        return total;
    }

    private void calcularPromedio(){
        double media = (double) sumarNumeros() / listaNumeros.size();
        System.out.println("El promedio de todos los numeros ingresados es de: " + media);
    }
}

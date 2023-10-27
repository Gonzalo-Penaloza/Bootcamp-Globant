package EX5_POO;

import java.util.Scanner;

//5.    Crea una clase en Java donde declares una variable de tipo array de Strings que
    //        contenga los doce meses del año, en minúsculas. A continuación, declara una variable
    //        mesSecreto de tipo String, y hazla igual a un elemento del array (por ejemplo,
    //        mesSecreto = mes[9]. El programa debe pedir al usuario que adivine el mes secreto. Si el
    //        usuario acierta mostrar un mensaje, y si no lo hace, pedir que vuelva a intentar adivinar
    //        el mes secreto. Un ejemplo de ejecución del programa podría ser este:
    //        Adivine el mes secreto. Introduzca el nombre del mes en minúsculas: febrero
    //        No ha acertado. Intente adivinarlo introduciendo otro mes: agosto
    //        ¡Ha acertado!
public class AdivinarMes {
        public static void main(String[] args) {
            String[] meses = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
            String mesSecreto = meses[8];
            String eleccion;

            Scanner leer = new Scanner(System.in);

            System.out.println("Adivine el mes secreto!");
            System.out.println("Introduzca el nombre del mes en minisculas:");
            eleccion = leer.next();

            while(true){
                if(eleccion.equals(mesSecreto)){
                    System.out.println("¡Ha acertado!");
                    break;
                } else {
                    System.out.println("Intente adivinarlo introduciendo otro mes:");
                    eleccion = leer.next();
                }
            }
        }



}

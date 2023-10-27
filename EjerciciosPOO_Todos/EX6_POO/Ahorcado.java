package EX6_POO;

import java.util.Scanner;

//       Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá contener
//        como atributos, un vector con la palabra a buscar, la cantidad de letras encontradas y la
//        cantidad jugadas máximas que puede realizar el usuario. Definir los siguientes métodos
//        con los parámetros que sean necesarios:
//         Constructores, tanto el vacío como el parametrizado.
//         Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima.
//        Con la palabra del usuario, pone la longitud de la palabra, como la longitud del
//        vector. Después ingresa la palabra en el vector, letra por letra, quedando cada letra
//        de la palabra en un índice del vector. Y también, guarda en cantidad de jugadas
//        máximas, el valor que ingresó el usuario y encontradas en 0.
//         Método longitud(): muestra la longitud de la palabra que se debe encontrar. Nota:
//        buscar como se usa el vector.length.
//         Método buscar(letra): este método recibe una letra dada por el usuario y busca sila
//        letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
//         Método encontradas(letra): que reciba una letra ingresada por el usuario y muestre
//        cuantas letras han sido encontradas y cuantas le faltan. Este método además deberá
//        devolver true si la letra estaba y false si la letra no estaba, ya que, cada vez que se
//        busque una letra que no esté, se le restará uno a sus oportunidades.
//         Método intentos(): para mostrar cuantas oportunidades le queda al jugador.
//         Método juego(): el método juego se encargará de llamar todos los métodos
//        previamente mencionados e informará cuando el usuario descubra toda la palabra o
//        se quede sin intentos. Este método se llamará en el main.
public class Ahorcado {
    private String[] palabra;
    private int cantLetras = 0;
    private int intentosRestantes;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabra, int cantLetras, int intentosRestantes) {
        this.palabra = palabra;
        this.cantLetras = cantLetras;
        this.intentosRestantes = intentosRestantes;
    }

    //TODO: METODOS SOLICITADOS

    public void crearJuego(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese la palabra a buscar:");
        String palabraAux = leer.next();

        System.out.println("Ingrese la cantidad de intentos:");
        intentosRestantes = leer.nextInt();

        int length = palabraAux.length();
        palabra = new String[length];

        for (int i = 0; i < length ; i++) {
            palabra[i] = palabraAux.substring(i,i+1);
        }
    }

    public void longitud(){
        System.out.println("Longitud de la palabra: " + palabra.length);
    }

    public boolean buscar(String letra){
        for (String i: palabra) {
            if(i.equals(letra)) {
                System.out.println("Mensaje: La letra pertenece a la palabra");
                return true;
            }
        }
        System.out.println("Mensaje: La letra no pertenece a la palabra");
        return false;
    }

    public boolean encontradas(String letra){
        boolean estaEnPalabra = buscar(letra);

        if(estaEnPalabra){
            cantLetras++;
        } else {
            intentosRestantes--;
        }

        System.out.println("Numero de letras (encontradas/faltantes): (" + cantLetras + "," + (palabra.length - cantLetras) + ")");
        return estaEnPalabra;
    }

    public void intentos(){
        if(intentosRestantes>0){
            System.out.println("Número de oportunidades restantes: " + intentosRestantes);
        } else {
            System.out.println("Lo sentimos, no hay más oportunidades");
        }

    }

    public String palabraDeHoy(){
        String aux = "";
        for(String i : palabra){
            aux = aux.concat(i);
        }
        return aux;
    }

    public void juego(){
        Scanner leer = new Scanner(System.in);
        String letraIngresada;

        while(true){
            System.out.println("Ingrese una letra:");
            letraIngresada = leer.next();

            longitud();
            encontradas(letraIngresada);


            if(intentosRestantes == 0){
                System.out.println("No has tenido exito con la palabra de hoy (" + palabraDeHoy() + "), intentalo nuevamente mañana!");
                break;
            } else if ( cantLetras == palabra.length ) {
                System.out.println("Felicidades! Has adivinado la palabra de hoy (" + palabraDeHoy() + "), vuelve mañana para intentar adivinar la proxima palabra!");
                break;
            } else {
                intentos();
                System.out.println("------------------------------");
            }
        }
    }


}

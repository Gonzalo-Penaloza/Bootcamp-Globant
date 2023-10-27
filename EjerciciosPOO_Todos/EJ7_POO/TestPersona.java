package EJ7_POO;

import java.util.Arrays;

public class TestPersona {
    public static void main(String[] args) {
        PersonaService personaSrv = new PersonaService();
        Persona[] personas = new Persona[4];
        int bajoPeso = 0;
        int pesoIdeal = 0;
        int sobrePeso = 0;
        int mayorEdad = 0;
        int menorEdad = 0;



        //lectura de datos

        for (int i = 0; i < personas.length; i++) {
            personas[i] = personaSrv.crearPersona();

            switch (personaSrv.calcularIMC(personas[i])) {
                case -1:
                    bajoPeso++;
                    break;
                case 0:
                    pesoIdeal++;
                    break;
                case 1:
                    sobrePeso++;
                    break;
                default:
                    break;
            }

            if(personaSrv.esMayorDeEdad(personas[i])){
                mayorEdad++;
            } else {
                menorEdad--;
            }
        }

        System.out.println("Bajo Peso: " + (bajoPeso*100/personas.length) + "%\nPeso ideal: " + (pesoIdeal*100/personas.length) + "%\nSobrepeso: " +
                (sobrePeso*100/personas.length) + "%"
        );

        System.out.println("Mayores de edad: " + (mayorEdad*100/personas.length) + "%\nMenores de edad: " + (menorEdad*100/personas.length) + "%"
        );


    }


}

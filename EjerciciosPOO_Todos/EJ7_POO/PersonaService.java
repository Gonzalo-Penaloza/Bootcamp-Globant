package EJ7_POO;

import java.util.Scanner;

public class PersonaService {

    public Persona crearPersona(){
        Scanner write = new Scanner(System.in).useDelimiter("\n");
        Persona persona = new Persona();
        String answer;
        boolean pass = false;



        System.out.println("Ingresa el nombre de la persona:");
        persona.setNombre(write.nextLine());

        System.out.println("Ingresa la edad de la persona:");
        persona.setEdad(write.nextInt());

        System.out.println("Ingresa el sexo de la persona (M/F/O):");
        do {
            answer = write.next();
            if(answer.equals("M") || answer.equals("F") || answer.equals("O")){
                pass = true;
            }
        } while (!pass);
        persona.setSexo(answer);

        System.out.println("Ingresa el peso de la persona:");
        persona.setPeso(write.nextDouble());

        System.out.println("Ingresa la altura de la persona:");
        persona.setAltura(write.nextDouble());

        return persona;
    }

    public int calcularIMC(Persona p1){
        double calculo = p1.getPeso() / Math.pow(p1.getAltura(),2);
        if(calculo<20){
            return -1;
        } else if (calculo>=20 && calculo<=25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(Persona p1){
        return p1.getEdad() >= 18;
    }
}

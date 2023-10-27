package EJ01.Servicios;

import EJ01.Entidades.Perro;
import EJ01.Entidades.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdopcionService {
    private List<Perro> perrosEnAdopcion;
    private List<Persona> registroDeAdoptantes;

    private Scanner leer;
    private static int idPerritos = 0;
    private boolean isActive = true;

    public void menu() {
        while (isActive) {
            System.out.println("---------APP DE ADOPCION---------");
            System.out.println("Ingrese la operacion a realizar");
            System.out.println("1. Registrar adoptante");
            System.out.println("2. Registrar nuevo perro en adopcion");
            System.out.println("3. Procesar adopcion");
            System.out.println("4. Mostrar lista de perros en adopcion");
            System.out.println("5. Mostrar lista de adoptantes");
            System.out.println("6. Salir");
            int choice = leer.nextInt();
            switch (choice) {
                case 1:
                    registrarPersona();
                    break;
                case 2:
                    ingresarNuevoPerro();
                    break;
                case 3:
                    procesarAdopcion();
                    break;
                case 4:
                    mostrarPerrosEnAdopcion();
                    break;
                case 5:
                    mostrarRegistroAdoptantes();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema... Hasta la proxima!");
                    isActive = false;
                    break;
            }
        }
    }

    public AdopcionService() {
        perrosEnAdopcion = new ArrayList<>();
        registroDeAdoptantes = new ArrayList<>();
        leer = new Scanner(System.in).useDelimiter("\n");
    }

    public void registrarPersona(){
        System.out.println("Ingrese el nombre:");
        String nombre = leer.next();
        System.out.println("Ingrese el apellido:");
        String apellido = leer.next();
        System.out.println("Ingrese el documento de identidad:");
        String dni = leer.next();

        registroDeAdoptantes.add(new Persona(nombre, apellido, dni));
    }

    public void ingresarNuevoPerro(){

        System.out.println("Ingrese el nombre:");
        String nombre = leer.next();
        System.out.println("Ingrese la edad:");
        int edad = leer.nextInt();
        System.out.println("Ingrese la raza:");
        String raza = leer.next();
        System.out.println("Ingrese el tamaño:");
        double tamanio = leer.nextDouble();

        perrosEnAdopcion.add(new Perro(idPerritos,nombre,edad,raza,tamanio));
        idPerritos++;
    }

    public void mostrarPerrosEnAdopcion(){
        for (Perro p : perrosEnAdopcion) {
            System.out.println(p);
        }
    }

    public void mostrarRegistroAdoptantes(){
        for (int i = 0; i < registroDeAdoptantes.size(); i++) {
            System.out.println((i+1) +"- "+ registroDeAdoptantes.get(i));
        }
    }

    public void procesarAdopcion(){
        System.out.println("Ingrese el documento del adoptante:");
        String documento = leer.next();
        System.out.println("Ingrese el ID del perro adoptado:");
        int id = leer.nextInt();

        Perro perro = retornarMascota(id);
        Persona persona = retornarAdoptante(documento);

        if(perro != null && persona != null){
            persona.setPerro(perro);
            perrosEnAdopcion.remove(perro);
            System.out.println("Adopcion procesada con exito!");
        }
    }

    public Persona retornarAdoptante(String documento){
        for (Persona p : registroDeAdoptantes) {
            if(p.getDocumento().equals(documento)){
                return p;
            }
        }

        System.out.println("El documento ingresado no corresponde a ningun adopante registrado, primero debe registrarse en el sistema!");
        return null;
    }

    public Perro retornarMascota(int id){
        for (Perro p : perrosEnAdopcion) {
            if(p.getId() == id){
                return p;
            }
        }

        System.out.println("El id ingresado no corresponde a ningun perro en adopcion!");
        return null;
    }
}

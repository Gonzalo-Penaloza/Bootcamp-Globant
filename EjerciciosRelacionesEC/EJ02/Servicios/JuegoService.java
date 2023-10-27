package EJ02.Servicios;

import EJ02.Entidades.Juego;
import EJ02.Entidades.Jugador;

import java.util.HashSet;
import java.util.Scanner;

public class JuegoService {
    private Juego juego;
    private JugadorService jugadorService;
    private boolean isActive = true;
    private Scanner leer;


    public JuegoService() {
        this.juego = new Juego();
        this.jugadorService = new JugadorService();
        this.leer = new Scanner(System.in).useDelimiter("\n");

        this.juego.getRevolver().llenarRevolver();
    }

    private void llenarJugadores(){
        for(int i=0; i<juego.getCantJugadores(); i++){
            juego.getJugadores().add(new Jugador());
        }
        System.out.println("Se han completado los jugadores!");
    }

    private void mostrarJugadoreS(){
        for (Jugador j : juego.getJugadores()) {
            System.out.println(j.getNombre());
        }
    }

    private void ronda(){
            for (Jugador j : juego.getJugadores()) {
                if (jugadorService.disparo(juego.getRevolver(), j)) {
                    System.out.println("El jugador " + j.getId() + " ha sido mojado! Mas suerte para la proxima...");
                    System.out.println("----- Juego Terminado -----");
                    System.out.println();
                    return;
                } else {
                    System.out.println("El jugador " + j.getId() + " ha tenido suerte esta vez!");
                    System.out.println("Proximo jugador...");
                    System.out.println();

                    juego.getRevolver().siguienteChorro();
                }
            }
    }

    public void menu() {
        while (isActive) {
            System.out.println("---------JUEGO DE RULETA RUSA CARNAVALERA---------");
            System.out.println("Ingrese la operacion a realizar");
            System.out.println("1. Llenar lista de jugadores");
            System.out.println("2. Comenzar una ronda");
            System.out.println("3. Informacion de revolver(agua)");
            System.out.println("4. Mostrar lista de jugadores");
            System.out.println("5. Salir");
            int choice = leer.nextInt();
            switch (choice) {
                case 1:
                    llenarJugadores();
                    break;
                case 2:
                    ronda();
                    break;
                case 3:
                    System.out.println(juego.getRevolver());
                    break;
                case 4:
                    mostrarJugadoreS();
                    break;
                case 5:
                    isActive = false;
                    break;
            }
        }
    }
}

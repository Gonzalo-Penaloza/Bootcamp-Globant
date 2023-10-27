package EJ03.Servicios;

import EJ03.Entidades.Baraja;
import EJ03.Entidades.Carta;
import EJ03.Entidades.Palo;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BarajaService {

    private Baraja barajaInst;
    private ArrayList<Carta> monton;
    private Scanner leer;

    public BarajaService() {
        barajaInst = new Baraja();
        monton = new ArrayList<>();
        leer = new Scanner(System.in).useDelimiter("\n");
        inicializarBaraja();
    }

    private void inicializarBaraja() {
        Palo[] palos = Palo.values();

        for(Palo palo : palos){
            for (int i = 1; i <= 12; i++) {
                if(i!=8 && i!=9){
                    barajaInst.addElement(new Carta(i,palo));
                }
            }
        }
    }

    public void barajar(){
        Collections.shuffle(barajaInst.getBaraja());
    }

    public Carta siguienteCarta(){
        ArrayList<Carta> barajaRef = barajaInst.getBaraja();

        if(!barajaRef.isEmpty()){
            Carta carta = barajaRef.remove(barajaRef.size() - 1);
            monton.add(carta);
            return carta;
        } else {
            System.out.println("No hay más cartas para repartir!");
            return null;
        }
    }

    public ArrayList<Carta> darCartas(int cant){
        if(barajaInst.getBaraja().size() >= cant){
            ArrayList<Carta> cartas = new ArrayList<>();

            for (int i = 0; i < cant; i++) {
                cartas.add(siguienteCarta());
            }

            return cartas;
        } else {
            System.out.println("Hay menos cartas que las solicitadas, revise é intente nuevamente.");
            return null;
        }
    }

    public void cartasMonton(){
        if(!monton.isEmpty()){
            System.out.println("|- CARTAS DEL MONTON -|");
            for(Carta c : monton){
                System.out.println(c);
            }
        } else {
            System.out.println("No hay ninguna carta en el monton!");
        }
    }

    public void mostrarCarta(ArrayList<Carta> cartas){
        for(Carta c: cartas){
            System.out.println("| " + c + " |");
        }
    }

    private boolean isActive = true;

    public void menu() {
        while (isActive) {
            System.out.println("---------APP DE CARTAS---------");
            System.out.println("Ingrese la operacion a realizar");
            System.out.println("1. Barajar mazo");
            System.out.println("2. Sacar una carta");
            System.out.println("3. Sacar 'X' cartas");
            System.out.println("4. Mostrar cartas del monton");
            System.out.println("5. Salir");
            int choice = leer.nextInt();
            switch (choice) {
                case 1:
                    barajar();
                    break;
                case 2:
                    Carta carta = siguienteCarta();
                    if(carta != null ) {
                        System.out.println(carta);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de cartas:");
                    int cant = leer.nextInt();
                    ArrayList<Carta> cartas = darCartas(cant);
                    if(cartas != null){
                        mostrarCarta(cartas);
                    }
                    break;
                case 4:
                    cartasMonton();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema... Hasta la proxima!");
                    isActive = false;
                    break;
            }
        }
    }
}

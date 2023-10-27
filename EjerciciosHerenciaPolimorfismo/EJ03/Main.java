package EJ03;

import EJ03.Entidades.Electrodomestico;
import EJ03.Entidades.Televisor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Electrodomestico> listaElectro = new ArrayList<>();

        Electrodomestico tv1 = new Televisor(1200,"negro",'B',50,90,52,false);
        Electrodomestico tv2 = new Televisor(1500,"blanco",'C',50,65,49,false);
        Electrodomestico tv3 = new Televisor(1900,"azul",'C',50,50,65,true);
        Electrodomestico tv4 = new Televisor(2500,"rojo",'A',50,105,80,false);


        listaElectro.add(tv1);
        listaElectro.add(tv2);
        listaElectro.add(tv3);
        listaElectro.add(tv4);

        for (Electrodomestico e: listaElectro) {
            e.precioFinal();
        }
    }
}

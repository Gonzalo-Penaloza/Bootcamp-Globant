package EJ03.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Baraja {
    private ArrayList<Carta> baraja;

    public Baraja(){
        baraja = new ArrayList<>();
    }

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }


    public void addElement(Carta c){
        baraja.add(c);
    }
}

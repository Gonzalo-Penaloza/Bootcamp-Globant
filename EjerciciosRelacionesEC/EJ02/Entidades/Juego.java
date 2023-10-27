package EJ02.Entidades;

import EJ02.Servicios.RevolverService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Juego {
    private List<Jugador> jugadores;
    private RevolverService revolver;
    private int cantJugadores;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.revolver = new RevolverService();
        this.cantJugadores = 6;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public RevolverService getRevolver() {
        return revolver;
    }

    public void setRevolver(RevolverService revolver) {
        this.revolver = revolver;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }
}

package EJ02.Servicios;

import EJ02.Entidades.Jugador;
import EJ02.Entidades.RevolverDeAgua;

public class JugadorService {

    public boolean disparo(RevolverService r, Jugador jugador){
        if(r.mojar()){
            jugador.setMojado(true);
            return true;
        }

        return false;
    }

}

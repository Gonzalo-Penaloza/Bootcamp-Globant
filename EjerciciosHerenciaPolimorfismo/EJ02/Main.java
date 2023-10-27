package EJ02;

import EJ02.Entidades.Electrodomestico;
import EJ02.Entidades.Lavadora;
import EJ02.Entidades.Televisor;

public class Main {
    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora();

        lavadora.crearLavadora();
        lavadora.precioFinal();
        System.out.println(lavadora.toString());

        Televisor tv = new Televisor();

        tv.crearTelevisor();
        tv.precioFinal();
        System.out.println(tv.toString());
    }
}

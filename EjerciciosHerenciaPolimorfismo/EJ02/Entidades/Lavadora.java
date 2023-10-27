package EJ02.Entidades;

import java.util.Scanner;

public class Lavadora extends Electrodomestico{
    private double carga;

    public Lavadora(){
        super();
        this.carga = 0;
    }


    public Lavadora(double precio, String color, char consumoEnergetico, double peso, double carga) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public void crearLavadora(){
        Scanner leer = new Scanner(System.in);

        super.crearElectrodomestico();

        System.out.println("Ingrese el tamaño de la carga:");
        setCarga(leer.nextDouble());
    }

    @Override
    public void precioFinal(){
        super.precioFinal();

        if(carga > 30) setPrecio(getPrecio() + 500);
    }

    @Override
    public String toString() {
        return super.toString() + ", Carga: " + this.carga;
    }
}

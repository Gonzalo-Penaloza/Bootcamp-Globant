package EJ03.Entidades;

import java.util.Scanner;

public class Televisor extends Electrodomestico {
    private double resolucion;
    private boolean sintonizador;

    public Televisor(){
    }

    public Televisor(double precio, String color, char consumoEnergetico, double peso, double carga, double resolucion, boolean sintonizador){
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
    }

    public double getResolucion() {
        return resolucion;
    }

    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

    public void crearTelevisor(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        super.crearElectrodomestico();

        System.out.println("Ingrese las pulgadas del TV:");
        setResolucion(leer.nextDouble());

        System.out.println("Contiene sintetizador TDT? S/N");
        char choice = leer.next().charAt(0);

        switch (choice) {
            case 'S':
                setSintonizador(true);
                break;
            case 'N':
                setSintonizador(false);
                break;
            default:
                System.out.println("Ha ingresado una letra incorrecta, se asignara que no tiene sintetizador este caso");
                setSintonizador(false);
                break;
        }
    }

    @Override
    public void precioFinal(){
        super.precioFinal();

        if(resolucion > 40) setPrecio(getPrecio() + (getPrecio()*0.3));

        if(sintonizador) setPrecio(getPrecio() + 500);
    }

    @Override
    public String toString() {
        String aux =  super.toString() + ", Pulgadas: " + this.resolucion + "'";

        if(sintonizador) {
            aux += ", Sintetizador TDT: SI ";
        } else {
            aux += ", Sintetizador TDT: NO ";
        }

        return aux;
    }
}

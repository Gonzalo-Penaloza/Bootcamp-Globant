package EJ02.Entidades;

import java.util.*;

public class Electrodomestico {
    private double precio;
    private String color;
    private char consumoEnergetico;
    private double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(double precio, String color, char consumoEnergetico, double peso) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        return (letra > 64 && letra < 71) ? letra : 'F';
    }

    private String comprobarColor(String color) {
        String[] colors = {"ROJO", "NEGRO", "AZUL", "GRIS"};

        for (String s : colors) {
            if (s.toUpperCase().equals(color)) {
                return color;
            }
        }
        return "BLANCO";
    }

    public void crearElectrodomestico() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el color");
        setColor(comprobarColor(leer.next()));

        System.out.println("Ingrese el consumeo energetico A-F");
        setConsumoEnergetico(comprobarConsumoEnergetico(leer.next().charAt(0)));

        System.out.println("Ingrese el peso:");
        setPeso(leer.nextDouble());

        setPrecio(1000);
    }

    public void precioFinal() {
        double precioFinal = this.precio;

        switch(this.consumoEnergetico) {
            case 'A':
                precioFinal += 1000;
                break;
            case 'B':
                precioFinal += 800;
                break;
            case 'C':
                precioFinal += 600;
                break;
            case 'D':
                precioFinal += 500;
                break;
            case 'E':
                precioFinal += 300;
                break;
            case 'F':
                precioFinal += 100;
                break;
        }

        if (this.peso >= 1 && this.peso <= 19) {
            precioFinal += 100;
        } else if (this.peso >= 20 && this.peso <= 49) {
            precioFinal += 500;
        } else if (this.peso >= 50 && this.peso <= 79) {
            precioFinal += 800;
        } else if (this.peso >= 80) {
            precioFinal += 1000;
        }

        setPrecio(precioFinal);
    }

    @Override
    public String toString() {
        return "Color: " + this.color +
                ", Consumo: " + this.consumoEnergetico +
                ", Peso: " + this.peso +
                ", Precio Final: " + this.precio;
    }
}

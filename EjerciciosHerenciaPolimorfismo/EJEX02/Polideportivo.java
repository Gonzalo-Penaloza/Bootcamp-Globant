package EJEX02;

public class Polideportivo extends Edificio{
    private String nombre;
    private int tipoTechado;  // 0 techado, 1 abierto

    public Polideportivo() {
    }

    public Polideportivo(double ancho, double alto, double largo, String nombre, int tipoTechado) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoTechado = tipoTechado;
    }

    public int getTipoTechado() {
        return tipoTechado;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * ((ancho*largo)+(ancho*alto)+(largo*alto));
    }

    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }


}

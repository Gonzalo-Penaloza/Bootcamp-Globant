package EJEX02;

public class Oficina extends Edificio {
    private int numeroOficinas;
    private int personasPorOficina;
    private int numeroPisos;

    public Oficina() {
    }

    public Oficina(double ancho, double alto, double largo, int numeroOficinas, int personasPorOficina, int numeroPisos) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.personasPorOficina = personasPorOficina;
        this.numeroPisos = numeroPisos;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * ((ancho*largo)+(ancho*alto)+(largo*alto));
    }

    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }

    public void cantPersonas(){
        int cantidad = personasPorOficina * numeroOficinas;
        int cantidadTotal = cantidad * numeroPisos;

        System.out.println("Cantidad de personas por piso: " + cantidad);
        System.out.println("Cantidad de personas en todo el edificio: " + cantidadTotal);
    }
}

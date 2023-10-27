package EjerciciosGuia;

public class Persona implements Interfaz{
    @Override
    public void metodo() {
        System.out.println("El valor de la constante en la interfaz es: " + CONSTANTE);
    }

    @Override
    public int sumar() {
        return 2+2;
    }
}

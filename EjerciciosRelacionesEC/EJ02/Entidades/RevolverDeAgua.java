package EJ02.Entidades;

public class RevolverDeAgua {
    private int posActual;
    private int posAgua;

    public RevolverDeAgua() {
        this.posActual = 0;
        this.posAgua = 0;
    }

    public int getPosActual() {
        return posActual;
    }

    public void setPosActual(int posActual) {
        this.posActual = posActual;
    }

    public int getPosAgua() {
        return posAgua;
    }

    public void setPosAgua(int posicionAgua) {
        this.posAgua = posicionAgua;
    }

    @Override
    public String toString() {
        return "--------RevolverDeAgua--------\n" +
                "Posicion Actual: " + posActual + "\n" +
                "Posicion de Agua: " + posAgua ;
    }
}

package EJEX01;

public class Yate extends VehiculoAcuatico{
    private double potenciaCV;
    private int numeroCamarotes;

    public Yate(String matricula, double slora, String anioFabricacion, double potenciaCV, int numeroCamarotes) {
        super(matricula, slora, anioFabricacion);
        this.potenciaCV = potenciaCV;
        this.numeroCamarotes = numeroCamarotes;
    }

    public double getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(double potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    public int getNumeroCamarotes() {
        return numeroCamarotes;
    }

    public void setNumeroCamarotes(int numeroCamarotes) {
        this.numeroCamarotes = numeroCamarotes;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + potenciaCV + numeroCamarotes;
    }
}

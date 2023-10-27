package EJEX01;

public class Barco extends VehiculoAcuatico{
    private double potenciaCV;

    public Barco(String matricula, double slora, String anioFabricacion, double potenciaCV) {
        super(matricula, slora, anioFabricacion);
        this.potenciaCV = potenciaCV;
    }

    public double getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(double potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + potenciaCV;
    }
}

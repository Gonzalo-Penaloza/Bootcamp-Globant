package EJEX01;

public class Velero extends VehiculoAcuatico {
    private int cantidadVelas;
    public Velero(String matricula, double slora, String anioFabricacion, int cantidadVelas) {
        super(matricula, slora, anioFabricacion);
        this.cantidadVelas = cantidadVelas;
    }

    public int getCantidadVelas() {
        return cantidadVelas;
    }

    public void setCantidadVelas(int cantidadVelas) {
        this.cantidadVelas = cantidadVelas;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + cantidadVelas;
    }
}

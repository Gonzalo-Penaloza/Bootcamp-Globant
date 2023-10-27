package EJEX01;

public class VehiculoAcuatico {
    private String matricula;
    private double slora;
    private String anioFabricacion;

    public VehiculoAcuatico(String matricula, double slora, String anioFabricacion) {
        this.matricula = matricula;
        this.slora = slora;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSlora() {
        return slora;
    }

    public void setSlora(double slora) {
        this.slora = slora;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double calcularModulo() {
        return slora * 10;
    }

}

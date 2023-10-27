package EJ04;

public class Circulo implements CalculoFormas{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return valuePI * Math.pow(radio,2);
    }

    @Override
    public double calcularPerimetro() {
        return valuePI * (radio/2);
    }
}

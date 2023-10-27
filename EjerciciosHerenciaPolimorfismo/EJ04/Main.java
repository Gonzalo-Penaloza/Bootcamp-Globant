package EJ04;

public class Main {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(4);
        Rectangulo r1 = new Rectangulo(2,3);

        System.out.println(c1.calcularArea());
        System.out.println(r1.calcularArea());

        System.out.println(c1.calcularPerimetro());
        System.out.println(r1.calcularPerimetro());
    }
}

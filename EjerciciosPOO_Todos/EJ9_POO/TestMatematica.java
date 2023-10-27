package EJ9_POO;

public class TestMatematica {
    public static void main(String[] args) {
        Matematica mates = new Matematica(Math.random()*5,Math.random()*5);

        mates.calcularPotencia();
        mates.calcularRaiz();
    }

}

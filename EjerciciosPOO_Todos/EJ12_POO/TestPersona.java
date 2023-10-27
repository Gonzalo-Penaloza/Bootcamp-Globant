package EJ12_POO;

public class TestPersona {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.crearPersona();
        System.out.println("Edad de la Persona: " + p1.calcularEdad());
        System.out.println(p1.menorQue(30));
        p1.mostrarPersona();

    }
}

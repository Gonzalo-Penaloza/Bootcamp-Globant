package EJ13_POO;

public class TestCurso {
    public static void main(String[] args) {
        Curso cursoUno = new Curso();
        try {
            cursoUno.crearCurso();
            System.out.println("La ganancia semanal del curso es: " + cursoUno.calcularGananciaSemanal());
        } catch (Exception e){
            System.out.println("ERROR!!! -> No se ha podido crear el curso, intentelo nuevamente.");
        }
    }
}

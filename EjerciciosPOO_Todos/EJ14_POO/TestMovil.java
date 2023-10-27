package EJ14_POO;

public class TestMovil {
    public static void main(String[] args) {
        try {
            Movil c1 = new Movil();
            c1.cargarCelular();
            System.out.println(c1);
        } catch (Exception e){
            System.out.println("ERROR! No se ha podido cargar el celular, ingreselo nuevamente.");
        }
    }
}

package EX1_POO;

public class TestCancion {
    public static void main(String[] args) {
        Cancion c1 = new Cancion();
        System.out.println(c1);

        c1.setAutor("Soda Stereo");
        c1.setTitulo("Persiana Americana");
        System.out.println(c1);
    }
}

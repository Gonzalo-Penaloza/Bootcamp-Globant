package EJ6_POO;

public class TestCafetera {
    public static void main(String[] args) {
        CafeteraService cafeteraSrv = new CafeteraService();
        Cafetera caf1 = cafeteraSrv.crearCafetera();

        System.out.println(caf1);

        cafeteraSrv.llenarCafetera(caf1);
        System.out.println();

        cafeteraSrv.servirTaza(caf1, 350);
        System.out.println(caf1);


    }
}

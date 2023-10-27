package EJ8_POO;

public class TestCadena {
    public static void main(String[] args) {
        Cadena cd = new Cadena("Hola mundo!",11);
        cd.compararLongitud("Java es un lenguaje de tipado fuerte!");
        cd.invertirFrase();
        cd.vecesRepetido("a");
        cd.unirFrases("Aprende Java POO con Globant!");
        cd.reemplazar("@");

        if(cd.contiene("d")){
            System.out.println("La frase contiene la letra d.");
        } else {
            System.out.println("La frase no contiene la letra ingresada!");
        }
    }
}

package EJ6_POO;

import java.util.Scanner;

public class CafeteraService {

    public Cafetera crearCafetera(){
        Scanner write = new Scanner(System.in).useDelimiter("\n");
        Cafetera cafetera = new Cafetera();
        System.out.println("Ingresa la capacidad maxima de la cafetera:");
        cafetera.setCapacidadMaxima(write.nextDouble());
        System.out.println("Ingrese la cantidad agual de cafe:");
        cafetera.setCantidadActual(write.nextDouble());

        return cafetera;
    }

    //Metodos Solicidatos

    public void llenarCafetera(Cafetera c1){
        c1.setCantidadActual(c1.getCapacidadMaxima());
    }

    public void servirTaza(Cafetera c1, int tamanio){
        if(c1.getCantidadActual() >= tamanio){
            c1.setCantidadActual(c1.getCantidadActual()-tamanio);
            System.out.println("La taza se ha llenado!");
        } else {
            double tazafaltante = tamanio - c1.getCantidadActual();
            c1.setCantidadActual(0);
            System.out.println("La taza no se ha llenado, el faltante es de " + tazafaltante + "ml de cafe.");
        }
    }

    public void vaciarCafetera(Cafetera c1){
        c1.setCantidadActual(0);
    }

    public  void agregarCafe(Cafetera c1, int cantidad){
        if(c1.getCantidadActual() + cantidad <= c1.getCapacidadMaxima()){
            c1.setCantidadActual(c1.getCantidadActual() + cantidad);
        } else {
            double sobrante = (c1.getCantidadActual() + cantidad) - c1.getCapacidadMaxima();
            System.out.println("La cafetera se ha llenado! Quedo un sobrante de "+ sobrante +"ml de cafe.");
        }
    }
}

package EJEX02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edificio> edificios = new ArrayList<>();
        int cantidadTechados = 0;

        edificios.add(new Polideportivo(2,4,6,"Sarmiento 1",0));
        edificios.add(new Polideportivo(3,5,7,"Sarmiento 2",0));
        edificios.add(new Oficina(4,4,6,3,7,8));
        edificios.add(new Oficina(5,5,7,4,5,10));


        for(Edificio e: edificios){
            System.out.println("Superficie: " + e.calcularSuperficie());
            System.out.println("Volumen: " + e.calcularVolumen());

            if(e instanceof Polideportivo){

                Polideportivo aux = (Polideportivo) e;
                if(aux.getTipoTechado() == 0){
                    cantidadTechados++;
                }
            } else {
                Oficina aux = (Oficina) e;
                aux.cantPersonas();
            }
        }


        if(cantidadTechados != 0){
            System.out.println("Cantidad de Polideportivos techados: " + cantidadTechados);
        }
    }
}

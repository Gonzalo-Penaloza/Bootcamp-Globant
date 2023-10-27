package EJ10_POO;

import java.util.Arrays;
//      10.Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo A
//        de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. El
//        programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por pantalla.
//        Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros 10 números
//        ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos elementos con el valor
//        0.5. Mostrar los dos arreglos resultantes: el ordenado de 50 elementos y el combinado de
//        20.
public class Main {
    public static void main(String[] args) {
        double[] firstA = new double[50];
        double[] firstB = new double[20];

        rellenarVector(firstA);
        System.out.println("Arreglo A:");
        mostrarVector(firstA);

        //ordenamos de menor a mayor.
        System.out.println("Arreglo A ordenado:");
        Arrays.sort(firstA);
        mostrarVector(firstA);

        //copiamos primeros 10 valores al arrayB
        System.arraycopy(firstA,0, firstB, 0, 10);

        //rellenamos los ultimos diez indices con 0.5
        Arrays.fill(firstB,10, firstB.length, 0.5);
        System.out.println("Arreglo B resultante:");
        mostrarVector(firstB);
    }

    public static void rellenarVector(double[] vecA){
        int length = vecA.length;

        for(int i = 0; i < length; i++) {
            vecA[i] = Math.random() * 50;
        }
    }

    public static void mostrarVector(double[] vecA){
        int length = vecA.length;

        for(int i = 0; i < length; i++) {
            System.out.println("["+ vecA[i] +"] ");
        }
    }
}

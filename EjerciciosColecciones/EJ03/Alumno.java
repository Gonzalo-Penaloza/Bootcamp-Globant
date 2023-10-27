package EJ03;

//      3. Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
//        alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
//        con sus 3 notas.
//        En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//        toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//        pregunta al usuario si quiere crear otro Alumno o no.
//        Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
//        Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//        final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//        del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//        promedio final, devuelto por el método y mostrado en el main.

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    ArrayList<Integer> notas = new ArrayList<>();

    public Alumno(String nombre, int n1, int n2, int n3) {
        this.nombre = nombre;
        notas.add(n1);
        notas.add(n2);
        notas.add(n3);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public double calcularPromedio(){
        double notaFinal = 0;

        for (Integer i : notas) {
            notaFinal+= i;
        }

        return notaFinal/notas.size();
    }
}

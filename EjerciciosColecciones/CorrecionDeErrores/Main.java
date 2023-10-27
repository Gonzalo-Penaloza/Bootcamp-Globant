import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> listado = new ArrayList();
        TreeSet<String> nombre = new TreeSet();
        HashMap<Integer, String> personas = new HashMap<>();

        // ----------------------------------------

        HashMap<Integer, String> personas = new HashMap();
        String n1 = "Albus";
        String n2 = "Severus";
        personas.put(1,n1);
        personas.put(2,n2);

        for (String persona : personas.values()) {
            System.out.println(persona);
        }

        // ----------------------------------------

        ArrayList<String> bebidas = new ArrayList();
        bebidas.add("café");
        bebidas.add("té");

        for (String bebida : bebidas) {
            System.out.println(bebida);
        }

        Iterator<String> it = bebidas.iterator();
        while (it.hasNext()) {
            if (it.next().equals("café")) {
                it.remove();
            }
        }

        for (String bebida : bebidas) {
            System.out.println(bebida);
        }

        // ----------------------------------------
    }
}
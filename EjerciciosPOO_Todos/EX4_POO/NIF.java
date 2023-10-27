package EX4_POO;

import java.util.Scanner;

//4. Dígito Verificador. Crear una clase NIF que se usará para mantener DNIs con su
//        correspondiente letra (NIF). Los atributos serán el número de DNI (entero largo) y la
//        letra (String o char) que le corresponde. Dispondrá de los siguientes métodos:
//         Métodos getters y setters para el número de DNI y la letra.
//         Método crearNif(): le pide al usuario el DNI y con ese DNI calcula la letra que le
//        corresponderá. Una vez calculado, le asigna la letra que le corresponde según el
//        resultado del calculo.
//         Método mostrar(): que nos permita mostrar el NIF (ocho dígitos, un guion y la letra
//        en mayúscula; por ejemplo: 00395469-F).
//        La letra correspondiente al dígito verificador se calculará a traves de un método que
//        funciona de la siguiente manera: Para calcular la letra se toma el resto de dividir el
//        número de DNI por 23 (el resultado debe ser un número entre 0 y 22). El método debe
//        buscar en un array (vector) de caracteres la posición que corresponda al resto de la
//        división para obtener la letra correspondiente. La tabla de caracteres es la siguiente:
public class NIF {
    private long dni;
    private String letra;
    
    private static String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

    public NIF() {
    }

    public NIF(long dni, String letra) {
        this.dni = dni;
        this.letra = letra;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    //TODO: METODOS SOLICITADOS
    public void crearNIF(){
        try (Scanner leer = new Scanner(System.in).useDelimiter("\n")){
            System.out.println("Ingrese su numero de DNI:");
            dni = leer.nextLong();
            asignarLetra();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void asignarLetra(){
        int pos = (int) (dni % 23);
        this.letra = letras[pos];
    }

    public void mostrar(){
        System.out.println("NIF: "+ dni + "-" + letra);
    }
}

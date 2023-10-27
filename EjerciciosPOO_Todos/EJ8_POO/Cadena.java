package EJ8_POO;

public class Cadena {
    private String frase;
    private int longitud;

    public Cadena() {
    }

    public Cadena(String frase, int longitud) {
        this.frase = frase;
        this.longitud = longitud;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void mostrarVocales(){
        int longPhrase = this.frase.length();
        int cantVocals = 0;

        for (int i = 0; i < longPhrase; i++) {
            switch (frase.substring(i,i+1).toUpperCase()) {
                case "A","E","I","O","U":
                    cantVocals++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("La frase contiene una cantidad de " + cantVocals + " vocales.");
    }

    public void invertirFrase(){
        String aux = "";
        int longPhrase = this.frase.length();
        String[] vecAux = new String[longPhrase];

        for (int i = 0; i < longPhrase; i++) {
            vecAux[i] = this.frase.substring(i,i+1);
        }

        for (int i = longPhrase - 1; i >= 0; i--) {
            aux = aux.concat(vecAux[i]);
        }

        System.out.println("La frase invertida es: ");
        System.out.println(aux);
    }

    public void vecesRepetido(String letra){
        int length = this.frase.length();
        int cont  = 0;

        for (int i = 0; i < length; i++) {
            if(this.frase.substring(i,i+1).equals(letra)){
                cont++;
            }
        }

        System.out.println("El caracter '"+ letra + "' se repite " + cont + " veces.");
    }

    public void compararLongitud(String frase){
        int diferencia = Math.abs(this.frase.length()  - frase.length());
        System.out.println("La diferencia de longitud entra la palabra original y la nueva frase es de: " + diferencia );
    }

    public void unirFrases(String frase){
        System.out.println(this.frase + frase);
    }

    public void reemplazar(String letra){
        String fraseAux;

        fraseAux = this.frase.replace("a",letra);

        System.out.println(fraseAux);
    }

    public boolean contiene(String letra) {
        return this.frase.contains(letra);
    }
}

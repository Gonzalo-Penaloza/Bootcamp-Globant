package EJ02.Entidades;

public class Jugador {
    private static int contadorIds = 1;
    private int id;
    private String nombre;
    private boolean mojado;

    public Jugador() {
        this.id = contadorIds;
        this.nombre = "Jugador " + id;
        this.mojado = false;

        contadorIds++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
}

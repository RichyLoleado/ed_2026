package registros.colas;

public class Proceso {
    private String nombre;
    private String usuario;
    private String ruta;
    private int prioridad;

    public Proceso(String nombre, String usuario, String ruta, int prioridad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.ruta = ruta;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    @Override
    public String toString() {
        return "(" + nombre + ", " + usuario + ", " + prioridad + ")";
    }
}

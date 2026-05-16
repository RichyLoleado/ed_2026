package registros.cosechas2;

public class Campesino {
    private String nombre;
    private String curp;
    private int edad;

    public Campesino(String nombre, String curp, int edad) {
        this.nombre = nombre;
        this.curp = curp;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return curp;
    }

}


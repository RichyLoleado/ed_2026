package registros.ventas;

public class Vendedor {
    private int noVendedor;
    private String nombre;
    private String curp;

    public Vendedor(int noVendedor, String nombre, String curp){
        this.noVendedor = noVendedor;
        this.nombre = nombre;
        this.curp = curp;
    }

    public int getNoVendedor() {
        return noVendedor;
    }

    public void setNoVendedor(int noVendedor) {
        this.noVendedor = noVendedor;
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

    @Override
    public String toString(){
        return curp;
    }
}

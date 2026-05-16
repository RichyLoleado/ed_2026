package registros.cosechas2;

public class Producto {
    private String codProd;
    private String nombre;
    private double precioBase;
    private String tipo;

    public Producto(String nombre, String  tipo, double precioBase, String codProd) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.codProd = codProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    @Override
    public String toString(){
        return codProd;
    }

}

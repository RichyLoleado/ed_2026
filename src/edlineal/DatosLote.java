package edlineal;

public interface DatosLote {
    public boolean vacio();
    public boolean lleno();
    public boolean meter(Object valor);
    public Object sacar();
    public void imprimir();

}

package edlineal;

public interface DatosVector extends DatosLista {
    public boolean llena();
    public int cantidad();
    public Object obtener(int indice);
    public boolean modificar(int indice, Object valor);
    public boolean validarIndice(int indice);
    public Object eliminar();
}
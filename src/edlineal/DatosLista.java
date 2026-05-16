package edlineal;

public interface DatosLista {
    public boolean vacia();
    public Integer agregar(Object valor);
    public Object buscar(Object valor);
    public Object eliminar(Object valor);
    public void imprimir();
    public boolean esIgual(DatosLista lista2);
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces);
    public DatosListaE buscarValores(Object valor);
    public int contar(Object valor);
    public Object eliminar();

    //....
    public Integer agregarInicio(Object valor);
    public Object eliminarInicio();
    public Object obtenerPrimero();
    public Object obtenerUltimo();
    public void mostrarOI();
}

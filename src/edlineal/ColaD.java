package edlineal;

public class ColaD implements DatosLote {
    protected DatosListaD cola;

    public ColaD() {
        cola = new DatosListaD();
    }

    @Override
    public boolean vacio() {
        return cola.vacia();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean meter(Object valor) {
        cola.agregar(valor);
        return true;
    }

    @Override
    public Object sacar() {
        Object elemento = cola.eliminarInicio();
        return elemento;
    }

    @Override
    public void imprimir() {
        cola.imprimir();
    }
}

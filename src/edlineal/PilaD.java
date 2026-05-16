package edlineal;

public class PilaD implements DatosLote {
    protected DatosListaD pila;

    public PilaD(){
        pila = new DatosListaD();
    }

    @Override
    public boolean vacio() {
        return  pila.vacia();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean meter(Object valor) {
        //en la pila el ultimo en entrar es el primero en salir. se inserta al inicio para que sea el ultimo
        pila.agregarInicio(valor);
        return true;
    }

    @Override
    public Object sacar() {
        Object elemento = pila.eliminarInicio();
        return elemento;
    }

    @Override
    public void imprimir() {
        pila.imprimir();
    }
}

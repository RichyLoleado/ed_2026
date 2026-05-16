package edlineal;

public class PilaE implements DatosLote {
    protected DatosListaE pila; //usar un arreglo para la pila


    public PilaE(int tamanio) {
        pila = new DatosListaE(tamanio);

    }


    @Override
    public boolean vacio() {
        return pila.vacia();
    }

    @Override
    public boolean lleno() {
        return pila.llena();
    }

    @Override
    public boolean meter(Object valor) {
        int retorno = pila.agregar(valor);
        if(retorno < 0){ //error
            return false;
        }else{ //si pudo meterlo
            return true;
        }
    }

    @Override
    public Object sacar() {
        return pila.eliminar();
    }

    @Override
    public void imprimir() {
        pila.imprimir();
    }
}

package edlineal.auxiliares;

public class NodoDinamico {
    protected Object valor; //guarda el contenido del nodo
    protected NodoDinamico posSiguiente; //la direccion de memoeria del siguiente nodo

    public NodoDinamico(Object valor){
        this.valor = valor;
        posSiguiente = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoDinamico getPosSiguiente() {
        return posSiguiente;
    }

    public void setPosSiguiente(NodoDinamico posSiguiente) {
        this.posSiguiente = posSiguiente;
    }

    public String toString(){
        return valor.toString();
    }
}

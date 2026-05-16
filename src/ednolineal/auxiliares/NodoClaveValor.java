package ednolineal.auxiliares;

public class NodoClaveValor {
    private Object clave;
    private Object valor;
    private NodoClaveValor posSiguiente;

    public NodoClaveValor(Object clave, Object valor){
        this.clave = clave;
        this.valor = valor;
        posSiguiente = null;
    }

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoClaveValor getPosSiguiente() {
        return posSiguiente;
    }

    public void setPosSiguiente(NodoClaveValor posSiguiente) {
        this.posSiguiente = posSiguiente;
    }

    @Override
    public String toString(){
        return clave.toString();
    }

}

package ednolineal.auxiliares;

public class NodoDoble {
    protected NodoDoble posIzquierda;
    protected Object valor;
    protected NodoDoble posDerecha;

    public NodoDoble(Object valor){
        this.valor = valor;
        posIzquierda = null;
        posDerecha = null;
    }

    public NodoDoble getPosIzquierda() {
        return posIzquierda;
    }

    public void setPosIzquierda(NodoDoble posIzquierda) {
        this.posIzquierda = posIzquierda;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoDoble getPosDerecha() {
        return posDerecha;
    }

    public void setPosDerecha(NodoDoble posDerecha) {
        this.posDerecha = posDerecha;
    }

    @Override
    public String toString(){
        return valor.toString();
    }
}

package edlineal.auxiliares;

public class NodoBusqueda {
    private NodoDinamico posAnterior;
    private NodoDinamico posBusqueda;

    public NodoDinamico getPosAnterior() {
        return posAnterior;
    }

    public void setPosAnterior(NodoDinamico posAnterior) {
        this.posAnterior = posAnterior;
    }

    public NodoDinamico getPosBusqueda() {
        return posBusqueda;
    }

    public void setPosBusqueda(NodoDinamico posBusqueda) {
        this.posBusqueda = posBusqueda;
    }
}

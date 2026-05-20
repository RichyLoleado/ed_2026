package ednolineal.auxiliares;

public class NodoBusquedaArbol {
    private int indice;
    private int direccion;

    public NodoBusquedaArbol(int indice, int direccion){
        this.indice = indice;
        this.direccion = direccion;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString(){
        return indice + "";
    }
}

package ednolineal.auxiliares;

public class Vertice {
    protected int numero; //este numero me guia como orientacion a el arreglo
                          //paraelelo a la matriz
    protected Object descripcion; //es el contenido del nodo

    public Vertice(int numero, Object descripcion){
        this.numero = numero;
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return descripcion.toString();
    }

    public int getNumero() {
        return numero;
    }
    public Object getDescripcion() {
        return descripcion;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setDescripcion(Object descripcion) {
        this.descripcion = descripcion;
    }


}

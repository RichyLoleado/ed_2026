package principales;

import ednolineal.GrafoL;
import entradasalida.DatosSalida;

public class PrincipalGrafoLRecorrido {
    public static void main(String[] args){
        GrafoL grafo = new GrafoL();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "D");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "B");

        DatosSalida.consola("\n");
        grafo.imprimir();

    }
}

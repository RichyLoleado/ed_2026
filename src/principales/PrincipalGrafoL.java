package principales;

import ednolineal.GrafoL;
import entradasalida.DatosSalida;

public class PrincipalGrafoL {
    public static void main(String[]args){
        GrafoL grafo = new GrafoL();
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("A", "D");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "B");
        grafo.agregarArista("D", "A");

        grafo.imprimir();
        DatosSalida.consola("\n");

        DatosSalida.consola("Recorrido Por profundidad: \n");
        grafo.recorridoProfundidad("C").imprimir();

    }
}

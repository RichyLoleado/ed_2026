package principales;

import ednolineal.GrafoM;

public class PrincipalGrafo {
    public static void main(String[]args){
        GrafoM grafo = new GrafoM(5, 0);
        grafo.agregarVertices("A");
        grafo.agregarVertices("B");
        grafo.agregarVertices("C");
        grafo.agregarVertices("D");
        grafo.agregarVertices("E");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("A", "D");
        grafo.agregarArista("B", "A");
        grafo.agregarArista("B", "E");
        grafo.agregarArista("C", "B");
        grafo.agregarArista("D", "C");
        grafo.agregarArista("E", "B");
        grafo.agregarArista("E","C");

        grafo.mostrar();
    }
}

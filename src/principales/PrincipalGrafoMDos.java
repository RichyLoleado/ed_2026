package principales;

import ednolineal.GrafoM;
import entradasalida.DatosSalida;

public class PrincipalGrafoMDos {
    public static void main(String[]args){
        GrafoM grafo = new GrafoM(4, 0.0);

        grafo.agregarVertices("A");
        grafo.agregarVertices("B");
        grafo.agregarVertices("C");
        grafo.agregarVertices("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "D");
        grafo.agregarArista("B", "C");

        //buscar vertice
        DatosSalida.consola("Vertice C: "+grafo.buscarVertice("C"));
        grafo.mostrar();


        DatosSalida.consola("\n");
        DatosSalida.consola("A es adyacente a B: "+grafo.esAdyacente("A", "B"));
        DatosSalida.consola("\n");
        DatosSalida.consola("B es adyacente a A : "+grafo.esAdyacente("B", "B"));
        DatosSalida.consola("\n");
        DatosSalida.consola("C es adyacente a D: "+grafo.esAdyacente("C", "D"));

        DatosSalida.consola("\n");
//        //eliminar arista
//        DatosSalida.consola("Las aristas eliminadas entre a y b se pudieron eliminar?: "+grafo.eliminarArista("A", "B"));
//        DatosSalida.consola("\n");
//        DatosSalida.consola("Las aristas eliminadas entre C y D se pudieron eliminar?: "+grafo.eliminarArista("C", "D"));
//        grafo.mostrar();

        //grado vertice
        DatosSalida.consola("\n");
        DatosSalida.consola("El peso del vertice de A es: " + grafo.gradoVertice("A"));
        DatosSalida.consola("\n");
        DatosSalida.consola("El peso del vertice de D es: " + grafo.gradoVertice("D"));
        DatosSalida.consola("\n");
        DatosSalida.consola("El peso del vertice de X es: " + grafo.gradoVertice("X"));


        //listar vertices()
        DatosSalida.consola("\n");
        grafo.listarVertices();
    }
}

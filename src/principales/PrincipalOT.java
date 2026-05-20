package principales;

import edlineal.DatosLista;
import edlineal.DatosListaE;
import ednolineal.GrafoM;
import entradasalida.DatosSalida;

public class PrincipalOT {
    public static void main(String[]args){
        GrafoM grafo = new GrafoM(7, 0.0);

        grafo.agregarVertices("P1");
        grafo.agregarVertices("P2");
        grafo.agregarVertices("P3");
        grafo.agregarVertices("P4");
        grafo.agregarVertices("P5");
        grafo.agregarVertices("P6");
        grafo.agregarVertices("P7");

        grafo.agregarArista("P1" , "P3");
        grafo.agregarArista("P2" , "P3");
        grafo.agregarArista("P2" , "P4");
        grafo.agregarArista("P3" , "P4");
        grafo.agregarArista("P3" , "P5");
        grafo.agregarArista("P4" , "P5");
        grafo.agregarArista("P4" , "P6");
        grafo.agregarArista("P5" , "P7");
        grafo.agregarArista("P6" , "P5");
        grafo.agregarArista("P6" , "P7");

        grafo.mostrar();
        DatosSalida.consola("\n");

        DatosSalida.consola("Mostrando ordenación topologica: \n");
        DatosListaE OT = grafo.ordenacionTopologica();
        OT.imprimir();

        DatosSalida.consola("\n");
    }
}

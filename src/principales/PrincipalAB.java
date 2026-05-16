package principales;

import ednolineal.ArbolBinario;
import entradasalida.DatosSalida;

public class PrincipalAB {
    public static void main(String[]args){
        ArbolBinario arbol = new ArbolBinario();
        arbol.crearArbol("A");

        DatosSalida.consola("La Altura del arbol es: \n" + arbol.obtenerAltura());

        DatosSalida.consola("\n");
        DatosSalida.consola("El nivel de el nodo B es: " + arbol.obtenerNivel("B" ));

    }
}

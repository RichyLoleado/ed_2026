package principales;

import ednolineal.ArbolBB;
import entradasalida.DatosSalida;

public class PrincipalABB {
    public static void main(String[]args){
        ArbolBB arbol = new ArbolBB();
        arbol.agregar(15);
        arbol.agregar(18);
        arbol.agregar(19);
        arbol.agregar(12);
        arbol.agregar(8);
        arbol.agregar(17);
        arbol.agregar(99);

        DatosSalida.consola("Inorden: \n");
        arbol.inorden();
        DatosSalida.consola("\n");
        DatosSalida.consola("buscando 19: "+ arbol.buscar(19));
        DatosSalida.consola("\n");
        DatosSalida.consola("Preorden: \n");
        arbol.preorden();
        DatosSalida.consola("\n");
        DatosSalida.consola("Posorden: \n");
        arbol.posorden();
        DatosSalida.consola("\n");


    }
}

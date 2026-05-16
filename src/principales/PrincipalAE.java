package principales;

import ednolineal.ArbolExpArit;
import entradasalida.DatosSalida;

public class PrincipalAE {
    public static void main(String[]args){
        ArbolExpArit arbol = new ArbolExpArit();
        arbol.fromPosfija("42/39*-12^+");

        DatosSalida.consola("Inorden: \n");
        arbol.inorden();
        DatosSalida.consola("\n");
        DatosSalida.consola("Preorden: \n");
        arbol.preorden();
        DatosSalida.consola("\n");
        DatosSalida.consola("Posorden: \n");
        arbol.posorden();
    }
}

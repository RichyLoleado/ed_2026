package principales;

import ednolineal.ListaE2D;
import entradasalida.DatosSalida;

public class PrincipalListaE2D {
    public static void main(String[]args){
        //crear lista
        ListaE2D listados = new ListaE2D(3, 3, "X");

        //imprimir lista por filas
        listados.imprimirXFilas();
        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //imprimir lista por columnas
        listados.imprimirXColumnas();
        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
    }
}

package principales;

import edlineal.DatosListaEstaticaN;
import entradasalida.DatosSalida;
import librerias.Ordenamiento;

public class PrincipalPigeonholeSort {
    public static void main(String[]args){

        DatosListaEstaticaN lista = new DatosListaEstaticaN(10);

        lista.agregar(8);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(7);
        lista.agregar(4);
        lista.agregar(6);
        lista.agregar(8);
        lista.agregar(4);
        lista.agregar(9);

        DatosSalida.consola("Lista Original: " );
        lista.imprimir();

        Ordenamiento.pigeonholeSort(lista);

        DatosSalida.consola("\n" );
        DatosSalida.consola("\n" );
        DatosSalida.consola("Lista Ordenada con Pigeonhole Sort: " );
        lista.imprimir();

    }
}

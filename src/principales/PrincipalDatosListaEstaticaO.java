package principales;

import edlineal.DatosListaE;
import edlineal.DatosListaEstaticaO;
import entradasalida.DatosSalida;
import librerias.Orden;

public class PrincipalDatosListaEstaticaO {
    public static void main(String argumentos[]){
        DatosListaEstaticaO lista = new DatosListaEstaticaO(8, Orden.ASC);
        lista.agregar("1");
        lista.agregar("2");
        lista.agregar("3");
        lista.agregar("4");
        lista.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("Buscando (3): " + lista.buscar("3")+"\n");
        DatosSalida.consola("Buscando (6): "+ lista.buscar("6")+"\n");

        lista.agregar(7);
        lista.imprimir();
        DatosSalida.consola("\n");
        lista.agregar(5);
        lista.imprimir();
        DatosSalida.consola("\n");

        lista.eliminar(4);
        lista.imprimir();
        DatosSalida.consola("\n");
    }
}

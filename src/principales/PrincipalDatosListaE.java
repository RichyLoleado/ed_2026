package principales;

import edlineal.DatosListaE;
import entradasalida.DatosSalida;

public class PrincipalDatosListaE {
    public static void main(String argumentos []) {
        DatosListaE arreglo = new DatosListaE(8);

        arreglo.agregar("A");
        arreglo.agregar("S");
        arreglo.agregar("T");
        arreglo.agregar("M");

        arreglo.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("Buscando (S): "+ arreglo.buscar("S")+"\n");
        DatosSalida.consola("Buscando (X): "+ arreglo.buscar("X")+"\n");
        //DatosSalida.consola("Eliminando (S): "+ arreglo.eliminar("S")+"\n");
        arreglo.imprimir();
        DatosSalida.consola("\n");

        DatosListaE lista2 = new DatosListaE(4);
        lista2.agregar("X");
        lista2.agregar("Q");
        lista2.agregar("W");
        lista2.agregar("W");
        DatosSalida.consola("son iguales? "+arreglo.esIgual(lista2)+"\n");
        lista2.imprimir();
        DatosSalida.consola("se modificó? "+lista2.modificar("W", "O",4)+"\n");
        lista2.imprimir();
        DatosSalida.consola("\n");


        DatosListaE lista3 = new DatosListaE(5);
        lista3.agregar("Q");
        lista3.agregar("P");
        lista3.agregar("R");
        lista3.agregar("Q");

        lista3.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("Se modificó el indice? " + lista3.modificar(2, "I") + "\n");
        lista3.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        DatosListaE lista4 = new DatosListaE(5);
        lista4.agregar("8");
        lista4.agregar("G");
        lista4.agregar("I");
        lista4.agregar("8");
        DatosSalida.consola("\n");
        lista4.imprimir();
        DatosSalida.consola("\n");
        DatosListaE posiciones = lista4.buscarValores("8");
        DatosSalida.consola("\n");


        DatosSalida.consola("el numero de valores: " + lista4.contar("8") + "\n");
        DatosSalida.consola("el numero de valores: " + lista4.contar("X") + "\n");
        DatosSalida.consola("\n");
        lista4.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("se borró el valor: " + lista4.eliminar() + "\n");
        DatosSalida.consola("\n");
        lista4.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("el numero de valores repetidos : " + lista4.contar("8") + "\n");
        DatosSalida.consola("el numero de valores repetidos : " + lista4.contar("X") + "\n");
        lista4.imprimir();
        DatosSalida.consola("se borró el valor: " + lista4.eliminar() + "\n");
        DatosSalida.consola("\n");
        lista4.imprimir();







    }
}

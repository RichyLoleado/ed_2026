package principales;

import edlineal.DatosListaEstaticaN;
import ednolineal.Lista2DEstaticaN;
import entradasalida.DatosSalida;
import librerias.TipoLogaritmo;

public class PrincipalLista2dEstaticaN {
    public static void main(String[]args){

        Lista2DEstaticaN listaN = new Lista2DEstaticaN(2, 2, 0);
        listaN.agregar(0, 0, 1);
        listaN.agregar(0, 1, 2);
        listaN.agregar(1, 0, 3);
        listaN.agregar(1, 1, 4);

        //por escalar
        listaN.porEscalar(2);
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        DatosListaEstaticaN listaN2 = new DatosListaEstaticaN(4);
        listaN2.agregar(1);
        listaN2.agregar(2);
        listaN2.agregar(3);
        listaN2.agregar(4);
        //por escalare
        DatosSalida.consola("imprimiendo porEscalares [1, 2, 3, 4]: " + listaN.porEscalares(listaN2)+ "\n");
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //sumarEscalares
        DatosSalida.consola("sumando porEscalares [1, 2, 3, 4]: " + listaN.sumarEscalares(listaN2)+ "\n");
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");
        //sumarEscalar
        DatosSalida.consola("sumando Escalar (5): " + listaN.sumarEscalar(5)+ "\n");
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //multiplicar
        Lista2DEstaticaN listaN3 = new Lista2DEstaticaN(2, 2, 0);
        listaN3.agregar(0, 0, 1);
        listaN3.agregar(0, 1, 2);
        listaN3.agregar(1, 0, 3);
        listaN3.agregar(1, 1, 4);
        DatosSalida.consola("multiplicando por escalares [1,2][3,4]: " + listaN.multiplicar(listaN3)+ "\n");
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //sumar
        DatosSalida.consola("sumando con la matriz [1,2][3,4]: " + listaN.sumar(listaN3)+ "\n");
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //aplicarPotencia
        DatosSalida.consola("aplicando potencia [2]: " + listaN.aplicarPotencia(2)+ "\n");
        listaN.imprimirXFilas();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");
        //aplicarLogaritmo
        DatosSalida.consola("aplicando logaritmo base 10: " + listaN.aplicarLogaritmo(TipoLogaritmo.BASE10) + "\n" );
        listaN.imprimirXFilas();


    }
}

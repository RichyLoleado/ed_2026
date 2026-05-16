package principales;

import entradasalida.DatosSalida;
import librerias.matematicas.Recursion;

public class PrincipalRecursion {
    public static void main(String[]args){
        Recursion rec = new Recursion();

        DatosSalida.consola("El Maximo Común Divisor de A = 10 , B = 4  es: " + " -->  " + rec.MCD(10, 4) + "  <--" );
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        // es binario
        Recursion recB = new Recursion();

        DatosSalida.consola("El numero 101 es binario? " + recB.esBinario(101));
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        DatosSalida.consola("El numero 1002 es binario? " + recB.esBinario(1002));
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        DatosSalida.consola("---------------------------------------");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        //Convertir a binario
        Recursion recC = new Recursion();
        DatosSalida.consola("Numero 150 Convertido a binario: " + recC.convertirBinario(150));


    }
}

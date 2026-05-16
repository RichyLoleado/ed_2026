package principales;

import entradasalida.DatosSalida;
import librerias.matematicas.ExpresionesAritmeticas;

public class PrincipalExpArit {
    public static void main(String[] args) {
        DatosSalida.consola("calculando operación...");
        DatosSalida.consola("abcd/*ef^/+, donde: a=2, b=3, c=4, d=2, e=3, f=2: ");
        DatosSalida.consola(ExpresionesAritmeticas.evaluarPosfija("2342/*32^/+") + "\n");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        DatosSalida.consola(ExpresionesAritmeticas.evaluarPrefija("+2/*3/42^32") + "\n");
    }
}
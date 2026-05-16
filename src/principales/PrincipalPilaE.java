package principales;

import edlineal.DatosLista;
import edlineal.PilaE;
import entradasalida.DatosSalida;

public class PrincipalPilaE {
    public static void main(String args[]){
        PilaE pila = new PilaE(5);

        pila.meter('A');
        pila.meter('M');
        pila.meter('Z');

        pila.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("\n Sacando uno: " + pila.sacar() + "\n");
        pila.imprimir();
        DatosSalida.consola("\n");

    }
}

package principales;

import entradasalida.DatosSalida;
import librerias.matematicas.Polinomio;

public class PrincipalPolinomio {

    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio();

        //x^5 + x^3 + x + 1
        polinomio.agregarM(0,1,5);
        polinomio.agregarM(1,1,3);
        polinomio.agregarM(2,1,1);
        polinomio.agregarM(3,1,0);

        //evaluar
        double resultado = polinomio.evaluar(2);
        DatosSalida.consola("Resultado: " + resultado + "\n");

        //buscar
        boolean encontrado = polinomio.buscar(3);
        DatosSalida.consola("Existe x^3: " + encontrado + "\n");

        //binario
        String binario = polinomio.convertirBinario(5);
        DatosSalida.consola("Binario: " + binario + "\n");
    }
}
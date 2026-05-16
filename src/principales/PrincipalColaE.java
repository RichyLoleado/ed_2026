package principales;
import edlineal.ColaE;
import entradasalida.DatosSalida;
public class PrincipalColaE {
    public static void main(String[] args) {
        ColaE nuevaCola = new ColaE(5);

        nuevaCola.meter(1);
        nuevaCola.meter(2);
        nuevaCola.meter(3);
        nuevaCola.meter(4);
        nuevaCola.meter(5);
        nuevaCola.meter(6);
        DatosSalida.consola("Impresión: \n");
        nuevaCola.imprimir();
        DatosSalida.consola("Sacando: " + nuevaCola.sacar() + "\n");
        DatosSalida.consola("Sacando: " + nuevaCola.sacar() + "\n");
    }
}

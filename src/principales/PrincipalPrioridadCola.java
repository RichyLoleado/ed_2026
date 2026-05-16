package principales;

import entradasalida.DatosSalida;
import registros.colas.ColaPrioridad;
import registros.colas.Proceso;

public class PrincipalPrioridadCola {
        public static void main(String[] args) {

            ColaPrioridad cola = new ColaPrioridad(10);

            cola.meter(new Proceso("Chrome", "Juan", "C:/chrome.exe", 5));
            cola.meter(new Proceso("Word", "Maria", "C:/word.exe", 10));
            cola.meter(new Proceso("Sistema", "SO", "C:/sys.exe", 8));
            cola.meter(new Proceso("Spotify", "Juan", "C:/spotify.exe", 6));

            DatosSalida.consola("COLA DE PROCESOS: ");
            cola.imprimir();

            DatosSalida.consola("\n PROCESOS EN EJECUCION: ");

            DatosSalida.consola("\n");
            Proceso p;

            p = (Proceso) cola.sacar();
            System.out.println("Ejecutando: " + p);

            p = (Proceso) cola.sacar();
            System.out.println("Ejecutando: " + p);

            p = (Proceso) cola.sacar();
            System.out.println("Ejecutando: " + p);

            p = (Proceso) cola.sacar();
            System.out.println("Ejecutando: " + p);
        }
}

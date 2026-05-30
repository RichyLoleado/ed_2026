package principales;

import edlineal.DatosLista;
import edlineal.DatosListaD;
import ednolineal.DatosListaDClave;
import ednolineal.RedBayesiana;
import entradasalida.DatosSalida;

public class PrincipalRedBayesiana {
    public static void main(String[]args){
        RedBayesiana red = new RedBayesiana();
        red.mostrarRed();

        DatosSalida.consola("\n");

        DatosSalida.consola("P(Estudio) = " + red.consultarProbabilidadSimple("Estudio"));
        DatosSalida.consola("\n");
        DatosSalida.consola("P(Asistencia) = "+ red.consultarProbabilidadSimple("Asistencia"));
        DatosSalida.consola("\n");
        DatosSalida.consola("P(Tareas) = "+ red.consultarProbabilidadSimple("Tareas"));

        DatosListaD eventos = new DatosListaD();
        eventos.agregar("Estudio");
        eventos.agregar("Asistencia");
        eventos.agregar("Tareas");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        DatosSalida.consola("Resultados de la calcular la probabilidad conjunta: " + red.calcularProbabilidadConjunta(eventos));
    }
}

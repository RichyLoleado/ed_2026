package principales;

import edlineal.DatosListaD;
import entradasalida.DatosSalida;
import registros.sensores.LecturaSensor;
import registros.sensores.SistemaSensores;

public class PrincipalSistemaSensores {
    public static void main(String[]args){
        SistemaSensores sensores = new SistemaSensores();

        sensores.agregar(new LecturaSensor("S1", 25.0));
        sensores.agregar(new LecturaSensor("S2", 110.0));
        sensores.agregar(new LecturaSensor("S3", 40.0));
        sensores.agregar(new LecturaSensor("S4", 10.0));
        sensores.agregar(new LecturaSensor("S5", 70.0));

        DatosSalida.consola("Promedio antes de eliminar: " + sensores.calcularPromedio() + "\n");

        sensores.eliminarLecturasInvalidas();

        DatosSalida.consola("Promedio despues de eliminar: " + sensores.calcularPromedio() + "\n");
    }
}

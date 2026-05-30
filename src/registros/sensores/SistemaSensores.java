package registros.sensores;

import edlineal.DatosListaD;
import edlineal.auxiliares.NodoDinamico;

public class SistemaSensores extends DatosListaD { //hereda de datos lista dinamica por que se comporta como una lista y hace el trabajo mas facil.

    public void eliminarLecturasInvalidas(){
        posInicial = eliminarLecturasInvalidas(posInicial);
    }

    private NodoDinamico eliminarLecturasInvalidas(NodoDinamico nodo){
        if(nodo == null){ //caso base
            return null; // no hay nada que eliminar
        }
        LecturaSensor lectura = (LecturaSensor) nodo.getValor(); //obtener el valor del nodo para poder acceder a sus datos
        if(lectura.getTemperatura() < 15.0 || lectura.getTemperatura() > 90.0){ //si la temperatura es menor a 15 o mayor a 90
            return eliminarLecturasInvalidas(nodo.getPosSiguiente()); //eliminar el nodo y ir al siguiente nodo
        }
        nodo.setPosSiguiente( eliminarLecturasInvalidas(nodo.getPosSiguiente())); //eliminar el nodo y ir al siguiente nodo
        return nodo;
    }

    private double sumarTemperaturas(NodoDinamico nodo){
        if(nodo == null){ //caso base
            return 0;
        }
        LecturaSensor lectura = (LecturaSensor) nodo.getValor(); //obtener el valor del nodo para poder acceder a sus datos
        return lectura.getTemperatura() + sumarTemperaturas(nodo.getPosSiguiente()); //sumar la temperatura del nodo y la sumar a la suma de las temperaturas del siguiente nodo
    }

    private int contarLecturas(NodoDinamico nodo){
        if(nodo == null){ //caso base
            return 0;
        }
        return 1 + contarLecturas(nodo.getPosSiguiente()); //sumar 1 al contador y sumar el contador del siguiente nodo
    }

    public double calcularPromedio(){
        return sumarTemperaturas(posInicial) / contarLecturas(posInicial); //dividir el contador de lecturas entre la suma de las lecturas
    }

}

package edlineal;

import entradasalida.DatosSalida;

import javax.management.ObjectName;

public class ColaE implements DatosLote{
    protected Object[] datos;
    protected int posInicial;
    protected int posFinal;
    protected int capacidad;

    public ColaE(int tamanio){
        datos = new Object[tamanio];
        posInicial = -1;
        posFinal = -1;
        capacidad = tamanio;
    }

    @Override
    public boolean vacio() {
        if(posFinal == -1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean lleno() {
        if((posInicial == 0 && posFinal == capacidad - 1) || (posInicial == posFinal + 1)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean meter(Object valor) {
        if(lleno() == false){//hay espacio
            if(vacio() == true){
                posInicial = 0;
                posFinal = 0;
                datos[posFinal] = valor;

            } else if (posFinal == capacidad - 1) {
                posFinal = 0;
                datos[posFinal] = valor;

            } else {
                posFinal = posFinal + 1;
                datos[posFinal] = valor;

            }
            return true;
        }
        return false;
    }

    @Override
    public Object sacar() {
        Object respaldo = null;
        if(vacio() == false){
            if(posInicial == posFinal){
                respaldo = datos[posInicial];
                posFinal = -1;
                posInicial = -1;

            } else if (posInicial == capacidad - 1) {
                respaldo = datos[posInicial];
                posFinal = 0;
            }else{
                respaldo = datos[posInicial];
                posInicial = posInicial + 1;
            }
            return respaldo;
        } else {
            return null;
        }
        }

    @Override
    public void imprimir() {
        if(vacio() == true){ // a)
            DatosSalida.consola("[ ]");
        }else if (posInicial <= posFinal){ //b) y d)
            DatosSalida.consola("[ ");
            for(int posImp = posInicial; posImp <= posFinal - 1; posImp++){
                DatosSalida.consola(datos[posImp]+", ");
            }
            DatosSalida.consola(datos[posFinal] + " ]");
        }else{ //c)
            DatosSalida.consola("[ ");
            //hacer un while
            int posImp = posInicial;
            while (posImp >= posInicial || posImp < posFinal){
                DatosSalida.consola(datos[posImp]+", ");
                if(posImp == capacidad - 1){ //llegó a la orilla
                    posImp = 0;
                }else{ //no ha llegado a la orilla, sumar 1
                    posImp = posImp + 1;
                }
            }
            DatosSalida.consola(datos[posFinal] + " ]");
        }
    }

}

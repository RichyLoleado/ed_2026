package registros.sistemacafeteria;

import edlineal.DatosListaD;
import edlineal.auxiliares.NodoDinamico;
import entradasalida.DatosSalida;
import registros.sistemacafeteria.auxiliares.Pedido;

public class Cafeteria extends DatosListaD {  //extiende de DatosListaD por que es una lista dinamica y es mas sencillo trabajar con ella

    public int contarMayoresA150(){
        return contarMayoresA150(posInicial);
    }

    private int contarMayoresA150(NodoDinamico nodo){
        if(nodo == null){  //caso base
            return 0;
        }
        Pedido pedidoActual = (Pedido) nodo.getValor(); //obtener el valor del nodo
        if(pedidoActual.getTotal() > 150){ //si el total es mayor a 150
            return 1 + contarMayoresA150(nodo.getPosSiguiente()); //sumar 1 al contador
        }else{
            return contarMayoresA150(nodo.getPosSiguiente()); //ir al siguiente nodo
        }
    }

    public void imprimirInverso(){
        imprimirInverso(posInicial);
    }

    private void imprimirInverso(NodoDinamico nodo){
        if(nodo == null){ //caso base
            return;
        }
        imprimirInverso(nodo.getPosSiguiente()); //ir al siguiente nodo
        Pedido pedidoActual = (Pedido) nodo.getValor(); //obtener el valor y ponerlo en pedidoActual para poder acceder a sus datos
        DatosSalida.consola(pedidoActual.getNombrecliente() + "\n"); //imprimir el nombre del cliente

    }

}

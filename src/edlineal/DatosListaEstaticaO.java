package edlineal;

import librerias.AdmObjetos;
import librerias.Orden;

public class DatosListaEstaticaO extends DatosListaE {
    private Orden tipoOrden;
    //En herencia lo primero que se hace
    //definir el contructor apropiado
    public DatosListaEstaticaO(int tamanio, Orden tipoOrden) {
        super(tamanio);
        this.tipoOrden = tipoOrden;
    }

    @Override
    public Integer agregar(Object valor){
        if (llena() == true){
            return -1;
        }

        int posicion = 0;

        while(posicion <= posFinal){
            int comp = AdmObjetos.comparar(valor, datos[posicion]);
            if(comp == 0){
                return -1; // ya existe el valor
            }

            if(tipoOrden == Orden.ASC){
                if (comp < 0){
                    posicion = posicion + 1;
                }else{
                    posicion = posicion +1; //sale del ciclo sin usar breal
                }
            }else {
                //DESC
                if (comp > 0){
                    posicion = posicion + 1;
                }else{ //salir del ciclo sin usar break
                    posicion = posicion +1;
                }
            }
        }
        if(posicion <= posFinal){
            posicion = posFinal + 1;
        }

        posFinal++;
        for(int posCambio = posFinal; posCambio > posicion; posCambio--){
            datos[posCambio] = datos[posCambio - 1];
        }
        datos[posicion] = valor;
        return posicion;
    }

    @Override
    public Integer buscar(Object valor){
        if (vacia() == true){
            return -1;
        }
        int posicion = 0;

        while (posicion <= posFinal){
            int comp = AdmObjetos.comparar(valor, datos[posicion]);
            if(comp == 0){
                return posicion;
            }

            if(tipoOrden == Orden.ASC){
                if(comp < 0){
                    return -1; //se paso
                }
            }else{
                if(comp > 0){
                    return -1; // ya se paso
                }
            }
            posicion++;
        }
        return -1;
    }




    @Override
    public Object eliminar(Object valor){
        //se debe sobreescribir este metodo
        //de orden por que si no, llama al de la superclase
        //necesito que se busque con el de buscar esta clase
        int posicion = (int)buscar(valor);
        Object respaldo = null;
        if (posicion >= 0){ // sí hay algo
            respaldo = datos[posicion];
            posFinal = posFinal - 1;
            for (int cambio = posicion; cambio <= posFinal; cambio++){
                datos[cambio] = datos[cambio + 1];
            }
            return respaldo;
        }else { //no hay nada
            return null;
        }
    }


}

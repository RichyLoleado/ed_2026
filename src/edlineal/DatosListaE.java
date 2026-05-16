package edlineal;

import entradasalida.DatosSalida;

public class DatosListaE implements DatosVector {
    protected int capacidad;
    protected int posFinal;
    protected Object datos[];

    public DatosListaE(int tamanio) {
        posFinal = -1;
        capacidad = tamanio;
        datos = new Object[capacidad];
    }

    public boolean vacia() {
        if (posFinal == -1) {
            return true;
        } else {
            return false;
        }
    }

    public Integer agregar(Object valor) {
        if (llena() == true) {
            return -1;
        } else {
            posFinal = posFinal + 1;
            datos[posFinal] = valor;
            return posFinal;
        }
    }

    public boolean llena() {
        if ((posFinal + 1) == capacidad) {
            return true;
        } else {
            return false;
        }
    }

    public Object buscar(Object valor) {
        int posicionB = 0;
        while (posicionB <= posFinal && valor.toString().equalsIgnoreCase(datos[posicionB].toString()) == false) {
            posicionB = posicionB + 1;
        }
        if (posicionB <= posFinal) {
            return posicionB;
        } else {
            return -1;
        }
    }

    public Object eliminar(Object valor){
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

    public void imprimir() {
        //System.out.print("[");
        DatosSalida.consola("[");
        for (int indice = 0; indice <= (posFinal - 1); indice++){
            DatosSalida.consola(datos[indice]+",");
        }
        if (vacia() == false){
            System.out.print(datos[posFinal]+""); // +"" se agrega para convertirlo en cadena
        }
        DatosSalida.consola("]");
    }
    public int cantidad(){
        return posFinal + 1;
    }

    public Object obtener(int indice){
        if(validarIndice(indice) == true){
            return datos[indice];
        }else{ // no es válido el índice
            return null;
        }
    }

    public boolean validarIndice(int indice){
        if (indice >= 0 && indice <= posFinal){
            return true;
        }else{
            return false;
        }
    }

    public boolean esIgual(DatosLista lista2) {
        // Primero verifica que lista 2 sea una instancia de DatosListaE
        // instanceof se utiliza para saber si adentro tiene un objeto del tipo que le pones
        if(lista2 instanceof DatosListaE) { // cuando si son instancias
            DatosListaE lista2Conv = (DatosListaE) lista2;
            if(lista2Conv.cantidad() == cantidad()){ // sí tiene la misma cantidad
                for (int posicion = 0; posicion <= posFinal; posicion++){
                    Object contenidoLista2 = lista2Conv.obtener(posicion);
                    Object contenidoActual = obtener(posicion);
                    if (contenidoLista2.toString().equalsIgnoreCase(contenidoActual.toString()) == false) {
                        return false;
                    }
                }
                return true;
            }else { // no tiene la misma cantidad
                return false;
            }
        }else { // cuando no son instancias
            return false;
        }
    }

    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces){
        int modificaciones = 0;
        while (modificaciones < numVeces){
            int posicionViejo = (int) buscar(valorViejo);

            if (posicionViejo == -1){
                if(modificaciones > 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                if (validarIndice(posicionViejo) == true){
                    datos[posicionViejo] = valorNuevo;
                    modificaciones++;
                }
            }
        }
        return false;
    }

    public boolean modificar(int indice, Object valor){
        if(validarIndice(indice) == true){
            datos[indice] = valor;
            return true;
        }else{
            return false;
        }
    }

    public DatosListaE buscarValores(Object valor){
        DatosListaE listaPos = new DatosListaE(capacidad); //la lista en la qu e se guardaran las posiciones
        int posicion = 0;
        while (posicion <= posFinal){
            if (datos[posicion].toString().equalsIgnoreCase(valor.toString())){ //compara el valor si es igual convirtiendo a cadena
                listaPos.agregar(posicion);
            }
            posicion++;
        }
        return listaPos;
    }

    public Object eliminar(){
        if(vacia() == false) {
            Object respaldo = datos[posFinal];
            posFinal--;
            return respaldo;
        }else{
            return null;
        }
    }

    @Override
    public Integer agregarInicio(Object valor) {
        return 0;
    }

    @Override
    public Object eliminarInicio() {
        return null;
    }

    @Override
    public Object obtenerPrimero() {
        return null;
    }

    @Override
    public Object obtenerUltimo() {
        return null;
    }

    @Override
    public void mostrarOI() {

    }

    public int contar(Object valor){
        int contador = 0;
        for(int indice = 0; indice <= posFinal; indice++){
            if (datos[indice].toString().equalsIgnoreCase(valor.toString())){
                contador++;
            }
        }
        return contador;
    }

    public int Capacidad(DatosListaE lista){
        return lista.capacidad;
    }

    public void llenar(Object valor){
        posFinal = -1;
        for(int indice = 0; indice < capacidad; indice++){
            agregar(valor);
        }
    }
}


package ednolineal;

import edlineal.DatosListaE;
import ednolineal.auxiliares.NodoClaveValor;
import entradasalida.DatosSalida;

public class DatosListaDClave {
    public NodoClaveValor posInicial;
    public NodoClaveValor posFinal;
    protected NodoClaveValor iterador;

    public DatosListaDClave(){
        posFinal = null;
        posInicial = null;
    }

    //metodo para validar si la lista esta vacia
    public boolean vacia(){
        if(posInicial == null){ //si la lista esta vacia
            return true; //retornamos true
        }else{
            return false; //retornamos false
        }
    }

    public boolean agregar(Object clave, Object valor){
        //Recorrer la lista para verificar que no exista la clave
        NodoClaveValor posRecorrido = posInicial;
        while (posRecorrido != null){ // recorrer la lista
            if (posRecorrido.getClave().toString().equalsIgnoreCase(clave.toString())){ //si existe la clave
                posRecorrido.setValor(valor); //actualizar el valor
                return true; // retornamos true
            }
            posRecorrido = posRecorrido.getPosSiguiente(); //siguiente nodo
        }
        //si la clave es nueva
        NodoClaveValor nuevo = new NodoClaveValor(clave, valor);

        if (vacia()) {
            posInicial = nuevo;
            posFinal = nuevo;
        }else{
            posFinal.setPosSiguiente(nuevo);
            posFinal = nuevo;
        }
        return true;
    }

    //buscar por clave
    public Object buscar(Object clave){
        if (vacia() == true){ //si la lista esta vacia
            return null;
        }

        NodoClaveValor posRecorrido = posInicial; //recorrer la lista
        while (posRecorrido != null){ //recorrer la lista
            if (posRecorrido.getClave().toString().equalsIgnoreCase(clave.toString())){ //
                return posRecorrido.getValor(); //regresamos el valor
            }
            posRecorrido = posRecorrido.getPosSiguiente(); //siguiente nodo
        }
        return null; //si no se encuentra la clave
    }

    //buscar por contenido
    public Object buscarContenido(Object valor){
        if (vacia() == true){ //si la lista esta vacia
            return null; // retornamos null
        }
        NodoClaveValor posRecorrido = posInicial; //recorrer la lista
        while (posRecorrido != null){ // recorrer la lista
            if (posRecorrido.getValor().toString().equalsIgnoreCase(valor.toString())){ // si el valor es igual al buscado
                return posRecorrido.getValor(); //regresamos el valor
            }
            posRecorrido = posRecorrido.getPosSiguiente(); //siguiente nodo
        }
        return null; //si no se encuentra el valor
    }

    //eliminar por clave regresando su valor
    public Object eliminar(Object clave){
        if(vacia() == true){
            return null;
        }

        NodoClaveValor actual = posInicial;
        NodoClaveValor anterior = null;
        //recorrer la lista
        while (actual != null && actual.getClave().toString().equalsIgnoreCase(clave.toString()) == false ){
            anterior = actual;
            actual = actual.getPosSiguiente();
        }
        //si no se encuentra la clave
        if (actual == null){
            return null;
        }

        Object contenido = actual.getValor();
        //es el primer nodo
        if (actual == posInicial){
            posInicial = posInicial.getPosSiguiente();
            //si al eliminar el primer nodo, la lista queda vacia
            if (posInicial == null){
                posFinal = null;
            }
        }else{ //no es el primer nodo
            anterior.setPosSiguiente(actual.getPosSiguiente());
            //si el que eliminamos era el ultimo nodo
            if (actual == posFinal){
                posFinal = anterior;
            }
        }
        return contenido;
    }

    public Object eliminarContenido(Object valor){
        if (vacia() == true){
            return null;
        }

        NodoClaveValor actual = posInicial;
        NodoClaveValor anterior = null;

        //bucar el nodo por valor
        while (actual != null){
            if (actual.getValor() != null && actual.getValor().toString().equalsIgnoreCase(valor.toString())){
                break;
            }
            anterior = actual;
            actual = actual.getPosSiguiente();
        }
        //si terminamos de recorrer la lista y no lo encontramos
        if (actual == null){
            return null;
        }

        Object contenidoEliminado = actual.getValor();

        //conectar de nuevo la lista
        //si es el primer nodo
        if (actual == posInicial){
            posInicial = posInicial.getPosSiguiente();
            if (posInicial == null){
                posFinal = null;
            }
        }
        //no es el primer nodo
        else{
            anterior.setPosSiguiente(actual.getPosSiguiente());
            //si el que eliminamos era el ultimo nodo
            if (actual == posFinal){
                posFinal = anterior;
            }
        }
        return contenidoEliminado;
    }

    public boolean modificar(Object clave, Object valor){
        if (vacia() == true){ //validar si la lista esta vacia
            return false; //si esta vacia no se puede modificar
        }
        Object resultadoBusqueda = buscar(clave); //guardar el resultado de la busqueda
        if (resultadoBusqueda != null){ //comparar si la busqueda es igual a null
            agregar(clave, valor); //si es igual a null, agregar el nuevo valor
            return true;
        }else{ //si no es igual a null, no se puede modificar
            return false;
        }
    }

    public boolean modificarValor(Object valorViejo, Object valorNuevo){
        if (vacia() == true){ //validar si la lista esta vacia
            return false;
        }
        NodoClaveValor actual = posInicial;
        while (actual != null){ // recorrer la lista
            //si el valor es igual al buscado
            if (actual.getValor() != null && actual.getValor().toString().equalsIgnoreCase(valorViejo.toString())){
                actual.setValor(valorNuevo); //actualizar el valor
                return true;
            }
            actual = actual.getPosSiguiente(); //siguiente nodo
        }
        return false; //si no se encuentra el valor
    }

    public void imprimir(){
        if(vacia() == true){ //validar si la lista esta vacia
            DatosSalida.consola("[ ]"); //imprimir vacia
            return; // salimos del metodo
        }
        NodoClaveValor actual = posInicial;
        DatosSalida.consola("[ "); //imprimir el inicio de la lista
        while (actual != null){ //recorrer la lista
            DatosSalida.consola("( " + actual.getClave() + ", " + actual.getValor() + " ) "); //imprimir el nodo
            actual = actual.getPosSiguiente(); //siguiente nodo
        }
        DatosSalida.consola(" ]"); //imprimir el final de la lista
    }

    public void imprimirClaves(){
        if (vacia() == true){
            DatosSalida.consola("[ ]");
            return;
        }

        NodoClaveValor actual = posInicial;
        DatosSalida.consola("[ ");
        while (actual != null){
            DatosSalida.consola(" ( " + actual.getClave() + " ) ");
            actual = actual.getPosSiguiente();
        }
        DatosSalida.consola(" ]");
    }

    public void imprimirValores(){
        if (vacia() == true){ //validar si la lista esta vacia
            DatosSalida.consola("[ ]"); //imprimir vacia
            return; // salimos del metodo
        }

        NodoClaveValor actual = posInicial; //recorrer la lista
        DatosSalida.consola("[ "); //imprimir el inicio de la lista
        while (actual != null){ //recorrer la lista
            DatosSalida.consola(" ( " + actual.getValor() + " ) "); //imprimir el nodo
            actual = actual.getPosSiguiente(); //siguiente nodo
        }
        DatosSalida.consola(" ]"); //imprimir el final de la lista
    }

    public DatosListaE aListasEstaticas(){
        if (vacia() == true){
            return null;
        }

        int tamano = 0;
        NodoClaveValor actual = posInicial;
        while (actual != null){
            tamano++;
            actual = actual.getPosSiguiente();
        }
        DatosListaE claves = new DatosListaE(tamano);
        DatosListaE valores = new DatosListaE(tamano);

        actual = posInicial;
        while (actual != null){
            claves.agregar(actual.getClave());
            valores.agregar(actual.getValor());

            actual = actual.getPosSiguiente();
        }

        DatosListaE listaResultado = new DatosListaE(2);
        listaResultado.agregar(claves);
        listaResultado.agregar(valores);

        return listaResultado;

    }










}

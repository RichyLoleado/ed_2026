package edlineal;

import edlineal.auxiliares.NodoBusqueda;
import edlineal.auxiliares.NodoDinamico;
import entradasalida.DatosSalida;

public class DatosListaD implements DatosLista {
    protected NodoDinamico posInicial;
    protected NodoDinamico posFinal;
    protected NodoDinamico iterador;

    public DatosListaD(){
        posInicial = null;
        posFinal = null;
    }

    @Override
    public boolean vacia() {
        if(posInicial == null){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Integer agregar(Object valor) {
        if(vacia() == true){ //no hay nada en la lista
            NodoDinamico nuevo = new NodoDinamico(valor);
            posInicial = nuevo;
            posFinal = nuevo;
        } else { //si hay elementos en la lista
            NodoDinamico nuevo = new NodoDinamico(valor);
            posFinal.setPosSiguiente(nuevo);
            posFinal = nuevo;
        }
        return 1;
    }

    @Override
    public Object buscar(Object valor) {
        if (vacia()) {
            return null;
        }
        NodoDinamico actual = posInicial;
        while (actual != null) {
            if (actual.getValor().toString().equalsIgnoreCase(valor.toString())) {
                return actual.getValor();
            }
            actual = actual.getPosSiguiente();
        }
        return null;
    }

    public Integer agregarInicio(Object valor){
        if (vacia()==true) {//a)
            NodoDinamico nuevo = new NodoDinamico(valor);
            //paso 2
            posInicial = nuevo;
            posFinal = nuevo;
        }else {
            NodoDinamico nuevo = new NodoDinamico(valor);
            nuevo.setPosSiguiente(posInicial);
            posInicial = nuevo;
        }
            return 1;
    }

    @Override
    public Object eliminarInicio(){
        Object respaldo = null;
        if(vacia() == false){ //hay algo
            respaldo = posInicial.getValor(); //respaldo para cualquiera de los 2 casos
            if(posInicial == posFinal){
                posInicial = null;
                posFinal = null;
            }else{
                posInicial = posInicial.getPosSiguiente();
            }
            return respaldo;
        }else{
            return respaldo; //este es 0 cuando la lista está vacia
        }
    }

    private NodoBusqueda buscarNodo(Object valor){
        NodoDinamico posAnterior = posInicial;
        NodoDinamico posBusqueda = posInicial;
        while (posBusqueda != null && valor.toString().equalsIgnoreCase(posBusqueda.getValor().toString()) == false){
            posAnterior = posBusqueda;
            posBusqueda = posBusqueda.getPosSiguiente();
        }
        NodoBusqueda posNodoBusqueda = new NodoBusqueda();
        posNodoBusqueda.setPosAnterior(posAnterior);
        posNodoBusqueda.setPosBusqueda(posBusqueda);
        return posNodoBusqueda;
    }

    public void inicializarIterador(){
        iterador = posInicial;
    }

    public boolean esIteradorNulo(){
        if (iterador == null){
            return true;
        }else{
            return false;
        }
    }

    public Object obtenerDatoIterador(){
        if (esIteradorNulo() == false){
            return iterador.getValor();
        }else {
            return null;
        }
    }

    public void avanzarIterador(){
        iterador = iterador.getPosSiguiente();
    }

    @Override
    public Object eliminar(Object valor){
        if(vacia() == true){
            return null;
        }else{
            NodoBusqueda nodoEncontrar = buscarNodo(valor);
            if(nodoEncontrar.getPosBusqueda() == null){
                return null;
            }else{
                Object respaldo = null;
                if (posInicial == posFinal){
                    respaldo = nodoEncontrar.getPosBusqueda().getValor();
                    posInicial = null;
                    posFinal = null;
                    return respaldo;
                } else if (nodoEncontrar.getPosBusqueda() == posInicial) {
                    respaldo = nodoEncontrar.getPosBusqueda().getValor();
                    posInicial = nodoEncontrar.getPosBusqueda().getPosSiguiente();
                    return respaldo;
                } else if (nodoEncontrar.getPosBusqueda() == posFinal) {
                    respaldo = nodoEncontrar.getPosBusqueda().getValor();
                    nodoEncontrar.getPosAnterior().setPosSiguiente(null);
                    posFinal = nodoEncontrar.getPosAnterior();
                    return respaldo;
                } else {
                    respaldo = nodoEncontrar.getPosBusqueda().getValor();
                    NodoDinamico anterior = nodoEncontrar.getPosAnterior();
                    NodoDinamico siguiente = nodoEncontrar.getPosBusqueda().getPosSiguiente();
                    anterior.setPosSiguiente(siguiente);
                    return respaldo;
                }
            }
        }
    }

    public int cantidad(){
        inicializarIterador();
        int contador = 0;
        while(esIteradorNulo() == false){
            contador++;
            avanzarIterador();
        }
        return contador;
    }

    @Override
    public Object obtenerUltimo(){
        if (vacia()==false){
            return posFinal.getValor();
        }else {
            return null;
        }
    }

    @Override
    public Object obtenerPrimero(){
        if (vacia()==false){
            return posInicial.getValor();
        }else {
            return null;
        }
    }


    @Override
    public void imprimir() {
        DatosSalida.consola("[ ");
        NodoDinamico posRecorrido = posInicial;
        while(posRecorrido!=posFinal){
            DatosSalida.consola(posRecorrido.getValor()+" , ");
            posRecorrido=posRecorrido.getPosSiguiente();
        }
        if(vacia()==false) {
            DatosSalida.consola((String) posFinal.getValor());
        }
        DatosSalida.consola(" ]");
    }

    @Override
    public boolean esIgual(DatosLista lista2) {
        return false;
    }

    @Override
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces) {
        return false;
    }

    @Override
    public DatosListaE buscarValores(Object valor) {
        return null;
    }

    @Override
    public int contar(Object valor) {
        return 0;
    }

    @Override
    public Object eliminar() {
        return null;
    }

    @Override
    public void mostrarOI(){
        PilaD pilaAux = new PilaD();
        NodoDinamico posRecorrido = posInicial;
        while(posRecorrido!=null){
            pilaAux.meter(posRecorrido.getValor());
            posRecorrido=posRecorrido.getPosSiguiente();
        }
        pilaAux.imprimir();
    }





}

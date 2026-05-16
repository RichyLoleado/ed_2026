package ednolineal;

import ednolineal.auxiliares.NodoDoble;
import entradasalida.DatosEntrada;
import entradasalida.DatosSalida;

public class ArbolBinario {
    protected NodoDoble raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void crearArbol(Object datosRaiz) {
        DatosSalida.consola("Dame el valor de la raíz: ");
        String datosRaíz = DatosEntrada.cadenas();

        NodoDoble nuevoNodo = new NodoDoble(datosRaíz);
        raiz = nuevoNodo;
        crearArbol(raiz);
    }

    private void crearArbol(NodoDoble subRaiz) {
        //esto hace el proceso del hijo izquierdo
        DatosSalida.consola("El nodo " + subRaiz.getValor() + " tiene hijo izquierdo? ");
        String respuesta = DatosEntrada.cadenas();
        if (respuesta.equalsIgnoreCase("si") == true || respuesta.equalsIgnoreCase("s") == true) {
            DatosSalida.consola("Dame el valor del hijo izquierdo de " + subRaiz.getValor() + ": ");
            String valorHI = DatosEntrada.cadenas();
            NodoDoble nuevoHijoI = new NodoDoble(valorHI);
            subRaiz.setPosIzquierda(nuevoHijoI);
            crearArbol(nuevoHijoI); //esto hace al nuevo hijo izquierdo una nueva subraíz
        }

        //esto hace el proceso del hijo derecho
        DatosSalida.consola("El nodo " + subRaiz.getValor() + " tiene hijo Derecho? ");
        String respuesta2 = DatosEntrada.cadenas();
        if (respuesta.equalsIgnoreCase("si") == true || respuesta.equalsIgnoreCase("s") == true) {
            DatosSalida.consola("Dame el valor del hijo derecho de " + subRaiz.getValor() + ": ");
            String valorHD = DatosEntrada.cadenas();
            NodoDoble nuevoHijoD = new NodoDoble(valorHD);
            subRaiz.setPosDerecha(nuevoHijoD);
            crearArbol(nuevoHijoD); //esto hace al nuevo hijo derecho una nueva subraíz


        }
    }

    public void preorden(){
        preorden(this.raiz);
    }

    public void inorden(){
        inorden(this.raiz);
    }

    public void posorden(){
        posorden(this.raiz);
    }

    private void preorden(NodoDoble subraiz){
        //secuencia rid
        if (subraiz != null) {
            DatosSalida.consola(subraiz.getValor() + " ");
            preorden(raiz.getPosIzquierda());
            preorden(raiz.getPosDerecha());
        }
    }

    private void posorden(NodoDoble subraiz){
        if (subraiz != null) {
            posorden(raiz.getPosIzquierda());
            posorden(raiz.getPosDerecha());
            DatosSalida.consola(subraiz.getValor() + " ");
        }
    }

    private void inorden(NodoDoble subraiz){
        if (subraiz != null) {
            inorden(subraiz.getPosIzquierda());
            DatosSalida.consola(subraiz.getValor() + " ");
            inorden(subraiz.getPosDerecha());
        }
    }

    public int obtenerAltura(){
        return obtenerAltura(this.raiz);
    }

    //obtener la altura del arbol
    private int obtenerAltura(NodoDoble subraiz){
        if(subraiz == null){ //caso base
            return 0;
        }

        int altIzq = obtenerAltura(subraiz.getPosIzquierda()); //obtener altura del hijo izquierdo
        int altDer = obtenerAltura(subraiz.getPosDerecha()); // obtener altura del hijo derecho

        if(altIzq > altDer){ // obtener la altura mayor
            return altIzq + 1;
        }else{
            return altDer + 1;
        }
    }

    public int obtenerNivel(Object valorB){
        return obtenerNivel(this.raiz, valorB, 1);
    }

    private int obtenerNivel(NodoDoble subraiz, Object valorB, int nivel){
        if(subraiz == null){ // caso base
            return -1; // no se encuentra
        }

        if(subraiz.getValor().equals(valorB)){ // si el valor es igual
            return nivel; // regresar el nivel
        }

        int nivelIzq = obtenerNivel(subraiz.getPosIzquierda(), valorB, nivel + 1); // llamar recursivamente al hijo izquierdo

        if(nivelIzq != -1){ // si el valor se encuentra en el hijo izquierdo
            return nivelIzq; // regresar el nivel
        }

        return obtenerNivel(subraiz.getPosDerecha(), valorB, nivel + 1); // llamar ahora al hijo derecho si no se encuentra en el hijo izquierdo
    }

}
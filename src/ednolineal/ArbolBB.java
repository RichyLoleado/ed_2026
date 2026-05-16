package ednolineal;

import ednolineal.auxiliares.NodoDoble;
import librerias.AdmObjetos;

//Arbol binario de busqueda
public class ArbolBB extends ArbolBinario{

    public boolean agregar(Object valor){
        if(raiz == null){
            NodoDoble nodo = new NodoDoble(valor);
            raiz = nodo;
            return true;
        }else{
            return agregar(valor, raiz);
        }

    }

    private boolean agregar(Object valor, NodoDoble subraiz){
        int comparacion = AdmObjetos.comparar(subraiz.getValor(), valor);
        if(comparacion < 0 ){ //el valor es mas chico que el nodo
            if(subraiz.getPosIzquierda() == null){ //si el nodo no tiene hijo izquierdo
                NodoDoble nuevoNodo = new NodoDoble(valor);
                subraiz.setPosIzquierda(nuevoNodo);
                return true;
            }else {
                return agregar(valor, subraiz.getPosIzquierda());
            }
        }else if (comparacion > 0){ //el valor es mas grande que el nodo
             if(subraiz.getPosDerecha() == null){ //si el nodo no tiene hijo derecho
                 NodoDoble nuevoNodo = new NodoDoble(valor);
                 subraiz.setPosDerecha(nuevoNodo); //agregar el nuevo nodo
                 return true;
             }else{
                 return agregar(valor, subraiz.getPosDerecha());
             }
        }else {//es igual
            return false;
        }
    }

    //metodo para buscar
    public Object buscar(Object valorB){
        return buscar(valorB, raiz);
    }

    private Object buscar(Object valor, NodoDoble subraiz) {
        if (subraiz != null) {
            int comparacion = AdmObjetos.comparar(subraiz.getValor(), valor);
            if (comparacion == 0) {
                return subraiz.getValor(); //lo encontró
            } else if (comparacion < 0) { //el valor es mas grande que el nodo
                return buscar(valor, subraiz.getPosDerecha()); //se va a la derecha
            } else if ((comparacion > 0)) { //el valor es mas chico que el nodo
                return buscar(valor, subraiz.getPosIzquierda()); //se va a la izquierda
            }
        }
        return null;
    }


    public boolean eliminar(Object valor){
        if(buscar(valor) != null){
            raiz = eliminar(valor, raiz);
            return true;
        }
        return false;
    }
    private NodoDoble eliminar(Object valor, NodoDoble subraiz){
        if(subraiz == null){
            return null;
        }
        int comparacion = AdmObjetos.comparar(subraiz.getValor(), valor);
        //buscar hacia la izquierda
        if(comparacion > 0){
            subraiz.setPosIzquierda(
                    eliminar(valor, subraiz.getPosIzquierda())
            );
        }
        //buscar hacia la derecha
        else if(comparacion < 0){
            subraiz.setPosDerecha(
                    eliminar(valor, subraiz.getPosDerecha())
            );
        }
        //nodo encontrado
        else{
            //Cas 1: nodo hoja
            if(subraiz.getPosIzquierda() == null &&
                    subraiz.getPosDerecha() == null){
                return null;
            }
            //caso 2: un solo hijo derecho
            if(subraiz.getPosIzquierda() == null){

                return subraiz.getPosDerecha();
            }
            //caso 2: un solo hijo izuierdo
            if(subraiz.getPosDerecha() == null){

                return subraiz.getPosIzquierda();
            }
            //Ccaso 3: dos hijos
            NodoDoble sucesor =
                    obtenerMenor(subraiz.getPosDerecha());
            subraiz.setValor(sucesor.getValor());
            subraiz.setPosDerecha(
                    eliminar(
                            sucesor.getValor(),
                            subraiz.getPosDerecha()
                    )
            );
        }
        return subraiz;
    }

    //ob tene el nodo menor del subarbol derecho
    private NodoDoble obtenerMenor(NodoDoble subraiz){
        while(subraiz.getPosIzquierda() != null){
            subraiz = subraiz.getPosIzquierda();
        }
        return subraiz;
    }

}

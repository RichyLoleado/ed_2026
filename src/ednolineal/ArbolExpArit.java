package ednolineal;

import edlineal.PilaE;
import ednolineal.auxiliares.NodoDoble;
import librerias.matematicas.ExpresionesAritmeticas;

public class ArbolExpArit extends ArbolBinario{
    //crear un arbol apartir de una expresion infija
    public void fromInfija(String infija){
        //este metodo debe primero convertir a prefija
        // o posfija para poder hacerce arbol.
    }

    public void fromPrefija(String prefija){

    }

    //este es el que se tiene ahorita
    public void fromPosfija(String posfija){
        PilaE pila = new PilaE(posfija.length());
        //se crea un ciclo for para recorrer la cadena posfija
        for (int postoken = 0; postoken < posfija.length(); postoken++) {

            //1. tokenizar la exp de izq a der
            char token = posfija.charAt(postoken);
            //2. si el token es un operando crear nodo con el token y meterlo a la pila
            if(ExpresionesAritmeticas.esOperando(token) == true){ //es operando
                NodoDoble nodoNuevo = new NodoDoble(token);
                pila.meter(nodoNuevo);
            }else{ //es operador
                //3. si el token es un operador, se sacan 2 nodos de la pila
                // (donde primero es op2); creamos un nodo con ese token y
                // lo ligamos  a esos dos hijos; el nodo creado se mete en la pila.
                NodoDoble op2 = (NodoDoble) pila.sacar();
                NodoDoble op1 = (NodoDoble) pila.sacar();
                NodoDoble nuevoNuevo = new NodoDoble(token);
                nuevoNuevo.setPosIzquierda(op1);
                nuevoNuevo.setPosDerecha(op2);
                pila.meter(nuevoNuevo);

            }
        }
        //4. la pila contienen la raiz del arbol.
        raiz = (NodoDoble) pila.sacar();
    }


}

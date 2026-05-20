package ednolineal;

import edlineal.*;
import ednolineal.auxiliares.Vertice;
import entradasalida.DatosSalida;

public class GrafoL {
    //clase para usar grafos con listas dinamicas
    protected DatosListaD listaAdyacencia;

    public GrafoL(){
        listaAdyacencia = new DatosListaD();
    }

    //este metodo va a buscar si el vertice ya exsite en la lista de adyacencia
    //y si existe me va a regresar la lista en donde ese vertice es el primero.
    private DatosListaD buscarVertice(Object valor) {
        //tengo que recorrer la lista negra (lista de adyacencia) y sacar cada elemento de esa lista, que es una sublista (azul),
        //en donde el primer elemento de esa sublista es el vertice candidato.
        listaAdyacencia.inicializarIterador();
        while (listaAdyacencia.esIteradorNulo() ==  false){// hay elementos en la lista
            DatosListaD subListaAzul = (DatosListaD) listaAdyacencia.obtenerDatoIterador();
            Vertice verticePrimero = (Vertice) subListaAzul.obtenerPrimero();
            //comparar con el que me preguntan
            if(valor.toString().equalsIgnoreCase(verticePrimero.toString()) == true){ //si es igual regresar la sublista
                return subListaAzul;
            }
            listaAdyacencia.avanzarIterador();
        }
        return null;
    }

    public boolean agregarVertice(Object valor){
        //para agregar un vertice, necesito checar primero si el vertice que se agrega ya existe
        DatosListaD listaBusqueda = buscarVertice(valor);
        if(listaBusqueda == null){
            //no está, lo puedo agregar
            Vertice verticeNuevo = new Vertice(0,valor);
            DatosListaD subListaNueva = new DatosListaD();
            subListaNueva.agregar(verticeNuevo);
            int resultadoAgregar = listaAdyacencia.agregar(subListaNueva);
            if(resultadoAgregar >= 0){
                return true;
            }
        } //encontró el valor por lo tanto no lo agregamos por duplicidad
        return false;
    }

    public boolean agregarArista(Object origen, Object destino){
        //buscar origen y destino
        DatosListaD listaOrigen = buscarVertice(origen);
        DatosListaD listaDestino = buscarVertice(destino);
        //checar que las 2 listas no sean nulas
        if(listaOrigen != null && listaDestino != null){
            //sabiendo que los 2 existen y que tengo las 2 listas en donde aparecen el origen y el destino al principio
            //a la lista del origen le agregamos al final el primer elemento de la lista del destino
            Vertice verticeDestino = (Vertice) listaDestino.obtenerPrimero();
            int retorno = listaOrigen.agregar(verticeDestino);
            if (retorno >= 0 ){ //no hubo error
                return true;
            }else{ //hubo error
                return false;
            }
        }else{ //almenos uno no existe
            return false;
        }
    }

    public void imprimir(){
        //la salida será algo así: A (B, C, D)
        //                         B (D, C)
        //recorrer lista de adyacencia
        listaAdyacencia.inicializarIterador();
        while (listaAdyacencia.esIteradorNulo() == false){
            //sacar la lista de la posicion actual
            DatosListaD listaActual = (DatosListaD) listaAdyacencia.obtenerDatoIterador();
            //con la lista actual vamos a recorrer todos sus elementos en donde
            // el primero es el vertice origen y donde el segundo en adelante son vertices
            //destinos
            listaActual.inicializarIterador();
            //voy a imprimir el primero y me voy a mover al segundo
            DatosSalida.consola(listaActual.obtenerDatoIterador() + " (");
            //avanzamos al segúndo
            listaActual.avanzarIterador();
            //acorde la patron de impresión si el segúndo existe lo imprimo antes del while.
            if(listaActual.obtenerDatoIterador() != null){
                DatosSalida.consola(listaActual.obtenerDatoIterador() + "");
                listaActual.avanzarIterador();
                while (listaActual.esIteradorNulo() == false){
                    //en el ciclo me sirve para poner los destinos a partir del segundo destino
                    DatosSalida.consola( ", " + listaActual.obtenerDatoIterador());
                    listaActual.avanzarIterador();
                }
            }
            DatosSalida.consola(") \n");
            //avanzamos en la lista de adyacencia
            listaAdyacencia.avanzarIterador();
        }
    }

    // Recorrido en profundidad
    public DatosListaD recorridoProfundidad(Object origen) {
        PilaD pila = new PilaD();
        DatosListaD marcados = new DatosListaD();
        DatosListaD recorrido = new DatosListaD();
        //1.- tomar un nodo como origen marcarlo y mostrarlo en la pila
        //Primero hay que verificar que el origen exista, buscandolo
        DatosListaD listaOrigen = buscarVertice(origen);
        if (listaOrigen == null) { // no existe
            return null;
        }
        Vertice verticeOrigen = (Vertice) listaOrigen.obtenerPrimero();
        marcados.agregar(verticeOrigen);
        pila.meter(verticeOrigen);
        while (pila.vacio() == false) {
            //2.- mientras existan elemnetos en la pila, sacamos uno y
            // lo mandamos a una lista de elementos procesados
            Vertice verticeActual = (Vertice) pila.sacar();
            recorrido.agregar(verticeActual);
            //3.- los nodos adyacentes al nodo acabado de sacar y que ademas
            // no estan marcados de meten a la pila y se marcan
            marcaryEnpilarAdyacentes(verticeActual, pila, marcados);

        }
        return recorrido;
    }

    private void marcaryEnpilarAdyacentes(Vertice origen, PilaD pila, DatosListaD marcados){
        //para marcar y enpilar adyacentes de ese verticeOrigen
        //primero hay que ir a buscar la lista del origen
        //en la lista adyacencia
        DatosListaD listaOrigen = buscarVertice(origen);
        //ya con ese proceso de tener la lista origen recorreremos los vecinos del primer vertice
        listaOrigen.inicializarIterador();
        //hay que brincar el primero
        listaOrigen.avanzarIterador();
        while (listaOrigen.esIteradorNulo() == false){
            //cada vertice que se extraiga es un vecino
            // hay que checar que no esté marcado
            Vertice verticeVecino = (Vertice) listaOrigen.obtenerDatoIterador();
            if(marcados.buscar(verticeVecino) == null){
                //no está marcado, lo marcamos
                marcados.agregar(verticeVecino);
                //y lo metemos en la pila
                pila.meter(verticeVecino);
            }
            //nos movemos al siguiente vecino.
            listaOrigen.avanzarIterador();
        }
    }

}

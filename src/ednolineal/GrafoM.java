package ednolineal;

import edlineal.ColaE;
import edlineal.DatosListaE;
import edlineal.PilaE;
import ednolineal.auxiliares.Vertice;
import entradasalida.DatosSalida;

public class GrafoM {
    protected ListaE2D aristas; //en esta matriz guardaremos las aristas
    protected DatosListaE vertices; //en un arreglo unidimensional guardaremos los vertices y su descripcion

    public GrafoM(int noVertices){
        aristas = new ListaE2D(noVertices, noVertices);
        vertices = new DatosListaE(noVertices);
    }

    public GrafoM(int noVertices, Object valor){
        aristas = new ListaE2D(noVertices, noVertices);
        vertices = new DatosListaE(noVertices);
        aristas.llenar(valor);
    }

    public boolean agregarVertices(Object valor){
        //antes de agregar un vertice, verificar si existe o no
        int indiceVertice = (int) vertices.buscar(valor); //posicion
        if (indiceVertice >= 0){
            return false;
        }else{//no existe, podemos agregarlo
            //primero creamos un nuevo vertice con el valor dado
            Vertice verticeNuevo = new Vertice(vertices.cantidad(), valor);
            int retorno = vertices.agregar(verticeNuevo);//agregamos vertices
            if (retorno >= 0){ //si pudo agreagar
                return true;
            }else{ //no pudo agregar
                return false;
            }
        }
    }

    public boolean agregarArista(Object origen,Object destino){
        //para poder agregra una arista primero debemos de comprobar si existe el origen y el destino
        int indiceOrigen = (int)vertices.buscar(origen);
        int indiceDestino = (int)vertices.buscar(destino);
        if(indiceOrigen < 0 || indiceDestino < 0){// no existe
            return false;
        }else{// si existe
            // del arreflo de vertices vamos a extraer el origen y destino como objetos.
            // usando las variables indice origen y indice destino.
            Vertice vertOrigen =(Vertice) vertices.obtener(indiceOrigen);
            Vertice vertDestino = (Vertice) vertices.obtener(indiceDestino);
            // sacaremos el numero de los vertices,
            // el cual es el indice
            int posRenglon = vertOrigen.getNumero();
            int posColumn = vertDestino.getNumero();
            return aristas.modificar(posRenglon,posColumn,1.0);
        }
    }

    public void mostrar(){
        //primero imprimimos el arreglo del vertice, recorriendo el arreglo sacando sus vertices de adentro.
        for (int cadaVertice = 0; cadaVertice<vertices.cantidad(); cadaVertice++){
            Vertice verticeTemporal = (Vertice) vertices.obtener(cadaVertice);
            DatosSalida.consola(verticeTemporal.getDescripcion() + " (" + verticeTemporal.getNumero() + ")" + "\n");
        }
        //ahora imprimimos la matriz de aristas
        DatosSalida.consola("\n");
        aristas.imprimirXFilas();
    }

//    // Recorrido en profundidad
//    public DatosListaE recorridoProfundidad(Object origen) {
//        PilaE pila = new PilaE(vertices.cantidad());
//        DatosListaE marcados = new DatosListaE(vertices.cantidad());
//        DatosListaE recorrido = new DatosListaE(vertices.cantidad());
//        // 0. inizializar con puros falsos
//        marcados.llenar(false, vertices.cantidad());
//        //1.- tomar un nodo como origen marcarlo y mostrarlo en la pila
//        //Primero hay que verificar que el origen exista, buscandolo
//        int indiceOrigen = (int) vertices.buscar(origen);
//        if (indiceOrigen < 0) { // no existe
//            return null;
//        }
//
//        Vertice verticeOrigen = (Vertice) vertices.obtener(indiceOrigen);
//        marcados.modificar(verticeOrigen.getNumero(), true);
//        pila.meter(verticeOrigen);
//        while (pila.vacio() == false) {
//            //2.- mientras existan elemnetos en la pila, sacamos uno y
//            // lo mandamos a una lista de elementos procesados
//            Vertice verticeActual = (Vertice) pila.sacar();
//            recorrido.agregar(verticeActual);
//
//            //3.- los nodos adyacentes al nodo acabado de sacar y que ademas
//            // no estan marcados de meten a la pila y se marcan
//            marcaryEnpilarAdyacentes(verticeActual, pila, marcados);
//
//        }
//        return recorrido;
//    }
//
//    private void marcaryEnpilarAdyacentes(Vertice origen, PilaE pila, DatosListaE marcados){
//        // para checar adyaciencias partiendo del origen (una fila)
//        // Revisaremos todos los posibles destinos (columnas de la matriz)
//        for (int cadaDestino = 0; cadaDestino< aristas.getMaxColumnas(); cadaDestino++){
//            // checaresmos si el valor celda(renglon, columna)
//            Object valor = aristas.obtener(origen.getNumero(), cadaDestino);
//            if(valor != null && (double)valor != 0 && (boolean)marcados.obtener(cadaDestino) == false){
//                marcados.modificar(cadaDestino, true);
//                Vertice verticeAdyaciente = (Vertice) vertices.obtener(cadaDestino);
//                pila.meter(verticeAdyaciente);
//            }
//        }
//    }

    private int calcularIncidenciasVertice(Vertice verticeDestino){
        int numIncidencias = 0;
        for(int cadaOrigenR = 0; cadaOrigenR < aristas.noFilas; cadaOrigenR++){
            Object valorCelda = aristas.obtener(cadaOrigenR, verticeDestino.getNumero());
            if(valorCelda != null && (double)valorCelda != 0){
                //existe una flecha hacia ese destino
                numIncidencias++;
            }
        }
        return numIncidencias;
    }

    private void calcularIncidencias(DatosListaE incidencias){
        // calcular las incidencias de todas las columnas (destinos posibles).
        // hacer un barrido de todas las columnas
        for(int cadaDestinoC = 0; cadaDestinoC < aristas.noCols; cadaDestinoC++){
            // invocar al metodo que calcula las incidencias de uno solo de los destinos
            int incidenciaVertice = calcularIncidenciasVertice((Vertice)vertices.obtener(cadaDestinoC));
            incidencias.agregar(incidenciaVertice);
        }
    }

    private void marcarYEncolarI0(DatosListaE incidencias, ColaE cola, DatosListaE marcados){
        //1. marcar el vertice con incidencia en 0
        //recorrer la lista de incidencias en busca de 0's
        for(int cadaPos = 0; cadaPos < incidencias.cantidad(); cadaPos++){
            if((int) incidencias.obtener(cadaPos) == 0 && (boolean)marcados.obtener(cadaPos) == false){

                cola.meter(vertices.obtener(((Vertice)vertices.obtener(cadaPos)).getNumero()));
                //marcarlo como marcado
                marcados.modificar(cadaPos, true);
            }
        }
        //2. encolarlo en la cola
    }

    public void recalcularIncidencias(Vertice verticeActual, DatosListaE incidencias){
        //recorer las columnas de la matriz (los destinos)
        //a los que el vertice origen, les manda una flecha.
        //recalcular las incidencias de los destinos.
        for(int posDestino = 0; posDestino < aristas.noCols; posDestino++){
            Object valorCelda = aristas.obtener(verticeActual.getNumero(), posDestino);
            // invocar al metodo que calcula las incidencias de uno solo de los destinos
            if(valorCelda != null && (double)valorCelda != 0.0){ // hay adyacencia entre el origen y el destino
                //sacar el valor que esta dentro de las incidencias y restarle 1
                int incidenciasRestar = (int) incidencias.obtener(posDestino) - 1;
                incidencias.modificar(posDestino, incidenciasRestar);
            }
        }
    }

    public DatosListaE ordenacionTopologica(){
        //asumiendo que antes de este metodo se validaría que no existieran ciclos.
        DatosListaE ordenacionTopologica = new DatosListaE(vertices.cantidad());
        ColaE cola = new ColaE(vertices.cantidad());
        DatosListaE incidencias = new DatosListaE(vertices.cantidad());
        DatosListaE marcados = new DatosListaE(vertices.cantidad());
        //1. Calcular incidencias de cada nodo.
        calcularIncidencias(incidencias);
        //2. Los nodos con incidencia en 0 se marcan y se meten.
        //antes de hacer este proceso vamos a llenar los marcadosc con falsos.
        marcados.llenar(false);
        marcarYEncolarI0(incidencias, cola, marcados);
        while(cola.vacio() == false) {
            //3. Mientras existan nodos en la cola, secar uno y mandarlo a la OT.
            Vertice verticeActual = (Vertice) cola.sacar();
            ordenacionTopologica.agregar(verticeActual);
            //4. Recacular indicencias con base en el paso
            recalcularIncidencias(verticeActual, incidencias);
            //5. Los nodos con incidencia en 0 se marcan y se meten a la cola.
            marcarYEncolarI0(incidencias, cola, marcados);
        }
        return ordenacionTopologica;
    }

}

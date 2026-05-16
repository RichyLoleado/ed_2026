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
            return aristas.modificar(posRenglon,posColumn,1);
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

    public DatosListaE recorridoProfundidad(Object origen){
        //declarar arreglo y pila que se necesitan
        PilaE pila = new PilaE(vertices.cantidad());
        DatosListaE marcados = new DatosListaE(vertices.cantidad());
        //0. inicializar datoslistaE con puros falsos
        marcados.
        //1. tomar un nodoo como origen marcarloy meterlo a la pila

        //2. mientras existan elementos en la pila, sacamos uno y lo mandamos a nuestra lista de elementos procesados.
        //3. los nodos adyacentes al nodo acabado de sacar y que ordenes no estén marcados, se meten a la pila y se marcarán.
        return null;
    }

    private int calcularIncidenciasVertice(Vertice verticeDestino){
        int numIncidencias = 0;
        for(int cadaOrigenR = 0; cadaOrigenR < aristas.noFilas; cadaOrigenR++){
            Object valorCelda = aristas.obtener(cadaOrigenR, verticeDestino.getNumero());
            if(valorCelda != null && (double)valorCelda != 0.0){
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

                cola.meter(vertices.obtener(((Vertice)vertices.obtener(cadaPos)).getNumero());
                //marcarlo como marcado
                marcados.modificar(cadaPos, true);
            }
        }
        //2. encolarlo en la cola
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
            //4. Recacular indicencias con base en el paso 3
            //5. Los nodos con incidencia en 0 se marcan y se meten a la cola.
            marcarYEncolarI0(incidencias, cola, marcados);
        }
    }

}

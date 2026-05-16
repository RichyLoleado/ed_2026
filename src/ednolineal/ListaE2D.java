package ednolineal;

import edlineal.DatosListaE;
import entradasalida.DatosSalida;

public class ListaE2D {
    protected int noFilas;
    protected int noCols;
    protected Object datos[][];

    //atributos para el encabezado de las filas y columnas
    protected DatosListaE nomFilas;
    protected DatosListaE nomCols;


    public ListaE2D(int noFilas, int noCols){
        this.noFilas = noFilas;
        this.noCols = noCols;
        datos = new Object[noFilas][noCols];
    }

    public ListaE2D(int noFilas, int noCols, Object valor){
        this.noFilas = noFilas;
        this.noCols = noCols;
        datos = new Object[noFilas][noCols];
        llenar(valor); //llenar la matriz con el valor
    }

    public void llenar(Object valor){
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){ //recorrer todas las filas
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){ //recorrer todas las columnas
                datos[cadaFila][cadaCol] = valor; //llenar la matriz con el valor
            }
        }
    }

    public boolean encabezado(DatosListaE nomFilas, DatosListaE nomCols){
        if(nomFilas.cantidad() != noFilas || nomCols.cantidad() != noCols){//validar que tengan la misma
            return false;//no se puede hacer porque son diferentes        // cantidad con el numero de fias y columnas
        }
        this.nomFilas = nomFilas; //guardar los nombres de las filas en los atributos
        this.nomCols = nomCols;//guardar los nombres de las columnas en los atributos
        return true; //pudo hacerlo
    }

    // metodo para validar indices
    public boolean validarIndice(int fila, int col){
        if(fila >= 0 && fila < noFilas && col >= 0 && col < noCols){ //si es valido
            return true;
        }else{
            return false;
        }
    }

    public Object obtener(int fila, int col){
        if(validarIndice(fila, col) == false){
            return null;
        }
        Object datoObtenido = datos[fila][col];
        return datoObtenido;
    }

    public boolean modificar(int fila, int col, Object valor){
        if(validarIndice(fila, col) == false){ //si es una posicion valida
            return false; //terminar el metodo
        }
        datos[fila][col] = valor; //hacer el cambio
        return true;
    }

    public int obtenerRenglones(){
        return noFilas;
    }

    public int obtenerColumnas(){
        return noCols;
    }

    public void imprimirXFilas(){
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                DatosSalida.consola(datos[cadaFila][cadaCol]+" ");
            }
            DatosSalida.consola("\n");
        }
    }

    public void imprimirXColumnas(){
        for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
            for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
                DatosSalida.consola(datos[cadaFila][cadaCol]+" ");
                DatosSalida.consola("\n");
            }
            DatosSalida.consola("\n");
        }
    }

    public ListaE2D transpuesta(){
        ListaE2D listaTranspuesta = new ListaE2D(noCols, noFilas);
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                listaTranspuesta.datos[cadaCol][cadaFila] = datos[cadaFila][cadaCol];
            }
        }
        return listaTranspuesta;
    }

    public ListaE2D copia(){
        ListaE2D listaCopia = new ListaE2D(noFilas, noCols);
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                listaCopia.datos[cadaFila][cadaCol] = datos[cadaFila][cadaCol];
            }
        }
        return listaCopia;
    }

    public boolean esIgual(ListaE2D matriz2){
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                if(datos[cadaFila][cadaCol] != matriz2.datos[cadaFila][cadaCol]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean redefinir(ListaE2D matriz2){
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                datos[cadaFila][cadaCol] = matriz2.datos[cadaFila][cadaCol];
            }
        }
        return true;
    }

    public boolean agregar(int fila, int col, Object valor){
            if(validarIndice(fila, col) == false){
                return false;
            }
            modificar(fila, col, valor);
            return true;
    }


}

package ednolineal;

import entradasalida.DatosSalida;

public class ListaE3D {
    //necesito saber cuantas columnas, filas y profuncidad
    protected int noFilas; //Y
    protected int noCols; //X
    protected int noProf; //Z
    protected Object datos[][][];

    public ListaE3D(int noFilas, int noCols, int noProf){
        this.noFilas = noFilas;
        this.noCols = noCols;
        this.noProf = noProf;
        //fabricamos el espacio de almacenamiento
        datos = new Object[noFilas][noCols][noProf];
    }

    public ListaE3D(int noFilas, int noCols, int noProf, Object valor){
        this.noFilas = noFilas;
        this.noCols = noCols;
        this.noProf = noProf;
        //fabricamos el espacio de almacenamiento
        datos = new Object[noFilas][noCols][noProf];
        llenar(valor);
    }

    private boolean validarIndice(int indice, int limiteSuperior){
        if(indice >= 0 && indice <= limiteSuperior){
            return true; //es valido
        }else{
            return false; // es negativo o superior al indice maximo
        }

    }

    public boolean modificar(int indFila, int indCol, int indProf, Object valor){
        //para ingresar un valor al cubo se necesita:
        //validar que el lugar donde quieras poner el valor, exista.3
        if(validarIndice(indFila, noFilas - 1) == true && validarIndice(indCol, noCols - 1) == true && validarIndice(indProf, noProf - 1) == true){
            //se puede modificar
            datos[indFila][indCol][indProf] = valor;
            return true;
        }else{
            return false;
        }

    }



    public Object obtener(int indFila, int indCol, int indProf){
        if(validarIndice(indFila, noFilas - 1) == true && validarIndice(indCol, noCols - 1) == true && validarIndice(indProf, noProf - 1) == true){
            Object valor = datos[indFila][indCol][indProf];
            return valor;
        }else {
            return null;
        }
    }


    //de hecho hay varios formas de imprimir, se fabricarian como posibilidad varios metodos
    public void imprimirPorColumnas(){
        for(int cadaRebanada = 0; cadaRebanada < noFilas ; cadaRebanada++){
            for(int cadaRenglon = 0; cadaRenglon < noCols; cadaRenglon++){
                for(int cadaCol = 0; cadaCol < noProf; cadaCol++){
                    DatosSalida.consola(datos[cadaRenglon][cadaRebanada][cadaCol]+" ");
                }
                DatosSalida.consola("\n");
            }
            DatosSalida.consola("\n");
        }
    }

    public void llenar(Object valor){
        //llenar el cubo con el valor
        //recorrer todas las filas
        for(int cadaFila = 0; cadaFila <noFilas; cadaFila++){
            //recorrer todas las columnas
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                //recorrer todas las profundidades
                for(int cadaProf = 0; cadaProf < noProf; cadaProf++){
                    datos[cadaFila][cadaCol][cadaProf] = valor;
                }
            }
        }


    }

}

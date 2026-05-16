package ednolineal;

import edlineal.DatosListaEstaticaN;
import librerias.TipoLogaritmo;

public class Lista2DEstaticaN extends ListaE2D {

    //validar si los objetos son numericos
    public boolean esNumero(Object valor) {
        if (valor instanceof Number) { //validar si el valor es numerico
            return true; //si es numerico
        } else {
            return false; //no es numerico
        }
    }

    //metodo para convertir un objeto a double
    public Double convertirDouble(Object valor) {
        return Double.parseDouble(valor.toString()); //convertir el valor a double
    }


    public Lista2DEstaticaN(int noFilas, int noCols) {
        super(noFilas, noCols); //llamar al constructor de la super clase
        llenar(0); //llenar con ceros
    }

    public Lista2DEstaticaN(int noFilas, int noCols, Object valor) {
        super(noFilas, noCols); //llamar al constructor de la super clase
        if (esNumero(valor) == true) { //validar si el valor es numerico
            double valor2 = convertirDouble(valor); //convertir el valor a double
            llenar(valor2); //llenar con el valor
        }else{ //no es numerico
            llenar(0); //llenar con ceros
        }
    }

    public boolean porEscalar(Number escalar){
        double esc = convertirDouble(escalar);
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                double valor = convertirDouble(datos[cadaFila][cadaCol]);
                double resultado = valor * esc;
                datos[cadaFila][cadaCol] = resultado;
            }
        }
        return true;
    }

    public boolean porEscalares(DatosListaEstaticaN escalares){
        if(escalares.cantidad() != (noFilas * noCols)){
            return false;
        }
        int posEscalar = 0;
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){ // pasar por cada fila
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){ // pasar por cada columna
                double valor = convertirDouble(datos[cadaFila][cadaCol]); // convertir a double el valor de la casilla
                double escalar = convertirDouble(escalares.obtener(posEscalar)); //convertir a double el valor del escalar
                double resultado = valor * escalar; //multiplicar por el escalar
                datos[cadaFila][cadaCol] = resultado;
                posEscalar++;
            }
        }
        return true;
    }

    public boolean sumarEscalar(Number escalar){
        double esc = convertirDouble(escalar);
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){ // pasar por cada fila
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){ // pasar por cada columna
                double valor = convertirDouble(datos[cadaFila][cadaCol]);  // convertir a double el valor de la casilla
                double resultado = valor + esc; //sumar por el escalar
                datos[cadaFila][cadaCol] = resultado; // resultado de la suma a resultado
            }
        }
        return true; // todo bien
    }

    public boolean sumarEscalares(DatosListaEstaticaN escalares){
        if(escalares.cantidad() != (noFilas * noCols)){
            return false;
        }
        int posEscalar = 0;
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){ // pasar por cada fila
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){ // pasar por cada columna
                double valor = convertirDouble(datos[cadaFila][cadaCol]); // convertir a double el valor de la casilla
                double escalar = convertirDouble(escalares.obtener(posEscalar)); //convertir a double el valor del escalar
                double resultado = valor + escalar; //sumar el valor por el escalar
                datos[cadaFila][cadaCol] = resultado;
                posEscalar++;
            }
        }
        return true;
    }

    public boolean multiplicar(Lista2DEstaticaN matriz2){
        if(noCols != matriz2.noFilas){
            return false;
        }

        Object matrizTemp[][] = new Object[noFilas][matriz2.noCols]; //craar matriz temporal

        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){ // pasar por cada fila
            for(int cadaCol = 0; cadaCol < matriz2.noCols; cadaCol++){ // pasar por cada columna
                double suma = 0; //suma de los valores de la matriz
                for(int posMulti = 0; posMulti < noCols; posMulti++){ // pasar por cada posicion de la matriz
                    double vMatriz1 = convertirDouble(datos[cadaFila][posMulti]); //convertir a double el valor de la casilla
                    double vMatriz2 = convertirDouble(matriz2.datos[posMulti][cadaCol]); //convertir a double el valor de la casilla
                    double resMulti = vMatriz1 * vMatriz2; //multiplicar los valores
                    suma = suma + resMulti; //sumar los valores
                }
                matrizTemp[cadaFila][cadaCol] = suma; //guardar el resultado en la matriz temporal
            }
        }
        datos = matrizTemp; // reemplazar la matriz por la matriz temporal
        noCols = matriz2.noCols;
        return true;
    }

    public boolean sumar(Lista2DEstaticaN matriz2){
        if(noFilas != matriz2.noFilas || noCols != matriz2.noCols){
            return false;
        }
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                double vMatriz1 = convertirDouble(datos[cadaFila][cadaCol]);
                double vMatriz2 = convertirDouble(matriz2.datos[cadaFila][cadaCol]);
                double resultado = vMatriz1 + vMatriz2;
                datos[cadaFila][cadaCol] = resultado;
            }
        }
        return true;
    }

    public boolean aplicarPotencia(Number escalar){
        double esc = convertirDouble(escalar);
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                double valor = convertirDouble(datos[cadaFila][cadaCol]);
                double resultado = Math.pow(valor, esc);
                datos[cadaFila][cadaCol] = resultado;
            }
        }
        return true;
    }

    public boolean aplicarLogaritmo(TipoLogaritmo tipoLogaritmo){
        for(int cadaFila = 0; cadaFila < noFilas; cadaFila++){
            for(int cadaCol = 0; cadaCol < noCols; cadaCol++){
                double valor = convertirDouble(datos[cadaFila][cadaCol]);
                double resultado = 0;
                if(tipoLogaritmo == TipoLogaritmo.NATURAL){
                    resultado = Math.log(valor);
                } else if (tipoLogaritmo == TipoLogaritmo.BASE2) {
                    resultado = Math.log(valor) / Math.log(2);
                } else if (tipoLogaritmo == TipoLogaritmo.BASE10) {
                    resultado = Math.log10(valor);
                }
                datos[cadaFila][cadaCol] = resultado;
            }
        }
        return true;
    }

    @Override
    public boolean agregar(int fila, int col, Object valor){
        if(esNumero(valor) == false){
            return false;
        }
        super.agregar(fila, col, valor);
        return true;
    }

}
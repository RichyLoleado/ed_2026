package examenes;

import edlineal.DatosListaE;
import edlineal.*;
import entradasalida.DatosSalida;

public class RegresionLineal {

        //separar datos
//        public void separarDatos(DatosListaE datosArchivo, double valoresX[], double valoresY[]) {
//            int cantidadDatos = datosArchivo.cantidad(); //cantidad de datos
//            for (int posicion = 0; posicion < cantidadDatos; posicion++) { // pasar por cada posicion
//                String lineaActual = datosArchivo.obtener(posicion).toString(); //convertir a string
//                String partes[] = lineaActual.split("\\s+");// esto divide la cadena en partes donde hay un espacio
//                double valorX = Double.parseDouble(partes[0]); //convertir a double el valor de la primera parte
//                double valorY = Double.parseDouble(partes[1]); //convertir a double el valor de la segunda parte
//                valoresX[posicion] = valorX; //guardar los valores
//                valoresY[posicion] = valorY;//guardar los valores
//            }
//        }
        //calcular modelo
        public void calcularModelo(double valoresX[], double valoresY[]) { //
            double p = 0;
            double b = 0;
            double a = 0.001;
            int cantidadDatos = valoresX.length; //cantidad de datos
            for (int iteracion = 0; iteracion < 10000; iteracion++) { //pasar por cada iteracion
                double sumaErrorP = 0; //suma de los errores
                double sumaErrorB = 0; //suma de los errores
                for (int posicion = 0; posicion < cantidadDatos; posicion++) { // pasar por cada posicion
                    double valorX = valoresX[posicion]; //convertir a double el valor de la primera parte
                    double valorYReal = valoresY[posicion]; //convertir a double el valor de la segunda parte
                    double valorYPredicho = p + b * valorX; //calcular el valor predicho
                    double error = valorYPredicho - valorYReal; //calcular el error
                    sumaErrorP = sumaErrorP + error; //sumar los errores
                    sumaErrorB = sumaErrorB + error * valorX;
                }
                p = p - a * sumaErrorP; //actualizar los valores
                b = b - a * sumaErrorB;
            }
            DatosSalida.consola("Valor de p: " + p); //imprimir los valores
            DatosSalida.consola("Valor de b: " + b);
            DatosSalida.consola("Modelo: y = " + p + " + " + b + "x");
        }

        //metodo para ejecutar el programa
    public void ejecutar(DatosListaE datosArchivo) {
        int cantidadDatos = datosArchivo.cantidad();
        double valoresX[] = new double[cantidadDatos];
        double valoresY[] = new double[cantidadDatos];
//        separarDatos(datosArchivo, valoresX, valoresY);
        calcularModelo(valoresX, valoresY);
    }

    }



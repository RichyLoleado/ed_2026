package librerias;

import edlineal.*;
import java.io.*;

public class ArchivoTextoDatos {
    public static DatosListaE leer(String archivo){
        FileReader input = null;
        DatosListaE datos = null;
        BufferedReader buffer = null;
        try {
            String cadena = null;
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            // Contar líneas
            datos = new DatosListaE((int) buffer.lines().count());
            buffer.close();
            input.close();
            // Volver a abrir para leer contenido
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            while((cadena = buffer.readLine()) != null) {
                datos.agregar(cadena); // aquí sí está bien porque es String
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (input != null) input.close();
                if (buffer != null) buffer.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }
    public static void escribir(DatosListaE arreglo, String archivo){
        FileWriter output = null;
        try {
            output = new FileWriter(archivo);
            for(int posicion = 0; posicion < arreglo.cantidad() - 1; posicion++) {
                output.write(arreglo.obtener(posicion).toString() + "\n");
            }
            output.write(arreglo.obtener(arreglo.cantidad() - 1).toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (output != null) output.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
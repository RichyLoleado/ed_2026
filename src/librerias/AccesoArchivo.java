package librerias;

import ednolineal.ArbolBB;
import ednolineal.auxiliares.NodoBusquedaArbol;

import java.io.*;

public class AccesoArchivo {

    public void leerArchivo(String ruta, ArbolBB arbol) throws IOException {
        boolean finArchivo = false;
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(ruta, "r");
            System.out.println("El tamaño es: " + archivo.length());
            String cad = "";
            archivo.readLine(); //saltar la primera liena (por el encabezado del csv)
            while(true) {
                System.out.print(archivo.getFilePointer());
                cad = archivo.readLine();
                if(cad == null)
                    break;

                String[] datos = cad.split(","); //divide el registro leido por comas
                int indice = Integer.parseInt(datos[0]); //obtener el primer campo del registro (el id)
                NodoBusquedaArbol nodo = new NodoBusquedaArbol(indice, (int) archivo.getFilePointer()); //crear un objeto que guarda el indice y la direccion del archivo
                arbol.agregar(nodo); //agregar el nodo al arbol

                System.out.println(" - " + cad);
            }
        } catch(FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");
        }
        System.out.println("\n");
        archivo.seek(9071);
        System.out.println(archivo.readLine());
        System.out.println("\n");
        archivo.close();
    }
}
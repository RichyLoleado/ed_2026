package principales;

import ednolineal.ArbolBB;
import ednolineal.auxiliares.NodoBusquedaArbol;
import entradasalida.DatosSalida;
import librerias.AccesoArchivo;

import java.io.IOException;

public class PrincipalAccesoArchivo {
    public static void main(String[]args) throws IOException {
        AccesoArchivo archivo = new AccesoArchivo();
        ArbolBB arbol = new ArbolBB();
        archivo.leerArchivo("C:\\Users\\richy\\Documentos\\MiEspacio\\Universidad\\4toSemestre\\ed_2026\\ed_2026\\datos_ordenes\\orders.csv", arbol);
        arbol.inorden();
        DatosSalida.consola("\n");
        DatosSalida.consola("Buscando (1): " + arbol.buscar(1) + "\n");
        DatosSalida.consola("Buscando (2354): " + arbol.buscar(2354) + "\n");
        DatosSalida.consola("Buscando (1000000000): " + arbol.buscar(1000000000) + "\n");
        DatosSalida.consola("Buscando ( 2382): " + arbol.buscar( 2382) + "\n");
    }
}

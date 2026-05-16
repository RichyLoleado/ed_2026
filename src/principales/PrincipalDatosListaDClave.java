package principales;

import edlineal.DatosLista;
import ednolineal.DatosListaDClave;
import entradasalida.DatosSalida;

public class PrincipalDatosListaDClave {
    public static void main(String[]args){
        DatosListaDClave lista = new DatosListaDClave();
        lista.agregar(1, "Juan");
        lista.agregar(2, "Beto");
        lista.agregar(3, "Lucia");

        //imprimir lista
        DatosSalida.consola("\n");
        DatosSalida.consola("Lista: ");
        lista.imprimir();

        DatosSalida.consola("\n");
        DatosSalida.consola("----------- Modificar------------");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        //modificar por clave
        lista.imprimir();
        DatosSalida.consola("\n");
        lista.modificar(2, "Pedro");
        DatosSalida.consola("\n");
        lista.imprimir();

        //buscar por clave
        DatosSalida.consola("Buscando por clave(2) : " +  lista.buscar(2));

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //buscar por valor
        DatosSalida.consola("Buscando por valor(Lucia) : " +  lista.buscarContenido("Lucia"));

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //eliminar por contenido
        //DatosSalida.consola("eliminando por contenido(Juan) : " +  lista.eliminarContenido("Juan"));

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //modificar por Valor
        DatosSalida.consola("Modificando por contenido(Lucia por Pedro) " + lista.modificarValor("Lucia", "Pedro"));
        DatosSalida.consola("\n");
        DatosSalida.consola("Encontrado en la lista" + lista.buscarContenido("Pedro"));
        DatosSalida.consola("\n");
        DatosSalida.consola("Clave (3) es pedro? : " + lista.buscar(3));

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");

        //imprimir lista completa
        lista.imprimir();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        //imprimir lista por claves
        lista.imprimirClaves();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        //imprimir lista por valores
        lista.imprimirValores();

        DatosSalida.consola("\n");
        DatosSalida.consola("-----------------------");
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        // convertir a listas estaticas
        DatosSalida.consola("La conversion a lista estatica es: " + lista.aListasEstaticas());

    }





}

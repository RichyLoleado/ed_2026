package principales;

import entradasalida.DatosSalida;
import registros.ventas.Articulo;
import registros.ventas.Cliente;
import registros.ventas.GestionNotas;

public class PrincipalNotas {
    public static void main(String[]args){
        GestionNotas tienda = new GestionNotas("PATIO DOCE", 3, 2);

        Cliente cliente1 = new Cliente("PURRO2930242", "LILIAN", 26 );

        Cliente cliente2 = new Cliente("384891348rwefs" , "RICHARD", 25);

        tienda.agregarVendedor("JUAN NADA", "ABCDE12345678910");
        tienda.agregarVendedor("Masiosare", "XYZ12345678910");

        Articulo art1 = new Articulo("1", "Pluma", 10, 20);
        Articulo art2 = new Articulo("2", "Gomal", 8, 21);
        Articulo art3 = new Articulo("3", "Lápiz", 11, 23);
        Articulo art4 = new Articulo("4", "Sacas", 5, 24);

        int folio1 = tienda.agregarNota(cliente1, "10/12/25", 4);
        int folio2 = tienda.agregarNota(cliente1, "11/11/26", 2);

        //con ese folio
        tienda.agregarArticulo(folio1, art1, 4);
        tienda.agregarArticulo(folio1, art2, 3);
        tienda.agregarArticulo(folio2, art3, 2);
        tienda.agregarArticulo(folio2, art4, 1);

        tienda.agregarArticulo(folio2, art1, 10);
        tienda.agregarArticulo(folio2, art4, 20);

        DatosSalida.consola("Imprimiendo datos de... " + tienda.getNombre() + "\n\n");
        tienda.imprimirNota(folio1);
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        tienda.imprimirNota(folio2);



    }
}

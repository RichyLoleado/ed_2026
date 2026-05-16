package principales;

import edlineal.DatosListaD;

public class PrincipalDatosListaD {
    public static void main (String[] args) {
        DatosListaD lista = new DatosListaD();
        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("C");
        lista.agregar("D");
        lista.mostrarOI();
    }
}

package principales;

import entradasalida.DatosSalida;
import librerias.TamanoImagen;
import registros.imagenes.ManipuladorImagenes;

import java.io.IOException;

public class PrincipalManipuladorImagenes {
    public static void main(String[]args) throws IOException {

        ManipuladorImagenes imagen = new ManipuladorImagenes();
        imagen.cargarImagen("C:\\Users\\richy\\Documentos\\MiEspacio\\Universidad\\4toSemestre\\ed_2026\\ed_2026\\imagenes\\alberhitler.jpg");
        //escala de grises
        imagen.convertirEscalaGrises();
        imagen.guardarImagen("escalaGrises");

        //modificar brillo
        imagen.modificarBrillo(50);
        imagen.guardarImagen("modificarBrillo");

        //invertirHorizontal
        imagen.invertirHorizontal();
        imagen.guardarImagen("invertirHorizontal");

        //invertirVertical
        imagen.invertirVertical();
        imagen.guardarImagen("invertirVertical");

        //Rotar90Grados
        imagen.rotar90();
        imagen.guardarImagen("rotar90");

        //rotar180Grados
        imagen.rotar180();
        imagen.guardarImagen("rotar180");

        //rotar270Grados
        imagen.rotar270();
        imagen.guardarImagen("rotar270");

        //dimensionar doble
        imagen.redimensionar(TamanoImagen.DOBLE);
        imagen.guardarImagen("redimensionarDoble");

        //dimensionar triple
        imagen.redimensionar(TamanoImagen.TRIPLE);
        imagen.guardarImagen("redimensionarTriple");

        //dimensionar mitad
        imagen.redimensionar(TamanoImagen.MITAD);
        imagen.guardarImagen("redimensionarMitad");

        //dimensionar cuarta parte
        imagen.redimensionar(TamanoImagen.CUARTA_PARTE);
        imagen.guardarImagen("redimensionarCuartaParte");

        //dimensionar con parametros
      //  imagen.redimensionar(100, 500);
        //imagen.guardarImagen("redimensionarConParametros");

        //Agregar marco
        imagen.agregarMarco(10, 255);
        imagen.guardarImagen("agregarMarco");

        //invertir colores
        imagen.invertirColores();
        imagen.guardarImagen("invertirColores");
    }
}

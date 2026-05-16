package principales;

import entradasalida.DatosSalida;
import entradasalida.archivos.AudioFileRecord;

public class PrincipalAudio {
    public static void main(String[]args){

        AudioFileRecord archivo = new AudioFileRecord("C:\\Users\\richy\\Documentos\\MiEspacio\\Universidad\\4toSemestre\\ed_2026\\ed_2026\\archivosonido.wav");
        archivo.leerAudio(); //leer audio
        archivo.bufferAListaNum(); //pasar a listaN

//        //subir voluumen
//        archivo.subirVolumen(2); //subir volumen
//        archivo.numAListaBuffer(); //pasar a buffer2 para poder escribirlo
//        archivo.EscribirAudio(); //escribir audio

//        //bajar volumen
//        archivo.bajarVolumen(3);
//        archivo.numAListaBuffer();
//        archivo.EscribirAudio();

        //acelerar audio
        archivo.acelerarAudio(2);
        archivo.numAListaBuffer();
        archivo.EscribirAudio();

//        //retrasar audio
//        archivo.retrasarAudio(2);
//        archivo.numAListaBuffer();
//        archivo.EscribirAudio();

//        //eliminar silencio
//        archivo.eliminarSilencio();
//        archivo.numAListaBuffer();
//        archivo.EscribirAudio();

        //invertir audio
//        archivo.invertirAudio();
//        archivo.numAListaBuffer();
//        archivo.EscribirAudio();

//        //invertir intensidad
//        archivo.invertirIntensidad();
//        archivo.numAListaBuffer();
//        archivo.EscribirAudio();




    }
}

package registros.imagenes;

import ednolineal.Lista2DEstaticaN;
import librerias.TamanoImagen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManipuladorImagenes {
    //atributos de la imagen
    private Lista2DEstaticaN pixeles; //lista para guardar los pixeles de la imagen
    private int ancho; //ancho de la imagen
    private int alto; //alto de la imagen

    private BufferedImage imagenOriginal; //imagen original
    private BufferedImage imagenResultado; //resultado de la manipulacion

    public boolean cargarImagen(String direccion) throws IOException {
        imagenOriginal = ImageIO.read(new File(direccion)); //carga la imagen original
        ancho = imagenOriginal.getWidth(); //obtiene el ancho y el alto de la imagen
        alto = imagenOriginal.getHeight();

        pixeles = new Lista2DEstaticaN(alto, ancho); //crear lista para guardar los pixeles

        for(int fila = 0; fila < alto; fila++){ //recorrer la imagen por fila
            for(int col = 0; col < ancho; col++){ //recorrer la imagen por columna
                int pixel; //obtener el pixel de la imagen
                pixel = imagenOriginal.getRGB(col, fila);
                pixeles.agregar(fila,col, pixel); //agregar el pixel a la lista
            }
        }
        return true;
    }

//    public int extraerAlfa(int pixel){
//        return (pixel >> 24) & 255; //extraer el canal alfa del pixel
//    }

    public int extraerAlfa(int pixel){
        return (pixel >> 24) & 255;
    }

    public int extraerRojo(int pixel){
        return (pixel >> 16) & 255; //extraer el canal rojo del pixel
    }

    public int extraerVerde(int pixel){
        return (pixel >> 8) & 255; //extraer el canal verde del pixel
    }

    public int extraerAzul(int pixel){
        return pixel & 255; //extraer el canal azul del pixel
    }

    public int armarPixel(int alfa, int rojo, int verde, int azul){ //metodo para juntar los valores de los canales en un solo pixel
        return (alfa << 24) | (rojo << 16) | (verde << 8) | azul; //armar el pixel
    }

    public boolean convertirEscalaGrises(){
        imagenResultado = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        //recorrer la imagen por filas
        for(int fila = 0; fila < alto; fila++){
            for(int col = 0; col < ancho; col++){ //recorrer la imagen por columnas
                int pixel = imagenOriginal.getRGB(col, fila); //sacar el pixel de la imagen
                int alfa = extraerAlfa(pixel); //extraer el canal alfa del pixel
                int rojo = extraerRojo(pixel); //extraer el canal rojo del pixel
                int verde = extraerVerde(pixel); //extraer el canal verde del pixel
                int azul = extraerAzul(pixel); //extraer el canal azul del pixel

                int gris = (rojo + verde + azul) / 3; //promediar los valores de los canales
                int nuevoPixel = armarPixel(alfa, gris, gris, gris); //armar el pixel con los nuevos valores
                imagenResultado.setRGB(col, fila, nuevoPixel); //poner el pixel en la imagen resultado

            }
        }
        return true;
    }

    public boolean modificarBrillo(int brillo){
        if(imagenResultado == null){
            return false;
        }
        for(int fila = 0; fila < alto; fila++){
            for(int col = 0; col < ancho; col++){
                int pixel = imagenResultado.getRGB(col, fila);
                int alfa = extraerAlfa(pixel);
                int rojo = extraerRojo(pixel);
                int verde = extraerVerde(pixel);
                int azul = extraerAzul(pixel);

                rojo = rojo + brillo;
                verde = verde + brillo;
                azul = azul + brillo;

                if(rojo > 255){
                    rojo = 255;
                }
                if(verde > 255){
                    verde = 255;
                }
                if(azul > 255){
                    azul = 255;
                }
                if(rojo < 0){
                    rojo = 0;
                }
                if(verde < 0){
                    verde = 0;
                }
                if(azul < 0){
                    azul = 0;
                }
                int nuevoPixel = armarPixel(alfa, rojo, verde, azul);
                imagenResultado.setRGB(col, fila, nuevoPixel);
            }
        }
        return true;
    }

    public boolean invertirHorizontal(){
        BufferedImage imagenAuxiliar = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB); //crear imagen auxiliar para invertir
        for(int fila = 0; fila < alto; fila++){
            for(int col = 0; col < ancho; col++){
                int pixel = imagenOriginal.getRGB(col, fila);
                int colInvertida = ancho - 1 - col;
                imagenAuxiliar.setRGB(colInvertida, fila, pixel);

            }
        }
        imagenResultado = imagenAuxiliar;
        return true;
    }

    public boolean invertirVertical(){
        BufferedImage imagenAuxiliar = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB); //crear imagen auxiliar para invertir
        for(int fila = 0; fila < alto; fila++){
            for(int col = 0; col < ancho; col++){
                int pixel = imagenOriginal.getRGB(col, fila);
                int filaInvertado = alto - 1 - fila;
                imagenAuxiliar.setRGB(col, filaInvertado, pixel);

            }
        }
        imagenResultado = imagenAuxiliar;
        return true;
    }

    public boolean rotar90(){
        BufferedImage imagenAuxiliar = new BufferedImage(alto, ancho, BufferedImage.TYPE_INT_RGB); //crear imagen auxiliar para rotar
        for(int fila = 0; fila < alto; fila++){  //pasar por cada fila
            for(int col = 0; col < ancho; col++){ //pasar por cada columna
                int pixel = imagenOriginal.getRGB(col, fila); //sacar el pixel de la imagen
                int newCol = alto - 1 - fila; //invertir las filas
                int newFila = col; //tener las columnas sin cambiar
                imagenAuxiliar.setRGB(newCol, newFila, pixel); //poner el pixel en la imagen auxiliar
            }
        }
        imagenResultado = imagenAuxiliar; //reemplazar la imagen original por la imagen auxiliar

        //hacer swap de ancho y alto
        int aux = ancho;
        ancho = alto;
        alto = aux;
        return true;
    }

    public boolean rotar180(){
        int ancho = imagenOriginal.getWidth();
        int alto = imagenOriginal.getHeight();
        BufferedImage imagenAuxiliar = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB); //crear imagen auxiliar para rotar
        for(int fila = 0; fila < alto; fila++){ // pasar por cada fila
            for(int col = 0; col < ancho; col++){ // pasar por cada columna
                int pixel = imagenOriginal.getRGB(col, fila); // sacar el pixel de la imagen
                int newCol = ancho - 1 - col; // invertir las columnas
                int newFila = alto - 1 - fila; // invertir las filas
                imagenAuxiliar.setRGB(newCol, newFila, pixel); // poner el pixel en la imagen auxiliar
            }
        }
        imagenResultado = imagenAuxiliar; // reemplazar la imagen original por la imagen auxiliar
        //aquí no hago swap de ancho y alto por que quedan igual
        return true;
    }

    public boolean rotar270(){
        int ancho = imagenOriginal.getWidth();
        int alto = imagenOriginal.getHeight();
        BufferedImage imagenAuxiliar = new BufferedImage(alto, ancho, BufferedImage.TYPE_INT_RGB);
        for(int fila = 0; fila < alto; fila++){ //pasar por cada fila
            for(int col = 0; col < ancho; col++){ //pasar por cada columna
                int pixel = imagenOriginal.getRGB(col, fila); //sacar el pixel de la imagen
                int newCol = fila; // invertir las columnas
                int newFila = ancho - 1 - col; // invertir las filas
                imagenAuxiliar.setRGB(newCol, newFila, pixel); // poner el pixel en la imagen auxiliar
            }
        }
        imagenResultado = imagenAuxiliar; //reemplazar la imagen original por la imagen auxiliar
        //aplicar un swap de ancho y alto
        int aux = ancho;
        ancho = alto;
        alto = aux;
        return true;
    }

    public boolean redimensionar(TamanoImagen tamano){
        int newAncho = ancho;
        int newAlto = alto;

        //calcular tamano de la imagen segun el tamano seleccionado
        if(tamano == TamanoImagen.DOBLE){
            newAncho = ancho * 2;
            newAlto = alto * 2;
        } else if (tamano == TamanoImagen.TRIPLE) {
            newAncho = ancho * 3;
            newAlto = alto * 3;
        } else if (tamano == TamanoImagen.MITAD) {
            newAncho = ancho / 2;
            newAlto = alto / 2;
        } else if (tamano == TamanoImagen.CUARTA_PARTE) {
            newAncho = ancho / 4;
            newAlto = alto / 4;
        }

        BufferedImage imagenAuxiliar = new BufferedImage(newAncho, newAlto, BufferedImage.TYPE_INT_RGB);
        ancho = imagenOriginal.getWidth();
        alto = imagenOriginal.getHeight();
        for(int fila = 0; fila < newAlto; fila++){
            for(int col = 0; col < newAncho; col++){
                int filaNueva = fila * alto / newAlto;
                int colNueva = col * ancho / newAncho;
                int pixel = imagenOriginal.getRGB(colNueva, filaNueva);
                imagenAuxiliar.setRGB(col, fila, pixel);
            }
        }
        imagenResultado = imagenAuxiliar;
        ancho = newAncho;
        alto = newAlto;
        return true;
    }

    public boolean redimensionar(int newAncho, int newAlto){
        ancho = imagenOriginal.getWidth();
        alto = imagenOriginal.getHeight();
        BufferedImage imagenAuxiliar = new BufferedImage(newAncho, newAlto, BufferedImage.TYPE_INT_RGB);
        for(int fila = 0; fila < newAlto; fila++){
            for(int col = 0; col < newAncho; col++){
                int filaNueva = fila * alto / newAlto;
                int colNueva = col * ancho / newAncho;
                int pixel = imagenOriginal.getRGB(colNueva, filaNueva);
                imagenAuxiliar.setRGB(col, fila, pixel);
            }
        }
        imagenResultado = imagenAuxiliar;
        ancho = newAncho;
        alto = newAlto;
        return true;
    }


    public boolean agregarMarco(int grosor, int colorMarco) {
        if (grosor <= 0) { //validar que el grosor sea mayor a 0
            return false;
        }
        int nuevoAncho = ancho + (2 * grosor); //calcular el nuevo ancho de la imagen
        int nuevoAlto = alto + (2 * grosor); //calcular el nuevo alto de la imagen

        BufferedImage imagenAuxiliar = new BufferedImage(nuevoAncho, nuevoAlto, BufferedImage.TYPE_INT_RGB);
        //llenar marco con el color
        for (int fila = 0; fila < nuevoAlto; fila++){
            for(int col = 0; col < nuevoAncho; col++){
                imagenAuxiliar.setRGB(col, fila, colorMarco);
            }
        }
        //poner la imagen original en el centro
        for(int fila = 0; fila < alto; fila++){
            for(int col = 0; col < ancho; col++){
                int pixel = imagenOriginal.getRGB(col, fila);
                imagenAuxiliar.setRGB(col + grosor, fila + grosor, pixel);
            }
        }
        imagenResultado = imagenAuxiliar;
        ancho = nuevoAncho;
        alto = nuevoAlto;
        return true;
    }

    public boolean invertirColores(){
        int ancho = imagenOriginal.getWidth();
        int alto = imagenOriginal.getHeight();
        BufferedImage imagenAuxiliar = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for(int fila = 0; fila < alto; fila++){
            for(int col = 0; col < ancho; col++){
                int pixel = imagenOriginal.getRGB(col, fila);
                int alfa = extraerAlfa(pixel);
                int rojo = extraerRojo(pixel);
                int verde = extraerVerde(pixel);
                int azul = extraerAzul(pixel);
                rojo = 255 - rojo;
                verde = 255 - verde;
                azul = 255 - azul;
                int nuevoPixel = armarPixel(alfa, rojo, verde, azul);
                imagenAuxiliar.setRGB(col, fila, nuevoPixel);
            }
        }
        imagenResultado = imagenAuxiliar;
        return true;
    }

    public boolean guardarImagen(String operacion){
        try{
            File archivoSalida = new File("C:\\Users\\richy\\Documentos\\MiEspacio\\Universidad\\4toSemestre\\ed_2026\\ed_2026\\imagenes\\alberhitler"+ operacion +".jpg");
            ImageIO.write(imagenResultado, "JPG", archivoSalida);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}

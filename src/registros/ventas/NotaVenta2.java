package registros.ventas;

import edlineal.DatosListaD;
import edlineal.DatosListaE;
import entradasalida.DatosSalida;

public class NotaVenta2 {
    //encabezado
    private int folio;
    private Vendedor vendedor;
    private Cliente cliente;
    private String fecha;
    //detalle
    private DatosListaD articulos;
    private DatosListaD cantidadArt;
    private double total;

    //define el encabezado de la nota
    public NotaVenta2(int folio, Vendedor vendedor, Cliente cliente, String fecha){
        this.folio = folio;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.fecha = fecha;
        articulos = new DatosListaD ();
        cantidadArt = new DatosListaD ();
    }

    //define el detalle de la nota
    public boolean agregarArticulo(Articulo articulo, int cantidad){
        // se agregam estos datos a los arreglos paralelos
        articulos.agregar(articulo);
        cantidadArt.agregar(cantidad);
        //si se llega a este punto es por que salio bien
        return true;
    }

    public Double calcularTotal(){
        double subtotal = 0.0;
        //recorre cada uno de los articulos y sus cantidades para calcular el total
        articulos.inicializarIterador(); //lista cantidades
        cantidadArt.inicializarIterador();// lista articulos
        while (articulos.esIteradorNulo() == false) {
            Articulo articuloTemp = (Articulo)articulos.obtenerDatoIterador();
            int cantidad = (int)cantidadArt.obtenerDatoIterador();
            subtotal = subtotal + cantidad * articuloTemp.getPrecio();
            articulos.avanzarIterador();
            cantidadArt.avanzarIterador();
        }

        total = subtotal; //asignamos a atributo total el subtotal acumulado.
        return total;
    }

    public void imprimirNota(){
        //datos de encabezado
        DatosSalida.consola("Folio: " + folio +"\t\t\t");
        DatosSalida.consola("Fecha: " + fecha + "\n");
        DatosSalida.consola("Vendedor: " + vendedor.getNombre() + "\n");
        DatosSalida.consola("Cliente: " + cliente.getNombre() + "\n");


        DatosSalida.consola(" No. " + "\t\t\t" );
        DatosSalida.consola(" Descripción " + "\t\t\t");
        DatosSalida.consola(" Precio " + "\t\t\t");
        DatosSalida.consola(" Cantidad " + "\t\t\t");
        DatosSalida.consola(" Subtotal " + "\n");
        //datos de detalle de la nota
        //como se procesa un articulo con sus datos y cantidad comprada
        //y ese proceso se repite tantas veces sean los articulos comprados usamos un ciclo
        //iniclializamos iteradores de las 2 listas
        articulos.inicializarIterador();
        cantidadArt.inicializarIterador();
        //creamos la variable para
        int indiceArt = 1;

        while (articulos.esIteradorNulo() == false){
            //sacar el articulo de dentro del arreglo
            Articulo artTemp= (Articulo)articulos.obtenerDatoIterador();
            int cantTemp = (int)cantidadArt.obtenerDatoIterador();
            //imprimir los datos de un solo renglon o fila por iteracion
            DatosSalida.consola((indiceArt) + "" + "\t\t\t");
            DatosSalida.consola(artTemp.getDescripcion() + "\t\t\t");
            DatosSalida.consola(artTemp.getPrecio() + "\t\t\t");
            DatosSalida.consola(cantTemp + "" +  "\t\t\t");
            DatosSalida.consola((artTemp.getPrecio() * cantTemp) + "\n");
            indiceArt++;
            //avanzamos a las siguientes posiciones de las listas
            articulos.avanzarIterador();
            cantidadArt.avanzarIterador();
        }
        //despues del ciclo de que imprime todos los articulos, se imprime el total
        DatosSalida.consola("Total: " + total + "\t\t\t\t\t\t\t\t" + calcularTotal() + "\n\n");
    }

    public String toString(){
        return folio + "";
    }

    public int getFolio() {
        return folio;
    }

}

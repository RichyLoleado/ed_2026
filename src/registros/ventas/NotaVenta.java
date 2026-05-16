package registros.ventas;

import edlineal.DatosListaE;
import entradasalida.DatosSalida;

public class NotaVenta {
    //encabezado
    private int folio;
    private Vendedor vendedor;
    private Cliente cliente;
    private String fecha;
    //detalle
    private DatosListaE articulos;
    private DatosListaE cantidadArt;
    private double total;

    //define el encabezado de la nota
    public NotaVenta(int folio, Vendedor vendedor, Cliente cliente, String fecha, int totalArticulos){
        this.folio = folio;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.fecha = fecha;
        articulos = new DatosListaE (totalArticulos);
        cantidadArt = new DatosListaE(totalArticulos);
    }

    //define el detalle de la nota
    public boolean agregarArticulo(Articulo articulo, int cantidad){
        // se agregam estos datos a los arreglos paralelos
        int retorno = articulos.agregar(articulo);
        if(retorno < 0){ //hubo un error no se pudo agregar
            return false; //no pude agregar
        }
        retorno = cantidadArt.agregar(cantidad);
        if (retorno < 0){//regresó -1, osea error.
            return false; //no pude agregar
        }
        //si se llega a este punto es por que salio bien
        return true;
    }

    public Double calcularTotal(){
        double subtotal = 0.0;

        //recorre cada uno de los articulos y sus cantidades para calcular el total
        for(int cadaArticulo = 0; cadaArticulo < articulos.cantidad(); cadaArticulo++){
            Articulo articuloTemp = (Articulo)articulos.obtener(cadaArticulo);
            int cantidad = (int) cantidadArt.obtener(cadaArticulo);
            subtotal = subtotal + cantidad * articuloTemp.getPrecio();

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
        for(int indiceArt = 0; indiceArt < articulos.cantidad(); indiceArt++){
            //sacar el articulo de dentro del arreglo
            Articulo artTemp= (Articulo)articulos.obtener(indiceArt);
            int cantTemp = (int)cantidadArt.obtener(indiceArt);
            //imprimir los datos de un solo renglon o fila por iteracion
            DatosSalida.consola((indiceArt + 1) + "" + "\t\t\t");
            DatosSalida.consola(artTemp.getDescripcion() + "\t\t\t");
            DatosSalida.consola(artTemp.getPrecio() + "\t\t\t");
            DatosSalida.consola(cantTemp + "" +  "\t\t\t");
            DatosSalida.consola((artTemp.getPrecio() * cantTemp) + "\n");
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

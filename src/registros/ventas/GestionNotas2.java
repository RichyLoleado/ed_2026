package registros.ventas;

import edlineal.DatosListaD;
import edlineal.DatosListaE;

//esta clase administra las ventas de varias notas
public class GestionNotas2 {
    private String nombreNegocio;
    private DatosListaD notasVentas;
    private DatosListaD vendedores;

    public GestionNotas2(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
        notasVentas = new DatosListaD();
        vendedores = new DatosListaD();
    }

    //se necesitan los datos para generar al vendedor
    public boolean agregarVendedor(String nombre, String curp){
        //verficar que se dé de alta un vendedor siempre y cuandon no exista
        //primero se se busca que no exista, si no existe lo doy de alta
        Vendedor datoVendedor = (Vendedor)vendedores.buscar(curp);
        if(datoVendedor != null){ //si existe no se puede arreglar
            return false;
        }else{ //no existe, se puede
            //necesito primero sacar el numero de vendedor
            int noVendedorNuevo = vendedores.cantidad()+1;
            Vendedor vendedorNuevo = new Vendedor(noVendedorNuevo, nombre, curp);
            vendedores.agregar(vendedorNuevo);
            return true;
        }
    }

//    public int agregarNota(Cliente cliente, String fecha, int cantArticulos){
//        //para agregar una nota necesito primero su folio
//        //el cual se genera automatico de los ya existentes + 1
//        NotaVenta2 notaVentaTemp = (NotaVenta2) notasVentas.obtenerPrimero(notasVentas.cantidad());
//        //cheaca si no se pudo extraer una nota
//        int folioNuevo = 0;
//        if(notaVentaTemp != null) { //si hay notas, por lo menos una
//            folioNuevo = notaVentaTemp.getFolio() + 1;
//        }else{ //es la primera
//            folioNuevo = 1;
//        }
//        //falta el vendedor, sacamos un vendedor de vendedores
//        Vendedor vendedorDisponible = (Vendedor)vendedores.obtener();
//        //ya tengo el folio de una nota, creamos la instancia de una nota
//        NotaVenta notaNueva = new NotaVenta(folioNuevo, vendedorDisponible, cliente, fecha, cantArticulos);
//
//        //agregar la nota al arreglo de notas
//        int retorno = notasVentas.agregar(notaNueva);
//        if (retorno >= 0){ //si se pudo agregar
//            return folioNuevo;
//        }else{ // no se pudo agregar, error
//            return -1;
//        }
//    }

    public boolean agregarArticulo(int folio, Articulo art, int cantidad){
        //primero buscamos el foliio en el listado de notas
        //para descubrir la nota al la que se le agregará ese articulo
        //articulo, y la extraemos de esa nota.
        NotaVenta2 datoNota = (NotaVenta2) notasVentas.buscar(folio);

        if(datoNota == null) {
            return false;
        }else { // si existe, hacemos todo
            datoNota.agregarArticulo(art, cantidad);
            return true;
        }
    }

    public void imprimirNota(int folio){
        //primero se busca la nota con el folio indicado
        NotaVenta2 datoNota = (NotaVenta2)notasVentas.buscar(folio);

        if(datoNota != null){ //si existe y se imprime
            datoNota.imprimirNota();
        }
        //notaTemp.imprimirNota();
    }

    public String getNombre(){
        return nombreNegocio;
    }

}

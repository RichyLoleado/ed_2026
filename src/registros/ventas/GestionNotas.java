package registros.ventas;

import edlineal.DatosListaE;

//esta clase administra las ventas de varias notas
public class GestionNotas {
    private String nombreNegocio;
    private DatosListaE notasVentas;
    private DatosListaE vendedores;

    public GestionNotas(String nombreNegocio, int cantNotas, int cantVendedores) {
        this.nombreNegocio = nombreNegocio;
        notasVentas = new DatosListaE(cantNotas);
        vendedores = new DatosListaE(cantVendedores);
    }

    //se necesitan los datos para generar al vendedor
    public boolean agregarVendedor(String nombre, String curp){
        //verficar que se dé de alta un vendedor siempre y cuandon no exista
        //primero se se busca que no exista, si no existe lo doy de alta
        int  indiceVendedor = (int)vendedores.buscar(curp);
        if(indiceVendedor >= 0){ //si existe no se puede arreglar
            return false;
        }else{ //no existe, se puede
            //necesito primero sacar el numero de vendedor
            int noVendedorNuevo = vendedores.cantidad()+1;
            Vendedor vendedorNuevo = new Vendedor(noVendedorNuevo, nombre, curp);
            int retorno = vendedores.agregar(vendedorNuevo);

            if(retorno >= 0){ // si se pudo agregar el vendedor
                return true;
            }else{ //no se pudo agregar el vendedor
                return false;
            }
        }
    }

    public int agregarNota(Cliente cliente, String fecha, int cantArticulos){
        //para agregar una nota necesito primero su folio
        //el cual se genera automatico de los ya existentes + 1
        NotaVenta notaVentaTemp = (NotaVenta) notasVentas.obtener(notasVentas.cantidad()-1);
        //cheaca si no se pudo extraer una nota
        int folioNuevo = 0;
        if(notaVentaTemp != null) { //si hay notas, por lo menos una
            folioNuevo = notaVentaTemp.getFolio() + 1;
        }else{ //es la primera
            folioNuevo = 1;
        }
        //falta el vendedor, sacamos un vendedor de vendedores
        Vendedor vendedorDisponible = (Vendedor)vendedores.obtener(0);
        //ya tengo el folio de una nota, creamos la instancia de una nota
        NotaVenta notaNueva = new NotaVenta(folioNuevo, vendedorDisponible, cliente, fecha, cantArticulos);

        //agregar la nota al arreglo de notas
        int retorno = notasVentas.agregar(notaNueva);
        if (retorno >= 0){ //si se pudo agregar
            return folioNuevo;
        }else{ // no se pudo agregar, error
            return -1;
        }
    }

    public boolean agregarArticulo(int folio, Articulo art, int cantidad){
        //primero buscamos el foliio en el listado de notas
        //para descubrir la nota al la que se le agregará ese articulo
        //articulo, y la extraemos de esa nota.
        int indiceNota = (int)notasVentas.buscar(folio);

        if(indiceNota < 0) {
            return false;
        }else { // si existe, hacemos todo
            NotaVenta notaTemp = (NotaVenta) notasVentas.obtener(indiceNota);

            boolean retorno = notaTemp.agregarArticulo(art, cantidad);
            if (retorno == false) { //no se pudo agregar el articulo
                return false;
            } else { // se pudo agregar el articulo
                return true;
            }
        }
    }

    public void imprimirNota(int folio){
        //primero se busca la nota con el folio indicado
        int indiceNota = (int)notasVentas.buscar(folio);

        if(indiceNota >= 0){ //si existe y se imprime
            NotaVenta notaTemp = (NotaVenta)notasVentas.obtener(indiceNota);
            notaTemp.imprimirNota();
        }
        //notaTemp.imprimirNota();
    }

    public String getNombre(){
        return nombreNegocio;
    }

}

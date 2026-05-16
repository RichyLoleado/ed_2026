package registros.cosechas2;

import edlineal.DatosListaE;
import edlineal.DatosListaEstaticaN;
import ednolineal.ListaE3D;
import entradasalida.DatosSalida;

public class ControlCosechas {
    protected DatosListaE campesinos;
    protected DatosListaE productos;
    protected DatosListaE anios;
    protected ListaE3D produccionesCosechas;

    public ControlCosechas(int cantCampesinos, int cantProductos, int cantAnios){
        campesinos = new DatosListaE(cantCampesinos);
        productos = new DatosListaE(cantProductos);
        anios = new DatosListaE(cantAnios);
        produccionesCosechas = new ListaE3D(cantCampesinos, cantProductos, cantAnios, 0.0);
    }

    public boolean agregarCampesino(String nombre, String curp, int edad){
        //validar que no exista un campesino con ese curp en el arreglo
        int indiceBusqueda = (int)campesinos.buscar(curp);
        if(indiceBusqueda < 0){ //no existe
            //crear el objeto campesino
            Campesino nuevoCampesino = new Campesino(nombre, curp, edad);
            //agregarlo al arreglo campesinos
            int resultado = campesinos.agregar(nuevoCampesino);
            //validar que no hubo error
            if(resultado >= 0){ //exito en agregar
                return true;
            }else{ //error en agregar
                return false;
            }
        }else{ //si existe
            return false;
        }
    }

    public boolean agregarProducto(String codProd, String nombre, double precioBase, String tipo){
        //validar que no exista un Producto con ese codigo en el arreglo
        int indiceBusqueda = (int)productos.buscar(codProd);
        if(indiceBusqueda < 0){ //no existe
            //crear el objeto Producto
            Producto nuevoProducto = new Producto(codProd, nombre, precioBase, tipo);
            //agregarlo al arreglo productos
            int resultado = productos.agregar(nuevoProducto);
            //validar que no hubo error
            if(resultado >= 0){ //exito en agregar
                return true;
            }else{ //error en agregar
                return false;
            }
        }else{ //si existe
            return false;
        }
    }

    public boolean agregarAnio(int nummAnios){
        //validamos que el anio sea mayor a cero
        int indiceBusqueda = (int)anios.buscar(nummAnios);
        if(nummAnios > 0){ //anio valido
            //agregamos al arreglo anios
            int resultado = anios.agregar(nummAnios); // regresa el indice
            if (resultado >= 0){ //validar que se agrego correctamente
                return true; // se agrego correctamente
            }else{
                return false; // hubo un error
            }
        }else{
            return false;
        }

    }

    public boolean agregarCosecha(String curp, String codProd, int numAnio, double cantidadTons){
        // ver si existen esos datos y obtener sus indices
        //buscamos en cada arreglo
        int indiceCampesino = (int)campesinos.buscar(curp);
        int indiceProducto = (int)productos.buscar(codProd);
        int indiceAnio = (int)anios.buscar(numAnio);

        if (indiceCampesino >= 0 && indiceProducto >= 0 && indiceAnio >= 0){
            // si existen, agregar la produccion al arreglo 3D
            return produccionesCosechas.modificar(indiceCampesino, indiceProducto, indiceAnio, cantidadTons);
        }else{// por lo menos uno no es valido
            return false;
        }
    }



    public void imprimirDatos(){
        //imprimo los arreglos paralelos
        //como ejemplo se imprimiré los objetos campesinos
        //los otros dos arreglos solo invoco a el de impriir string()
        DatosSalida.consola("Campesinos: \n");
        //este si voy a recorrer todos los objetos de la lista
        for(int cadaCamp = 0; cadaCamp < campesinos.cantidad(); cadaCamp++){
            campesinos.obtener(cadaCamp);
            Campesino objetoCamp = (Campesino)campesinos.obtener(cadaCamp);
            DatosSalida.consola("Nombre: " + objetoCamp.getNombre()+ " ");
            DatosSalida.consola("Edad: " + objetoCamp.getEdad()+ " ");
            DatosSalida.consola("CURP: " + objetoCamp.getCurp() + " ");
            DatosSalida.consola("\n");
        }

        DatosSalida.consola("Productos: \n");
        productos.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("Anios: \n");
        anios.imprimir();
        DatosSalida.consola("\n");
        //imprimo el cubo

        DatosSalida.consola("Produccion de Cosechas: \n");
        produccionesCosechas.imprimirPorColumnas();
    }

    //me interesa resolver preguntas como:
    //cuanto ha producido juan de frijol durante 2010, 2020, 2025
    //cuanto se ha producido de maiz en 2010

    public Double produccionCampProd(String curp, String codProd, DatosListaEstaticaN aniosPedidos){
        //definir la variable que acumula todas las toneladas
        Double tonsAcumuladas = 0.0;
        //Extraer de cada anio del producto
        //de ese campesino

        for(int cadaAnio = 0; cadaAnio < aniosPedidos.cantidad(); cadaAnio++) {
            int anioTemp = (int) aniosPedidos.obtener(cadaAnio);
            //ahora con ese anio, ese producto y ese campesino
            //extrae del cubo de cosechas y la cantidad de toneladas
            Double tonsCelda = obtenerCosechaCelda(curp, codProd, anioTemp);
            //con ese valor de una sola celda se lo sumo a los demas anios
            tonsAcumuladas = tonsAcumuladas + tonsCelda;
        }
        //regresar la cantidad de toneladas total
        return tonsAcumuladas;
    }

    private Double obtenerCosechaCelda(String curp, String codProd, int anio){
        IndicesCosecha indices = obtenerIndicesCeldaCosecha(curp, codProd, anio);
        Double tonsCelda = (Double)produccionesCosechas.obtener(indices.getIndiceCamp(), indices.getIndiceProd(), indices.getIndiceAnio());
        return tonsCelda;
    }

    private IndicesCosecha obtenerIndicesCeldaCosecha(String curp, String codProd, int anio){
        //buscar en los arreglos paralelos y de ahí sacar los indices
        //de los objetos campesinos, productos y anios
        int indiceCampesino = (int)campesinos.buscar(curp);
        int indiceProducto = (int)productos.buscar(codProd);
        int indiceAnio = (int)anios.buscar(anio);
        if(indiceCampesino < 0 || indiceProducto < 0 || indiceAnio < 0){
            //son invalidoos
            return null;
        }else{ //son validos
            IndicesCosecha indices = new IndicesCosecha();
            indices.setIndiceCamp(indiceCampesino);
            indices.setIndiceProd(indiceProducto);
            indices.setIndiceAnio(indiceAnio);
            return indices;
        }

    }

}

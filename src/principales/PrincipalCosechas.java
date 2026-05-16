package principales;

import edlineal.DatosListaEstaticaN;
import entradasalida.DatosSalida;
import registros.cosechas2.ControlCosechas;

public class PrincipalCosechas {
    public static void main(String[] args){
        ControlCosechas prodCosechas = new ControlCosechas(4, 4, 3);


        //agrear campesino
        prodCosechas.agregarCampesino("Juan", "CURP1", 28);
        prodCosechas.agregarCampesino("Pedro", "CURP2", 38);
        prodCosechas.agregarCampesino("lOLA", "CURP3", 45);
        prodCosechas.agregarCampesino("Jose", "CURP4", 50);

        //agregar productos
        prodCosechas.agregarProducto("p1", "Maiz", 6, "TIPO1" );
        prodCosechas.agregarProducto("p2", "Frijol", 5, "TIPO2" );
        prodCosechas.agregarProducto("p3", "Chile", 30, "TIPO3" );
        prodCosechas.agregarProducto("p4", "Tomate", 3, "TIPO4" );
        //agregar anios
        prodCosechas.agregarAnio(2010);
        prodCosechas.agregarAnio(2020);
        prodCosechas.agregarAnio(2015);

        //agregar cosechas
        prodCosechas.agregarCosecha("CURP1", "p1", 2010, 45);
        prodCosechas.agregarCosecha("CURP1", "p4", 2010, 12);
        prodCosechas.agregarCosecha("CURP3", "p3", 2010, 50);
        prodCosechas.agregarCosecha("CURP4", "p4", 2010, 70);
        prodCosechas.agregarCosecha("CURP1", "p4", 2020, 19);
        prodCosechas.agregarCosecha("CURP3", "p4", 2015, 35);


        //imprimir arreglos paralelos y 3d
        prodCosechas.imprimirDatos();

        DatosSalida.consola("\n");

        DatosSalida.consola("Produccion de Juan de Maiz en 2010, 2020, 2015: \n");
        DatosListaEstaticaN anios = new DatosListaEstaticaN(3);
        anios.agregar(2010);
        anios.agregar(2020);
        anios.agregar(2015);
        Double producCamp1 = prodCosechas.produccionCampProd("CURP1", "p1", anios);
        DatosSalida.consola(producCamp1+" tons\n");

    }
}

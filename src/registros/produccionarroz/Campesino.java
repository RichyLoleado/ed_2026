package registros.produccionarroz;

import edlineal.DatosListaE;

public class Campesino {

    int idCampesino;
    String nombre;
    DatosListaE producciones;


    static final int NUM_ANIOS = 5; //5 anios
    static final int NUM_MESES = 12; //12 meses

    public Campesino(int idCampesino, String nombre) {
        this.idCampesino = idCampesino;
        this.nombre = nombre;

        producciones = new DatosListaE(NUM_ANIOS * NUM_MESES); //12 * 5 = 60 elementos en la lista
    }

    public Campesino(int idCampesino) {
        this(idCampesino, "");
    }

    int indiceProduccion(int anio, int mes) {
        int indice = (anio * NUM_MESES) + (mes - 1);
        return indice;
    }

    public double getProduccion(int anio, int mes) {
        int indice = indiceProduccion(anio, mes);
        Object valor = producciones.obtener(indice);

        if (valor == null) {
            return 0.0;
        }

        double resultado = ((Double) valor).doubleValue();
        return resultado;
    }

    public boolean setProduccion(int anio, int mes, double valor) {
        int indice = indiceProduccion(anio, mes);
        boolean produccion = producciones.modificar(indice, valor);
        return produccion;
    }

    public double produccionAnual(int anio) {
        double contador = 0.0;
        int mes = 1;

        while (mes <= NUM_MESES) {
            double produccionMes = getProduccion(anio, mes);
            contador = contador + produccionMes;
            mes = mes + 1;
        }

        return contador;
    }
}


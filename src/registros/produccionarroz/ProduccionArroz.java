package registros.produccionarroz;

import edlineal.DatosListaE;

public class ProduccionArroz {

    DatosListaE listaCampesinos;

    static final int NUM_ANIOS = 5;
    static final int NUM_MESES = 12;

    public ProduccionArroz(DatosListaE listaCampesinos) {
        this.listaCampesinos = listaCampesinos;
    }

    Campesino buscarCampesino(int idCampesino) {
        int i = 0;
        while (i < listaCampesinos.cantidad()) {
            Campesino c = (Campesino) listaCampesinos.obtener(i);
            if (c.idCampesino == idCampesino) {
                return c;
            }
            i = i + 1;
        }
        return null;
    }

    public double promedioAnualCampesino(int idCampesino, int anio) {
        Campesino campesino = buscarCampesino(idCampesino);
        if (campesino == null) {
            return -1.0;
        }

        double contador = 0.0;
        int mes = 1;

        while (mes <= NUM_MESES) {
            double produccionMes = campesino.getProduccion(anio, mes);
            contador = contador + produccionMes;
            mes = mes + 1;
        }

        double promedio = contador / NUM_MESES;
        return promedio;
    }

    public int mesMenorProduccion(int idCampesino, int anio) {
        Campesino campesino = buscarCampesino(idCampesino);
        if (campesino == null) {
            return -1;
        }

        int mes = 1;
        double minimo = campesino.getProduccion(anio, 1);
        int mesMinimo = 1;

        mes = 2;
        while (mes <= NUM_MESES) {
            double produccionMes = campesino.getProduccion(anio, mes);
            if (produccionMes < minimo) {
                minimo = produccionMes;
                mesMinimo = mes;
            }
            mes = mes + 1;
        }

        return mesMinimo;
    }

    public DatosListaE ultimoMesPorAnio(int idCampesino) {
        Campesino campesino = buscarCampesino(idCampesino);
        if (campesino == null) {
            return null;
        }

        DatosListaE listaResultados = new DatosListaE(NUM_ANIOS);

        int anio = 0;
        while (anio < NUM_ANIOS) {
            double produccionMes = campesino.getProduccion(anio, 12);
            listaResultados.agregar(produccionMes);
            anio = anio + 1;
        }

        return listaResultados;
    }

    public DatosListaE segundoTrimestrePorAnio(int idCampesino) {
        Campesino campesino = buscarCampesino(idCampesino);
        if (campesino == null) {
            return null;
        }

        DatosListaE listaResultados = new DatosListaE(NUM_ANIOS);

        int anio = 0;
        while (anio < NUM_ANIOS) {
            double sumaTrimestre = 0.0;
            int mes = 4;
            while (mes <= 6) {
                double produccionMes = campesino.getProduccion(anio, mes);
                sumaTrimestre = sumaTrimestre + produccionMes;
                mes = mes + 1;
            }
            listaResultados.agregar(sumaTrimestre);
            anio = anio + 1;
        }

        return listaResultados;
    }

    public String estacionMayorProduccion() {
        double primavera = 0.0;
        double verano = 0.0;
        double otonio = 0.0;
        double invierno = 0.0;

        int anio = 0;
        while (anio < NUM_ANIOS) {

            int mes = 1;
            while (mes <= NUM_MESES) {

                int indice = 0;
                while (indice < listaCampesinos.cantidad()) {
                    Campesino campesinoActual = (Campesino) listaCampesinos.obtener(indice);
                    double produccionMes = campesinoActual.getProduccion(anio, mes);

                    if (mes == 3 || mes == 4 || mes == 5) {
                        primavera = primavera + produccionMes;
                    } else if (mes == 6 || mes == 7 || mes == 8) {
                        verano = verano + produccionMes;
                    } else if (mes == 9 || mes == 10 || mes == 11) {
                        otonio = otonio + produccionMes;
                    } else if (mes == 12 || mes == 1 || mes == 2) {
                        invierno = invierno + produccionMes;
                    }

                    indice = indice + 1;
                }

                mes = mes + 1;
            }

            anio = anio + 1;
        }

        String epocaMayor = "Primavera";
        double maximo = primavera;

        if (verano > maximo) {
            maximo = verano;
            epocaMayor = "Verano";
        }
        if (otonio > maximo) {
            maximo = otonio;
            epocaMayor = "Otoño";
        }
        if (invierno > maximo) {
            maximo = invierno;
            epocaMayor = "Invierno";
        }

        return epocaMayor;
    }
}


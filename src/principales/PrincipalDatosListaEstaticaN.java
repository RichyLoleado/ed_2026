package principales;

import edlineal.DatosListaEstaticaN;
import entradasalida.DatosSalida;

public class PrincipalDatosListaEstaticaN {
    public static void main (String argumentos[]){
        DatosListaEstaticaN lista = new DatosListaEstaticaN(5);

        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);
        lista.agregar(50);

        lista.imprimir();
        DatosSalida.consola("\n");

        //porEscalar
        DatosSalida.consola("multiplicacion por el escalcar (2): ");
        lista.porEscalar(2);

        lista.imprimir();
        DatosSalida.consola("\n");

        //sumarEscalar
        DatosSalida.consola("suma del escalar (10): ");
        lista.sumarEscalar(10);

        lista.imprimir();
        DatosSalida.consola("\n");

        //aplicarPotencia
        DatosSalida.consola("aplicando potencia (2): ");
        lista.aplicarPotencia(2);

        lista.imprimir();
        DatosSalida.consola("\n");

        //aplicarPotencia lista
        DatosSalida.consola("aplicando la potencia del la lista: ");
        DatosListaEstaticaN listaEsc = new DatosListaEstaticaN(5);
        listaEsc.agregar(2);
        listaEsc.agregar(3);
        listaEsc.agregar(4);
        listaEsc.agregar(5);
        listaEsc.agregar(6);
        listaEsc.imprimir();
        lista.aplicarPotencia(listaEsc);
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");
        lista.imprimir();


        DatosListaEstaticaN listaActual = new DatosListaEstaticaN(5);
        listaActual.agregar(10);
        listaActual.agregar(20);
        listaActual.agregar(30);
        listaActual.agregar(40);
        listaActual.agregar(50);
        listaActual.imprimir();
        DatosSalida.consola("\n");
        DatosSalida.consola("\n");

        DatosListaEstaticaN lista2 = new DatosListaEstaticaN(5);
        lista2.agregar(1);
        lista2.agregar(3);
        lista2.agregar(5);
        lista2.agregar(7);
        lista2.agregar(9);
        DatosSalida.consola("lista 2: ");
        lista2.imprimir();
        DatosSalida.consola("\n");

        //sumar
        DatosSalida.consola("sumando la lista 2: ");
        listaActual.sumar(lista2);
        DatosSalida.consola("\n");
        listaActual.imprimir();
        DatosSalida.consola("\n");

        //multiplicar
        DatosSalida.consola("multiplicando la lista 2: ");
        listaActual.multiplicar(lista2);
        DatosSalida.consola("\n");
        listaActual.imprimir();
        DatosSalida.consola("\n");

        //productoEscalar
        DatosSalida.consola("producto escalar: ");
        listaActual.productoEscalar(lista2);
        DatosSalida.consola("\n");
        listaActual.imprimir();
        DatosSalida.consola("\n");

        //norma
        DatosSalida.consola("norma: ");
        listaActual.norma();
        DatosSalida.consola("\n");
        listaActual.imprimir();
        DatosSalida.consola("\n");

        //sumarEscalar
        DatosSalida.consola("suma del escalar (10): ");
        listaActual.sumarEscalar(10);
        DatosSalida.consola("\n");
        listaActual.imprimir();
        DatosSalida.consola("\n");

        //sumarIndices
        DatosSalida.consola("Sumando los indices de la lista: ");
        lista2.imprimir();
        listaActual.sumarIndices(lista2);
        DatosSalida.consola("\n");
        listaActual.imprimir();
        DatosSalida.consola("\n");

        //esOrtogonal
        DatosSalida.consola("es ortogonal: ");
        listaActual.esOrtogonal(lista2);
        DatosSalida.consola("es ortogonal?:" + listaActual.esOrtogonal(lista2));
        listaActual.imprimir();
        DatosSalida.consola("\n");




    }
}

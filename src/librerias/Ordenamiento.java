package librerias;
import edlineal.DatosListaEstaticaN;
public class Ordenamiento {

    public static boolean pigeonholeSort(DatosListaEstaticaN lista){
        //validar lista vacia
        if(lista == null || lista.vacia() == true){
            return false;
        }
        //buscar minimo y maximo
        double min = Double.parseDouble(lista.obtener(0).toString()); //obtener el primer elemento de la lista y usarlo como minimo
        double max = Double.parseDouble(lista.obtener(0).toString()); //obtener el primer elemento de la lista y usarlo como maximo
        for(int posicion = 1; posicion < lista.cantidad(); posicion++){ //recorrer la lista para encontrar el minimo y maximo real
            double valorActual = Double.parseDouble(lista.obtener(posicion).toString());
            if(valorActual < min){  //comparacion con el actual con el posible minimo
                min = valorActual;
            }
            if(valorActual > max){ //comparacion con el actual con el posible maximo
                max = valorActual;
            }
        }
        //calcular rango
        int rango = (int)(max - min + 1);
        //crear casilleros (los holes)
        DatosListaEstaticaN holes = new DatosListaEstaticaN(rango);
        //llenar casilleros con ceros
        for(int posicion = 0; posicion < rango; posicion++){
            holes.agregar(0);
        }
        //guardar con cuanta frecuencia se encuentra cada valor
        for(int posicion = 0; posicion < lista.cantidad(); posicion++){
            double valor = Double.parseDouble(lista.obtener(posicion).toString());
            int indice = (int)(valor - min);
            int frecuenciaActual = Integer.parseInt(holes.obtener(indice).toString());
            holes.modificar(indice, frecuenciaActual + 1);
        }
        //reconstruir lista ordenada
        int posicionLista = 0;
        for(int indice = 0; indice < rango; indice++){
            int frecuencia = Integer.parseInt(holes.obtener(indice).toString());
            while(frecuencia > 0){
                lista.modificar(posicionLista, indice + min);
                posicionLista++;
                frecuencia--;
            }
        }
        return true;
    }
}


package librerias;

public class AdmObjetos {

    //crearemos un comparador de objetos básico
    //nos dirá si un objeto es =, >, < que otro
    //si son iguales que mme regrese 0
    //si objeto1 es > que objeto2 regrese positivo
    //si objeto2 es < que objeto1 regrese negativo
    public static int comparar(Object objeto1, Object objeto2){
        //primero revisamos si es numero u otro tipo de objeto
        //checamos si es un objeto que hereda de Number, entonces es numero
        if(objeto1 instanceof Number && objeto2 instanceof Number){ //es un numero
            //compararlos como numeros
            //primero convertirlos en numeros, si es long, si es short, int, float, double, todos los transformo a double
            double numero1 = Double.parseDouble(objeto1.toString());
            double numero2 = Double.parseDouble(objeto2.toString());
            if(numero1 > numero2){
                return 1;
            }else if(numero1 < numero2){
                return -1;
            }else{ //son iguales
                return 0;
            }
        }else{//son cadenas aun que no son cadenas
            //compararlos como cadenas usando Ascii\
            //el compareTo regresa un numero positivo si obj1 > obj2
            //si obj1 < obj2 regresa un numero negativo
            //si son iguales regresa 0
            return  objeto1.toString().compareToIgnoreCase(objeto2.toString());
        }
    }
}

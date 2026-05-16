package librerias.matematicas;

public class Recursion {


    // maximo comun divisor
    public int MCD(int a, int b){
        if (a == b){  // caso base (a == b)
            return a;
            //casos recursivos
        }else if (a > b){  // a > b
            return MCD(a - b, b);
        }else{ // b > a
            return MCD(a, b - a);
        }
    }

    //Comprobar un numero binario
    public boolean esBinario(int n){
        if(n == 0 || n == 1){ //caso base
            return true; // es binario
        }
        long ultimoN = n % 10 ; // si tiene resduo de 2 o mas es por que no es binario
        if(ultimoN > 1){
            return false; // no es binario
        }
        //caso recursivo
        return esBinario(n / 10); // pasar el el numero sin el ultimo digito
    }

    public String convertirBinario(int n){
        if (n <= 1){ // caso base
            return n + ""; // si es 0 o 1
        }else {
            return convertirBinario(n / 2) + (n % 2); // si es mayor que 1
        }
    }

}

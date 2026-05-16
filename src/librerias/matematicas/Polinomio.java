package librerias.matematicas;

import ednolineal.DatosListaDClave;
import ednolineal.auxiliares.NodoClaveValor;

public class Polinomio{
    protected int coeficiente;
    protected int exponente;
    protected DatosListaDClave lista;

    public Polinomio(){
        this.lista = new DatosListaDClave();
    }

    public Polinomio(int coeficiente, int exponente){
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public void agregarM(int posicion, int coeficiente, int exponente){
        Polinomio nuevo = new Polinomio(coeficiente, exponente);
        lista.agregar(posicion, nuevo);
    }



    //evaluar
    public double evaluar(NodoClaveValor nodo, int x){
        if(nodo == null){
            return 0;
        }

        Polinomio monomio = (Polinomio) nodo.getValor();
        double valorActual = monomio.coeficiente * Math.pow(x, monomio.exponente);

        return valorActual + evaluar(nodo.getPosSiguiente(), x);
    }

    public double evaluar(int x){
        return evaluar(lista.posInicial , x);
    }

    //buscar exponente
    public boolean buscar(NodoClaveValor nodo, int exponenteB){
        if(nodo == null){
            return false;
        }
        Polinomio monomio = (Polinomio) nodo.getValor();
        // si lo encuentra
        if(monomio.exponente == exponenteB){
            return true;
        }

        return buscar(nodo.getPosSiguiente(), exponenteB);
    }

    public boolean buscar(int exponenteBuscado){
        return buscar(lista.posInicial , exponenteBuscado);
    }

    //convertir a Binario
    public String convertirBinario(NodoClaveValor nodo, int grado){
        if(grado < 0){
            return "";
        }

        //si existe el exponente
        if(nodo != null){
            Polinomio monomio = (Polinomio) nodo.getValor();

            if(monomio.exponente == grado){
                return "1" + convertirBinario(nodo.getPosSiguiente(), grado - 1);
            }
        }

        // si no existe el exponente
        return "0" + convertirBinario(nodo.getPosSiguiente(), grado - 1);

    }

    //metodos que solo necesitan de un parametro para poder llamarlos en el main y que el otro se ocupe del trabajo  con su otro parametro necesario
    public String convertirBinario(int mayorGrado){
        return  convertirBinario(lista.posInicial , mayorGrado);
    }



}

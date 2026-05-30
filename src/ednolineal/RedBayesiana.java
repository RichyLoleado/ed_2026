package ednolineal;

import edlineal.DatosListaD;
import ednolineal.auxiliares.Probabilidad;

public class RedBayesiana {
    private GrafoM grafo;
    private DatosListaD probabilidades;

    public RedBayesiana(){
        probabilidades = new DatosListaD();
        crearRed();
        agregarProbabilidades();
    }

    public void crearRed(){
        grafo = new GrafoM(7,0.0);
        //vertices
        grafo.agregarVertices("Estudio");
        grafo.agregarVertices("Asistencia");
        grafo.agregarVertices("Tareas");
        grafo.agregarVertices("Participacion");
        grafo.agregarVertices("Aprendizaje");
        grafo.agregarVertices("Examen");
        grafo.agregarVertices("Aprobacion");
        //aristas
        grafo.agregarArista("Estudio" , "Aprendizaje");
        grafo.agregarArista("Asistencia" , "Aprendizaje");
        grafo.agregarArista("Tareas" , "Aprendizaje");
        grafo.agregarArista("Aprendizaje" , "Examen");
        grafo.agregarArista("Examen" , "Aprobacion");
    }

    public void mostrarRed(){
        grafo.listarVertices();
        grafo.mostrar();
    }
    private void agregarProbabilidades() {
        probabilidades.agregar(new Probabilidad("Estudio",0.70));
        probabilidades.agregar(new Probabilidad("Asistencia",0.80));
        probabilidades.agregar(new Probabilidad("Tareas",0.75));
        probabilidades.agregar(new Probabilidad("Participacion",0.60));
        probabilidades.agregar(new Probabilidad("Aprendizaje",0.85));
        probabilidades.agregar(new Probabilidad("Examen",0.80));
        probabilidades.agregar(new Probabilidad("Aprobacion",0.90));
    }

    public double consultarProbabilidadSimple(String variable){
        probabilidades.inicializarIterador();
        while(!probabilidades.esIteradorNulo()){
            Probabilidad probabilidadActual = (Probabilidad) probabilidades.obtenerDatoIterador();
            if(probabilidadActual.getVariable().equalsIgnoreCase(variable)){
                return probabilidadActual.getValor();
            }
            probabilidades.avanzarIterador();
        }
        return -1;
    }

    public double calcularProbabilidadConjunta(DatosListaD eventos){
        double resultado = 1;
        eventos.inicializarIterador();
        while(!eventos.esIteradorNulo()){
            String variable = eventos.obtenerDatoIterador().toString();
            double probabilidad = consultarProbabilidadSimple(variable);
            if(probabilidad < 0){
                return -1;
            }
            resultado = resultado * probabilidad;
            eventos.avanzarIterador();
        }
        return resultado;
    }



}

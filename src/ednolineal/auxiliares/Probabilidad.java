package ednolineal.auxiliares;

public class Probabilidad {
    private String variable;
    private String condicion;
    private double valor;

    public Probabilidad(String variable, double valor){
        this.variable = variable;
        this.valor = valor;
    }

    public Probabilidad(String variable, String condicion, double valor){
        this.variable = variable;
        this.condicion = condicion;
        this.valor = valor;
    }

    public String getVariable() {
        return variable;
    }
    public double getValor() {
        return valor;
    }
    public String getCondicion() {
        return condicion;
    }
}

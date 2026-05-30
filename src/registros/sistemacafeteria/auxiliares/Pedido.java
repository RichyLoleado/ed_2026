package registros.sistemacafeteria.auxiliares;

public class Pedido {
    private String nombrecliente;
    private double total;

    public Pedido(String nombreCliente, double total){
        this.nombrecliente = nombreCliente;
        this.total = total;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public double getTotal() {
        return total;
    }

}

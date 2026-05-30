package principales;

import entradasalida.DatosSalida;
import registros.sistemacafeteria.Cafeteria;
import registros.sistemacafeteria.auxiliares.Pedido;

public class PrincipalCafeteria {
    public static void main(String[]args){
        Cafeteria cafeteria = new Cafeteria();

        cafeteria.agregar(new Pedido("Juan", 100));
        cafeteria.agregar(new Pedido("Maria", 200));
        cafeteria.agregar(new Pedido("Carlos", 300));
        cafeteria.agregar(new Pedido("Pedro", 90));

        DatosSalida.consola("\n");
        DatosSalida.consola("Cantidad de pedidos mayores a 150: ");
        DatosSalida.consola(cafeteria.contarMayoresA150() + "\n");

        DatosSalida.consola("\n");
        DatosSalida.consola("Clientes impresos inverso por nombre:\n ");
        cafeteria.imprimirInverso();

    }
}

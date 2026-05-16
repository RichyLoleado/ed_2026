package registros.colas;

import edlineal.ColaE;

public class ColaPrioridad extends ColaE{

    public ColaPrioridad(int tamanio) {
        super(tamanio);
    }

    @Override
    public boolean meter(Object valor) {
        if (lleno()) {
            return false;
        }
        Proceso nuevo = (Proceso) valor;
        ColaE auxiliar = new ColaE(capacidad);
        boolean insertado = false;
        while (!vacio()) {
            Proceso actual = (Proceso) sacar();
            if (!insertado && nuevo.getPrioridad() > actual.getPrioridad()) {
                auxiliar.meter(nuevo);
                insertado = true;
            }
            auxiliar.meter(actual);
        }
        if (!insertado) {
            auxiliar.meter(nuevo);
        }
        while (!auxiliar.vacio()) {
            super.meter(auxiliar.sacar());
        }
        return true;
    }
}

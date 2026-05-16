package librerias.matematicas;

import ednolineal.DatosListaDClave;

public class DistribucionNormal {
    protected DatosListaDClave lista;
    protected double x;
    protected double fx;
    protected double z;
    protected double fz;
    protected final double MU = 2.066433025;
    protected final double SIGMA = 1.513452918;

    public DistribucionNormal(){
        lista = new DatosListaDClave();
    }

    //constructor de los parametros
    public DistribucionNormal(double x){
        this.x = x;
        fx = 0;
        z = 0;
        fz = 0;
    }

    public void leerArchivo(String ruta){}

}

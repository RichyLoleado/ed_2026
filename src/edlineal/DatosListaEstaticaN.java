package edlineal;

public class DatosListaEstaticaN extends DatosListaE{
    public DatosListaEstaticaN(int tamanio) {
        super(tamanio);
    }

    //metodo para validar datos numericos
    public boolean esNumero(Object valor){
        if(valor instanceof Number){
            return true; // es numerico
        }else{
            return false; // no es numerico
        }
    }

    @Override
    public Integer agregar(Object valor){
        if(esNumero(valor) == false){ // se usa el metodo de validacion
            return -1;
        }
        return super.agregar(valor);
    }

    @Override
   public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces){
        if(esNumero(valorNuevo) == false){
            return false;
        }
        return super.modificar(valorViejo, valorNuevo, numVeces); // le mandamos el trabajo a la clase que está en
                                                                    // en DatosListaE
    }

    @Override
    public boolean modificar(int indice, Object valor){
        if(esNumero(valor) == false){
            return false;
        }
        return super.modificar(indice, valor);
    }

    public boolean porEscalar(Number escalar){
        if(vacia() == true){  //verificamos que tenga datos
            return false; // es una lista vacia
        }

        double escalarD = Double.parseDouble(escalar.toString());
        for(int posicion = 0; posicion <= posFinal; posicion++){
            double vCasilla = Double.parseDouble(datos[posicion].toString());
            double resultado = vCasilla * escalarD;
            datos[posicion] = resultado;
        }
        return true;
    }

    public boolean sumarEscalar(Object escalar){
        if(vacia() == true) {
            return false;
        }
        if(esNumero(escalar) == false){ //prohibir la accion si no es numerico
            return false;
        }
        double escalarD = Double.parseDouble(escalar.toString());
        for(int posicion = 0; posicion <= posFinal; posicion++){
            double vCasilla = Double.parseDouble(datos[posicion].toString());
            double resultado = vCasilla + escalarD; //sumar el escalar
            datos[posicion] = resultado; // guardar el resultado
        }
        return true;
    }

    public boolean aplicarPotencia(Number escalar){
        if (vacia() == true){
            return false;
        }

        double expo = Double.parseDouble(escalar.toString());

        for(int posicion = 0; posicion <= posFinal; posicion++){
            double base = Double.parseDouble(datos[posicion].toString());
            double resultado = Math.pow(base, expo); // elevar a la potencia
            datos[posicion] = resultado;
        }
        return true;
    }

    public boolean aplicarPotencia(DatosListaEstaticaN listaEscalares){
        if (this.cantidad() != listaEscalares.cantidad()){
            return false;
        }
        for(int posicion = 0; posicion <= posFinal; posicion++){
            double base = Double.parseDouble(this.datos[posicion].toString());
            double expo = Double.parseDouble(listaEscalares.datos[posicion].toString());
            double resultado = Math.pow(base, expo); // hace lo mismo que aplicarPotencia(Number escalar)
            this.datos[posicion] = resultado;
        }
        return true;
    }

    public boolean sumar(DatosListaEstaticaN lista2){
        if(capacidad != lista2.capacidad){ //comparar las capacidades de las listas
            return false;
        }
        for(int posicion = 0; posicion <= posFinal; posicion++){
            double CampList1 = Double.parseDouble(this.datos[posicion].toString()); // convertir a double
            double CampList2 = Double.parseDouble(lista2.datos[posicion].toString()); // convertir a double
            double resultado = CampList1 + CampList2; //sumar los dos valores
            this.datos[posicion] = resultado; //guardar el resultado en la lista actual
        }
        return true;
    }

    public boolean multiplicar(DatosListaEstaticaN lista2){
        if(capacidad != lista2.capacidad){
            return false;
        }
        for(int posicion = 0; posicion <= posFinal; posicion++){
            double CampList1 = Double.parseDouble(this.datos[posicion].toString());
            double CampList2 = Double.parseDouble(lista2.datos[posicion].toString());
            double resultado = CampList1 * CampList2; //hace lo mismo que sumar pero aquí multiplica
            this.datos[posicion] = resultado;
        }
        return true;
    }

    public double productoEscalar(DatosListaEstaticaN lista2) {
        if (this.vacia() == true || lista2.vacia() == true) { //validar si ninguna lista esta vacia
            return -1;
        }
        if (capacidad != lista2.cantidad()) {
            return -1;
        }

        double suma = 0;
        for (int posicion = 0; posicion <= posFinal; posicion++) {
            double vCasilla1 = Double.parseDouble(this.datos[posicion].toString());
            double vCasilla2 = Double.parseDouble(lista2.datos[posicion].toString());
            suma = suma + (vCasilla1 * vCasilla2);
        }
        return suma;
    }

    public double norma(){
        if(vacia() == true){ // validar si la lista esta vacia
            return -1;
        }

        double suma = 0;
        for(int posicion = 0; posicion <= posFinal; posicion++){
            double vCampo = Double.parseDouble(datos[posicion].toString());
            suma = suma + (vCampo * vCampo);
        }
        double resultado = Math.sqrt(suma);
        return resultado;
    }

    public boolean sumarEscalares(DatosListaEstaticaN escalares){
        return sumar(escalares);
    }

    public double sumarIndices(DatosListaEstaticaN listaIndices){
        if(this.vacia() == true || listaIndices.vacia() == true){
            return -1;
        }

        double suma = 0;
        for(int posicion = 0; posicion <= listaIndices.posFinal; posicion++){
            double indiceD = Double.parseDouble(listaIndices.datos[posicion].toString());
            int indice = (int)indiceD;

            if(indice < 0 || indice > posFinal){
                return -1;
            }

            double valor = Double.parseDouble(this.datos[indice].toString());
            suma = suma + valor;
        }
        return suma;
    }

    public boolean esOrtogonal(DatosListaEstaticaN lista2){
        if(this.vacia() == true || lista2.vacia() == true){ //validar si la lista esta vacia
            return false;
        }

        if(this.cantidad() != lista2.cantidad()){ // validar que tengan la misma cantidad
            return false;
        }

        double resultado = productoEscalar(lista2);  // guardar el resultado de producto escalar

        if(resultado == 0){
            return true; //es ortogonal
        }else{
            return false; //no es ortogonal
        }
    }

}

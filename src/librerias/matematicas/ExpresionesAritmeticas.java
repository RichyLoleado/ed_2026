package librerias.matematicas;
import edlineal.PilaE;

public class ExpresionesAritmeticas {

    public static boolean esOperando(char token){
        if (token == '+' || token == '-' || token == '*' || token == '/' || token == '^' || token == '%' || token == '(' || token == ')'){
            return false;
        }else{
            return true;
        }
    }

    public static boolean esOperando(String token){
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^") || token.equals("%") || token.equals("(") || token.equals(")")){
            return false;
        }else{
            return true;
        }
    }

    public static Double calcular(double op1, double op2, char token){
        if(token == '+') {
            return op1 + op2;
        }else if(token == '-') {
            return op1 - op2;
        }else if(token == '*') {
            return op1 * op2;
        }else if(token == '/') {
            if(op2 == 0){
                return null;
            }else{
                return op1 / op2;
            }
        }else if(token == '^') {
            return Math.pow(op1, op2);
        }else if(token == '%') {
            return op1 % op2;
        }else{
            return null;
        }

    }

    public static Double evaluarPosfija(String posfija){
        PilaE pila = new PilaE(posfija.length());
        for(int cadaToken = 0; cadaToken < posfija.length() - 1; cadaToken++){
            //1. tokenizar de izquierda a derecha
            char token = posfija.charAt(cadaToken);
            //2. si es el token un operando meterlo a la pila
            if(esOperando(token) == true){
               boolean bandera = pila.meter(token + "");
               if(bandera == false){ //no pudo meterlo a la pila
                   return null;
               }
            }else{ //es operador
                //3. si el token es un operador sacamos 2 operando de la pila
                String op2 = pila.sacar() + "";
                String op1 = pila.sacar() + "";
                //los convertimos a double
                double op1D = Double.parseDouble(op1);
                double op2D = Double.parseDouble(op2);
                //4. le aplicamos la operacion del token y el resultado se mete a la pila.
                Double resultadoParcial = calcular(op1D, op2D, token);
                if(resultadoParcial == null){
                    return null;
                }
                boolean bandera = pila.meter(resultadoParcial + "");
                if(bandera == false){
                    return null;
                }
            }
        }
        //4. el resultado final está en la pila.
        Double resultadoFinal = Double.parseDouble((String) pila.sacar());
        return resultadoFinal;
    }

    public static Double evaluarPrefija(String prefija){
        PilaE pila = new PilaE(prefija.length());
        //tokenizar de derecha a izquierda
        for(int cadaToken = prefija.length() - 1; cadaToken > 0; cadaToken--){
            //1. tokenizar de izquierda a derecha
            char token = prefija.charAt(cadaToken);
            //2. si es el token un operando meterlo a la pila
            if(esOperando(token) == true){
                boolean bandera = pila.meter(token + "");
                if(bandera == false){ //no pudo meterlo a la pila
                    return null;
                }
            }else{ //es operador
                //3. si el token es un operador sacamos 2 operando de la pila
                String op1 = pila.sacar() + "";
                String op2 = pila.sacar() + "";
                //los convertimos a double
                double op1D = Double.parseDouble(op1);
                double op2D = Double.parseDouble(op2);
                //4. le aplicamos la operacion del token y el resultado se mete a la pila.
                Double resultadoParcial = calcular(op1D, op2D, token);
                if(resultadoParcial == null){
                    return null;
                }
                boolean bandera = pila.meter(resultadoParcial + "");
                if(bandera == false){
                    return null;
                }
            }
        }


        //4. el resultado final está en la pila.
        Double resultadoFinal = Double.parseDouble((String) pila.sacar());
        return resultadoFinal;
    }

    public static Double evaluarInfija(String infija){
        return null;
    }

    public static String infijaPosfija(String infija){
        return null;
    }

    public static String infijaPrefija(String infija){
        return null;
    }

}

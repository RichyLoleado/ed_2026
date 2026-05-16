package principales;
import edlineal.DatosListaE;
import librerias.ArchivoTextoDatos;
import examenes.RegresionLineal;
public class PrincipalRegresionLineal {
        public static void main(String[] args) {
            //datos de entrada archivo txt
            DatosListaE datosArchivo = ArchivoTextoDatos.leer("C:\\Users\\richy\\Documentos\\MiEspacio\\Universidad\\4toSemestre\\ed_2026\\ed_2026\\imagenes\\datos.txt");
            RegresionLineal regresion = new RegresionLineal();

            //ejecutar programa
            regresion.ejecutar(datosArchivo);
        }
}

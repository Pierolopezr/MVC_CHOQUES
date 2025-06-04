import java.util.ArrayList;

/**
 * @author Piero López
 * Clase encargada de manejar los datos de los coches.
 * Implementa la lógica de acceso y modificación de datos.
 */
public class Model {

    // Almacén de coches creados
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo añade al parking.
     *
     * @param modelo    modelo del coche
     * @param matricula identificador único
     * @return coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        aux.addObserver(new Alarma());  // Añade la alarma como observador
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche por matrícula.
     *
     * @param matricula matrícula a buscar
     * @return coche encontrado o null
     */
    public static Coche getCoche(String matricula) {
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche.
     *
     * @param matricula del coche
     * @param v         nueva velocidad
     * @return velocidad actualizada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Obtiene la velocidad actual del coche por su matrícula.
     *
     * @param matricula del coche
     * @return velocidad actual
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    // Este método permite buscar el coche con la matrícula indicada y añadirle gasolina.
    // Se llama al método "añadirGasolina()" de la clase Coche si el coche existe.
    public static void añadirGasolina(String matricula, int litros) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.añadirGasolina(litros);
        }
    }

    // Este método permite avanzar un coche si tiene gasolina suficiente.
    // Se obtiene el coche y se llama a su método "avanzar(metros)".
    // Devuelve true si avanzó correctamente, o false si no tenía suficiente gasolina.
    public static boolean avanzar(String matricula, int metros) {
        Coche c = getCoche(matricula);
        return c != null && c.avanzar(metros);
    }
}


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
     * @param modelo modelo del coche
     * @param matricula identificador único
     * @return coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche por matrícula.
     * @param matricula matrícula a buscar
     * @return coche encontrado o null
     */
    public static Coche getCoche(String matricula){
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche.
     * @param matricula del coche
     * @param v nueva velocidad
     * @return velocidad actualizada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Obtiene la velocidad actual del coche por su matrícula.
     * @param matricula del coche
     * @return velocidad actual
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}

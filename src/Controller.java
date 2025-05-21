import java.util.ArrayList;

/**
 * @author Piero López
 * Clase encargada de coordinar la lógica entre la vista y el modelo.
 */
public class Controller {

    /**
     * Método de ejemplo que inicializa algunos coches.
     */
    public static void inicio() {
        Model.crearCoche("LaFerrari", "SBC 1234");
        Model.crearCoche("Alpine", "HYU 4567");
        Model.crearCoche("Aston Martin", "FGH 3333");

        // Modifica la velocidad de un coche
        Model.cambiarVelocidad("SBC 1234", 30);
    }

    /**
     * Solicita datos y crea un coche a través del modelo.
     * @return mensaje de confirmación
     */
    public static String crearCoche() {
        String modelo = View.pedirModelo("Modelo del coche a crear?");
        String matricula = View.pedirMatricula("Matricula del coche a crear?");
        Model.crearCoche(modelo, matricula);
        return "Coche creado";
    }

    /**
     * Cambia la velocidad de un coche sumando o restando.
     * @param matricula del coche
     * @param velocidad cambio a aplicar
     * @return true si se cambió correctamente
     */
    private static boolean cambiarVelocidad(String matricula, int velocidad){
        boolean resultado = true;

        try {
            int nuevaVelocidad = velocidad + Model.getVelocidad(matricula);
            Model.cambiarVelocidad(matricula, nuevaVelocidad);
        } catch (NullPointerException e) {
            View.mensajeError("Coche inexistente");
            resultado = false;
        }

        return resultado;
    }

    /**
     * Subir velocidad de un coche.
     * @return mensaje con el resultado
     */
    public static String subirVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres subir la velocidad");
        int velocidad = View.pedirVelocidad("Cuanta velocidad quieres subirle?");
        boolean resultado = cambiarVelocidad(matricula, velocidad);
        return resultado ? "Velocidad cambiada" : "Velocidad no cambiada";
    }

    /**
     * Bajar velocidad de un coche.
     * @return mensaje con el resultado
     */
    public static String bajarVelocidad(){
        String matricula = View.pedirMatricula("Matricula del coche que quieres bajar la velocidad");
        int velocidad = View.pedirVelocidad("Cuanta velocidad quieres bajarle?") * -1;
        boolean resultado = cambiarVelocidad(matricula, velocidad);
        return resultado ? "Velocidad cambiada" : "Velocidad no cambiada";
    }

    /**
     * Devuelve una lista de todos los coches con sus datos.
     * @return lista de descripciones de coches
     */
    public static ArrayList<String> mostrarCoches(){
        ArrayList<Coche> coches = Model.parking;
        ArrayList<String> datosCoches = new ArrayList<>();
        for (Coche coche : coches){
            datosCoches.add("Matricula: " + coche.matricula +
                    ". Modelo: " + coche.modelo +
                    ". Velocidad: " + coche.velocidad + "km/hr");
        }
        return datosCoches;
    }
}

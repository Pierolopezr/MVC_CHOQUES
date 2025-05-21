/**
 * @author Piero López
 * Clase que representa un coche con modelo, matrícula y velocidad.
 */
public class Coche {
    public String modelo;
    public String matricula;
    public Integer velocidad;

    /**
     * Constructor de coche.
     * @param modelo modelo del coche
     * @param matricula matrícula del coche
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0; // Velocidad inicial por defecto
    }
}

import java.util.ArrayList;

/**
 * @author Piero López
 * Clase que representa un coche con modelo, matrícula y velocidad.
 */
public class Coche {
    public String modelo;
    public String matricula;
    public Integer velocidad;
    public Integer gasolina;

    // Lista de observadores que desean ser notificados de eventos
    private ArrayList<GasolinaObserver> observadores = new ArrayList<>();
    /**
     * Constructor de coche.
     * @param modelo modelo del coche
     * @param matricula matrícula del coche
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0; // Velocidad inicial por defecto
        this.gasolina = 0;
    }

    // Este método permite aumentar la cantidad de gasolina del coche.
    // Se suma la cantidad de litros proporcionados al atributo "gasolina".
    public void añadirGasolina(int litros) {
        this.gasolina += litros;
        verificarGasolina();
    }

    // Este método permite que el coche avance cierta cantidad de metros.
    // El coche consume gasolina en función de la velocidad y la distancia recorrida.
    // Fórmula del consumo: consumo = (velocidad * metros) / 1000
    // Si no hay suficiente gasolina, el coche no avanza y retorna false.
    // Si hay gasolina suficiente, se descuenta y retorna true.
    public boolean avanzar(int metros) {
        int consumo = (metros * velocidad) / 1000;
        if (gasolina >= consumo && consumo > 0) {
            gasolina -= consumo;
            verificarGasolina();
            return true;
        } else {
            return false;
        }
    }
    // Permite registrar observadores
    public void addObserver(GasolinaObserver obs) {
        observadores.add(obs);
    }

    // Notifica a los observadores si la gasolina es menor que 10
    private void verificarGasolina() {
        if (this.gasolina < 10) {
            for (GasolinaObserver obs : observadores) {
                obs.alertaGasolinaBaja(this);
            }
        }
    }
}

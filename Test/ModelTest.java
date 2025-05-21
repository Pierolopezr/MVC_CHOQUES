import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Piero López
 * Clase encargada de testear los métodos del modelo (Model)
 */
public class ModelTest {

    /**
     * Limpia el parking antes de cada test para evitar interferencias
     */
    @BeforeEach
    void resetParking() {
        Model.parking.clear();
    }

    /**
     * Test que verifica que al crear un coche, este se añade correctamente al parking
     */
    @Test
    void crearCocheShouldAddCocheToParking() {
        Coche coche = Model.crearCoche("Modelo1", "1234ABC");
        assertNotNull(coche);
        assertEquals("Modelo1", coche.modelo);
        assertEquals("1234ABC", coche.matricula);
    }

    /**
     * Test que verifica que se puede obtener un coche previamente creado mediante su matrícula
     */
    @Test
    void getCocheShouldReturnCocheIfExists() {
        Model.crearCoche("Modelo1", "1234ABC");
        Coche coche = Model.getCoche("1234ABC");
        assertNotNull(coche);
        assertEquals("1234ABC", coche.matricula);
    }

    /**
     * Test que verifica que si un coche no existe, el método getCoche retorna null
     */
    @Test
    void getCocheShouldReturnNullIfCocheDoesNotExist() {
        assertNull(Model.getCoche("9999XYZ"));
    }

    /**
     * Test que verifica que el método cambiarVelocidad modifica correctamente la velocidad del coche
     */
    @Test
    void cambiarVelocidadShouldUpdateCocheVelocidad() {
        Model.crearCoche("Modelo1", "1234ABC");
        int nuevaVelocidad = Model.cambiarVelocidad("1234ABC", 80);
        assertEquals(80, nuevaVelocidad);
    }

    /**
     * Test que comprueba que se obtiene correctamente la velocidad actual del coche
     */
    @Test
    void getVelocidadShouldReturnCorrectValue() {
        Model.crearCoche("Modelo1", "1234ABC");
        Model.cambiarVelocidad("1234ABC", 60);
        assertEquals(60, Model.getVelocidad("1234ABC"));
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @Test
    void crearCocheShouldAddCocheToParking(){
        Model model = new Model();
        Coche coche = model.crearCoche("Modelo1", "1234ABC");
        assertNotNull(coche);
        assertEquals("Modelo1", coche.modelo);
        assertEquals("1234ABC", coche.matricula);
    }
    @Test
    void getCoche(){
    }
    @Test
    void getCocheShouldReturnCocheIfExists(){
        Model model = new Model();
        model.crearCoche("MOdelo1", "1234ABC");
        Coche coche = model.getCoche("1234ABC");
        assertNotNull(coche);
        assertEquals("1234ABC", coche.matricula);
    }
    @Test
    void getCocheShouldReturnNullIdCocheDoesNotExist(){
    Model model = new Model();
    assertNull(model.getCoche("9999XYZ"));
    }
    @Test
    void cambiarVelocidadShouldUpdateCocheVelocidad(){
    Model model = new Model();
    model.crearCoche("Modelo1", "1234ABC");
    int nuevaVelocidad = model.cambiarVelocidad("1234ABC", 80);
    assertEquals(80, nuevaVelocidad);
    }


}
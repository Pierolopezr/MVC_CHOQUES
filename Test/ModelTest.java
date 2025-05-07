import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

}
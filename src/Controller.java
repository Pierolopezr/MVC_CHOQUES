import java.lang.module.ModuleDescriptor;

public class Controller {
    public static void inicio() {
        // Instanciamos la vista y el modelo
        View miView = new View();
        Model miModel = new Model();

        // Crear tres coches
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = miModel.getCoche("SBC 1234");
        // modifica la velocidad
        int nuevaVelocidad = miModel.cambiarVelocidad("SBC 1234", 30);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = View.muestraVelocidad("SBC 1234", Model.getVelocidad("SBC 1234"));


        if (hecho) {
            System.out.println("Correcto");
        } else {
            System.out.println("Error");
        } ;
    }
    public static String crearCoche() {
        String modelo = View.pedirModelo("Modelo del coche a crear?");
        String matricula = View.pedirMatricula("Matricula del coche a crear?");
        Model.crearCoche(modelo, matricula);
        Coche aux  = Model.crearCoche(modelo, matricula);
        return "Coche creado";
    }
}


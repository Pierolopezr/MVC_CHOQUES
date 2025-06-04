import java.util.Scanner;

/**
 * @author Piero López
 * Clase encargada de la interacción con el usuario.
 * Muestra menús y pide información por consola.
 */
public class View {

    /**
     * Muestra el menú principal y gestiona la entrada del usuario.
     */
    public static void menu(){
        int accion = -1;
        Scanner sc = new Scanner(System.in);

        while (accion != 0) {
            // Opciones disponibles
            System.out.println("1, Crear coche");
            System.out.println("2, subir velocidad");
            System.out.println("3, bajar velocidad");
            System.out.println("4, Mostrar todos los coches");
            System.out.println("5, Añadir gasolina");
            System.out.println("6, Avanzar");
            System.out.println("0, Salir");

            accion = sc.nextInt();

            // Manejo del menú según la opción
            switch (accion){
                case 1 -> System.out.println(Controller.crearCoche());
                case 2 -> System.out.println(Controller.subirVelocidad());
                case 3 -> System.out.println(Controller.bajarVelocidad());
                case 4 -> System.out.println(Controller.mostrarCoches());
                case 5 -> System.out.println(Controller.añadirGasolina());
                case 6 -> System.out.println(Controller.avanzar());
                default -> accion = 0; // Salida
            }
        }
    }

    /**
     * Pide el modelo del coche al usuario.
     * @param msg mensaje a mostrar
     * @return modelo ingresado
     */
    public static String pedirModelo(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.next();
    }

    /**
     * Pide la matrícula del coche al usuario.
     * @param msg mensaje a mostrar
     * @return matrícula ingresada
     */
    public static String pedirMatricula(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.next();
    }

    /**
     * Pide una velocidad al usuario.
     * @param msg mensaje a mostrar
     * @return velocidad ingresada
     */
    public static int pedirVelocidad(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextInt();
    }

    public static int pedirCantidad(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextInt();
    }

    /**
     * Muestra un mensaje de error por consola.
     * @param msg mensaje de error
     * @return true si se mostró correctamente
     */
    public static boolean mensajeError(String msg){
        System.out.println(msg);
        return true;
    }
}

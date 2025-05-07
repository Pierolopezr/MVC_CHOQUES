import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {

    /**
     * Menu inicial
     */
    public static void menu(){
        int accion=0;
        Scanner sc = new Scanner(System.in);
        while (accion !=4) {
            System.out.println("1, Crear coche");
            System.out.println("2, Cambiar velocidad");
            System.out.println("3, Mostrar velocidad");
            System.out.println("4, Salir");
            accion=sc.nextInt();
            switch (accion){
                case 1-> {
                    System.out.println(Controller.crearCoche());
                }
                default -> accion=4;
            }
        }
    }

    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    public static String pedirModelo(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        String modelo = sc.next();
        return modelo;
    }

    public static String pedirMatricula(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        String matricula = sc.next();
        return matricula;
    }
}

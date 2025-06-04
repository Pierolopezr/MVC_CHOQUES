public class Alarma implements GasolinaObserver {
    @Override
    public void alertaGasolinaBaja(Coche coche) {
        System.out.println("⚠️ Alerta: Repostar. Coche con matrícula: " + coche.matricula);
    }
}
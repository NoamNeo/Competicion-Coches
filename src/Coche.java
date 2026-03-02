import java.util.Random;

public class Coche {
    private double velocidadMax;
    private String escuderia;
    private double fiabilidad;

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public Coche(double velocidadMax, String escuderia, double fiabilidad) {
        this.velocidadMax = velocidadMax;
        this.escuderia = escuderia;
        this.fiabilidad = fiabilidad;
    }

    public boolean acabaCarrera(int kilometros) {
        int numTramos = kilometros / 5;
        Random rand = new Random();

        for (int i = 0; i < numTramos; i++) {
            if (rand.nextDouble() <= fiabilidad) {
                return false;
            }
        }
        return true;
    }

}

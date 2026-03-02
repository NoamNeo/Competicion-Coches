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

    public double getFiabilidad() {

        return fiabilidad;
    }

    public Coche(double velocidadMax, String escuderia, double fiabilidad) {
        this.velocidadMax= velocidadMax;
        this.escuderia = escuderia;
        this.fiabilidad = fiabilidad;
    }

    public boolean acabaCarrera(int kilometros) {
        double numTramos = kilometros / 5.0;
        Random rand = new Random();

        for (double i = 0; i < numTramos; i += 1.0) {
            int probFallo = rand.nextInt();
            if (probFallo == getFiabilidad()*100) {
                return false;
            }
        }
        return true;
    }

}

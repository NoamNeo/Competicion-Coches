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
        double numTramos = kilometros/5;
        for (int i = 0; i<numTramos;i++){
            Random rand = new Random();
            double probFallo = rand.nextDouble();
            if (probFallo == getFiabilidad()){
                return false;
            }

        }
        return true;
    }
}
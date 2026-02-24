import java.util.Random;

public class Piloto {
    private String nombre;
    private int edad;
    private Coche coche;
    private String habilidad;

    public double velocidadMedia() {
        Random rand = new Random();
        double numAleatorio = rand.nextDouble(0.6,0.9);
        //Pongo siempre menor que 1 porque en una carrera la velocidad media
        //nunca es igual a la velocidad maxima
        double media = coche.getVelocidadMax() * getHabilidad() * numAleatorio;

        return 0;
    }

    public Piloto(String nombre, int edad, Coche coche, String habilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.coche = coche;
//      this.habilidad = habilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Coche getCoche() {
        return coche;
    }

    public double getHabilidad() {
        Random rand = new Random();
        if (habilidad.equals("Excelente")) {
            double habAleatoria = rand.nextDouble(0.9,1);
            return habAleatoria;
        }
        if (habilidad.equals("Bueno")) {
            double habAleatoria = rand.nextDouble(0.8,0.9);
            return habAleatoria;
        }
        if (habilidad.equals("Mediocre")) {
            double habAleatoria = rand.nextDouble(0.7,0.8);
            return habAleatoria;
        }
        return 0;
    }
}
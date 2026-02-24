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

    public float getHabilidad() {
        Random rand = new Random();
        if (habilidad.equals("Excelente")) {
            float habAleatoria = rand.nextFloat(0.9f,1);
            return habAleatoria;
        }
        if (habilidad.equals("Bueno")) {
            float habAleatoria = rand.nextFloat(0.8f,0.9f);
            return habAleatoria;
        }
        if (habilidad.equals("Mediocre")) {
            float habAleatoria = rand.nextFloat(0.7f,0.8f);
            return habAleatoria;
        }
        return 0.6f;
    }
}
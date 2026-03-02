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

        return media;
    }

    public Piloto(String nombre, int edad, Coche coche, String habilidad) {

        this.nombre = nombre;
        this.edad = edad;
        this.coche = coche;

        Random rand = new Random();
        float valor;

        if (habilidad.equals("Excelente")) {
            valor = rand.nextFloat(0.9f, 1f);
        } else if (habilidad.equals("Bueno")) {
            valor = rand.nextFloat(0.8f, 0.9f);
        } else if (habilidad.equals("Mediocre")) {
            valor = rand.nextFloat(0.7f, 0.8f);
        } else {
            valor = 0.6f;
        }


        this.habilidad = Float.toString(valor);
    }



    public String getNombre() {
        return nombre;
    }



    public Coche getCoche() {
        return coche;
    }

    public double getHabilidad() {
        return Double.parseDouble(habilidad);
    }
}
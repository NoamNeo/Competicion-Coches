public class Piloto {
    private String nombre;
    private int edad;
    private Coche coche;
    private float habilidad;

    public double velocidadMedia() {
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
        return habilidad;
    }
}
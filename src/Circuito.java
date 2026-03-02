public class Circuito {
    private String nombre;
    private int longitud;
    private Carrera[] carreras = null;

    public String getNombre() {
        return nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public Circuito(String nombre, int longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
    }

    public void anhadirCarrera(Carrera carrera) {
        Carrera [] anhadirCarrera = new Carrera [carreras.length+1];
        for (int i = 0; i<carreras.length; i++){
            anhadirCarrera[i] = carreras[i];
        }
        anhadirCarrera[anhadirCarrera.length-1] = carrera;

        carreras= anhadirCarrera;
    }

    public int obtenerCarrerasTotales() {

        return carreras.length;
    }
}

public class Circuito {
  private String nombre;
  private int longitud;
  private Carrera[] carreras = null;

  public int obtenerCarrerasTotales() {
    return (carreras == null) ? 0 : carreras.length;
  }

  public void anhadirCarrera(Carrera carrera) {
    int length = (carreras == null) ? 1 : carreras.length + 1;
    Carrera[] buffer = new Carrera[length];
    if (carreras == null) {
      buffer[0] = carrera;
      carreras = buffer;
    } else {
      for (int i = 0; i < carreras.length; i++) {
        buffer[i] = carreras[i];
      }
      buffer[length - 1] = carrera;
      carreras = buffer;
    }
  }
}

public class Competicion {

    private String nombre;
    private Piloto[] participantes;
    private int numPilotos; // Contador para saber cuántos pilotos hay realmente

    private Carrera[] carreras;
    private int numCarreras; // Contador para saber cuántas carreras hay

    public boolean anhadirPiloto(Piloto piloto) {

        return false;

    }

    public int getNumPilotos() {
        return numPilotos;
    }

    public void setNumPilotos(int numPilotos) {
        this.numPilotos = numPilotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
